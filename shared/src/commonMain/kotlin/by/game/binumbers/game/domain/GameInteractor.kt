package by.game.binumbers.game.domain

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.extension.emitNavigation
import by.game.binumbers.base.extension.emitPopBack
import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.Area.Companion.IMPOSSIBLE_AREA
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.movement.MoveDirection
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.base.navigation.fromScreen
import by.game.binumbers.base.navigation.toScreen
import by.game.binumbers.board.domain.BoardUseCasesFacade
import by.game.binumbers.game.domain.generated.GameState
import by.game.binumbers.game.domain.generated.GameStore
import by.game.binumbers.game.domain.model.GameAction
import by.game.binumbers.game.domain.model.GameSideEffect
import by.game.binumbers.game.domain.usecase.MakeMoveUseCase
import by.game.binumbers.score.domain.ScoreUseCasesFacade
import by.game.binumbers.tutorial.domain.usecase.TutorialIsAlreadyShownUseCase
import by.game.binumbers.undo.domain.UndoUseCasesFacade
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.max

const val INITIAL_SCORE = 0L

@Suppress("TooManyFunctions")
class GameInteractor(
    private val interactorDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val scoreUseCasesFacade: ScoreUseCasesFacade,
    private val boardUseCasesFacade: BoardUseCasesFacade,
    private val undoUseCasesFacade: UndoUseCasesFacade,
    private val makeMoveUseCase: MakeMoveUseCase,
    private val tutorialIsAlreadyShownUseCase: TutorialIsAlreadyShownUseCase,
) : GameStore, CoroutineScope by CoroutineScope(interactorDispatcher) {

    private var currentLevelId: MutableStateFlow<LevelId> = MutableStateFlow(LevelId.L_IMPOSSIBLE)
    private var area: MutableStateFlow<Area> = MutableStateFlow(IMPOSSIBLE_AREA)
    private var prevArea: MutableStateFlow<Area> = MutableStateFlow(IMPOSSIBLE_AREA)
    private var score = MutableStateFlow(INITIAL_SCORE)
    private var prevScore = MutableStateFlow(INITIAL_SCORE)
    private var undo = MutableStateFlow(0L to true)

    private val state = MutableStateFlow(GameState.initial)
    private val sideEffect = MutableSharedFlow<GameSideEffect>()
    private val navigation = MutableSharedFlow<BinumbersNavigation>()

    override fun observeState(): StateFlow<GameState> = state
    override fun observeSideEffect(): Flow<GameSideEffect> = sideEffect
    override fun observeNavigation(): Flow<BinumbersNavigation> = navigation

    @Suppress("ComplexMethod", "LongMethod")
    override fun dispatch(action: GameAction) {
        val oldState = state.value
        val newState = when (action) {
            is GameAction.Load -> {
                // TODO load if smth needed
                oldState
            }
            // TODO add pause listener
            is GameAction.OnClickBack -> {
                stopGameAndSaveValues(oldState)
            }
            is GameAction.StartGame -> {
                checkIfTutorialNotShown()
                startNewGame(action, oldState)
                oldState
            }
            is GameAction.EndGame -> {
                stopGameAndSaveValues(oldState)
            }
            GameAction.OnMoveLeft -> {
                makeMove(MoveDirection.MOVE_LEFT, oldState)
            }
            GameAction.OnMoveRight -> {
                makeMove(MoveDirection.MOVE_RIGHT, oldState)
            }
            GameAction.OnMoveUp -> {
                makeMove(MoveDirection.MOVE_UP, oldState)
            }
            GameAction.OnMoveDown -> {
                makeMove(MoveDirection.MOVE_DOWN, oldState)
            }
            is GameAction.OnUndoClick -> {
                makeUndo(oldState)
            }
            is GameAction.OnPauseClick -> {
                launch {
                    navigation.emitNavigation(
                        from = Screen.Game(currentLevelId.value).fromScreen(),
                        to = Screen.Pause.toScreen(),
                    )
                }
                oldState
            }
            GameAction.Start -> {
                launch {
                    loadLevel(oldState, currentLevelId.value)
                }
                oldState
            }
            GameAction.Pause -> {
                launch {
                    saveGameValues()
                }
                oldState
            }
            else -> {
                oldState
            }
        }
        if (newState != oldState) {
            state.value = newState
        }
    }

    private fun startNewGame(action: GameAction.StartGame, oldState: GameState) {
        val newLevelId = LevelId.getLevelIdById(action.id.toInt())
        if (newLevelId != currentLevelId.value) { // Start new level. reload state
            currentLevelId.value = newLevelId
            launch {
                loadLevel(oldState, currentLevelId.value)
            }
        }
    }

    private suspend fun loadLevel(oldState: GameState, levelId: LevelId) {
        score.value = scoreUseCasesFacade.restoreCurrentScore(levelId)
        prevScore.value = scoreUseCasesFacade.restorePreviousScore(levelId)
        area.value = boardUseCasesFacade.restoreOrCreateCurrentBoard(levelId)
        prevArea.value = boardUseCasesFacade.restoreOrCreatePreviousBoard(levelId)
        undo.value = undoUseCasesFacade.restoreUndoCount(levelId) to
            undoUseCasesFacade.restoreUndoEnabled(levelId)
        state.value = oldState.copy(
            progress = false,
            cells = area.value.cellsAsList(),
            width = area.value.width,
            height = area.value.height,
            score = score.value,
            undoCount = undo.value.first,
            undoEnabled = undo.value.second,
        )
    }

    private fun stopGameAndSaveValues(oldState: GameState): GameState {
        launch {
            saveGameValues()
            navigation.emitPopBack(
                from = Screen.Game(currentLevelId.value).fromScreen(), // TODO fix leveId
                to = Screen.Levels.toScreen(),
            )
//            score.value = INITIAL_SCORE
//            currentLevelId.value = LevelId.L_IMPOSSIBLE
//            undo.value = LevelId.L_IMPOSSIBLE.maxUndoCount to false
        }
        return oldState.copy(
            progress = false,
            cells = emptyList(),
            score = score.value,
            undoCount = undo.value.first,
            undoEnabled = undo.value.second,
        )
    }

    private suspend fun saveGameValues() {
        boardUseCasesFacade.saveCurrentBoard(
            levelId = currentLevelId.value,
            area.value.cellsAsList()
        )
        boardUseCasesFacade.savePreviousBoard(
            levelId = currentLevelId.value,
            prevArea.value.cellsAsList()
        )

        scoreUseCasesFacade.saveCurrentScore(
            levelId = currentLevelId.value,
            score.value
        )
        scoreUseCasesFacade.savePreviousScore(
            levelId = currentLevelId.value,
            prevScore.value
        )
        undoUseCasesFacade.saveUndoCount(levelId = currentLevelId.value, undo.value.first)
        undoUseCasesFacade.saveUndoEnabled(levelId = currentLevelId.value, undo.value.second)
    }

    private fun makeMove(moveDirection: MoveDirection, oldState: GameState): GameState {
        val moveResult = makeMoveUseCase.invoke(moveDirection, area.value, score.value)
        return if (moveResult.first) {
            prevArea.value = area.value
            prevScore.value = score.value
            area.value = moveResult.second
            score.value = moveResult.third
            if (area.value.checkWin()) {
                // todo mark next level as enable
                // todo add to stats
            }
            // TODO check win
            // TODO check lose
            // TODO update max cell
            undo.value = undo.value.copy(second = true)
            oldState.copy(
                cells = area.value.cellsAsList(),
                score = score.value,
//                undoCount = max(0, oldState.undoCount - 1),
                undoEnabled = true,
            )
        } else {
            oldState
        }
    }

    private fun makeUndo(oldState: GameState): GameState {
        return if (oldState.undoCount > 0 && oldState.undoEnabled) {
            area.value = prevArea.value
            score.value = prevScore.value

            oldState.copy(
                cells = area.value.cellsAsList(),
                undoCount = max(0, oldState.undoCount - 1),
                undoEnabled = false,
                score = score.value,
            )
        } else {
            oldState
        }
    }

    private fun checkIfTutorialNotShown() {
        launch {
//            delay(500)
            val shown = tutorialIsAlreadyShownUseCase.invoke()
            if (shown.not()) {
                navigation.emitNavigation(
                    from = Screen.Game(currentLevelId.value).fromScreen(),
                    to = Screen.Tutorial.toScreen(),
                )
            }
        }
    }
}
