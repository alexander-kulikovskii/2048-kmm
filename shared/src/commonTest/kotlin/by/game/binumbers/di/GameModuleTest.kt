package by.game.binumbers.di

class GameModuleTest : BaseKoinTest(
    listOf(
        GameModule,
        BoardModule,
        ScoreModule,
        UndoModule,
        TutorialModule,
        RandomModule,
        mockedStorageModule,
    )
)
