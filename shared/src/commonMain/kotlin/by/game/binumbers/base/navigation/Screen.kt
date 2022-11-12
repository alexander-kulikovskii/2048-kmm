package by.game.binumbers.base.navigation

import by.game.binumbers.base.model.LevelId
import kotlin.jvm.JvmInline

const val GAME_ROUTE_LEVEL_ID = "levelId"
const val GAME_ROUTE = "game/{$GAME_ROUTE_LEVEL_ID}"

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Main : Screen("main")
    data class Game(val id: LevelId? = null) : Screen("game/${id?.id}")
    object Tutorial : Screen("tutorial")
    object Levels : Screen("levels")
    object Settings : Screen("settings")
    object Pause : Screen("pause")
    object Faq : Screen("faq")
    object Statistics : Screen("statistics")
    object WinOrLose : Screen("win_or_lose")
}

@JvmInline
value class FromScreen(val screen: Screen)

@JvmInline
value class ToScreen(val screen: Screen)

fun Screen.fromScreen() = FromScreen(this)

fun Screen.toScreen() = ToScreen(this)
