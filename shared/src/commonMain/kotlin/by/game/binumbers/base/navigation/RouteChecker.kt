package by.game.binumbers.base.navigation

interface RouteChecker {

    fun checkRoute(from: FromScreen, to: ToScreen): Boolean
}

class RouteCheckerImpl : RouteChecker { // TODO add test for all possible screen actions

    @Suppress("ComplexMethod", "ReturnCount")
    override fun checkRoute(from: FromScreen, to: ToScreen): Boolean {
        if (to.screen is Screen.Game) {
            return when (from.screen) {
                is Screen.Levels -> true
                is Screen.Tutorial -> true
                is Screen.Pause -> true
                else -> false
            }
        }
        if (from.screen is Screen.Game) {
            return when (to.screen) {
                is Screen.Levels -> true
                is Screen.Tutorial -> true
                is Screen.Pause -> true
                is Screen.WinOrLose -> true
                else -> false
            }
        }
        return when (Pair(from.screen, to.screen)) {
            Screen.Splash to Screen.Main -> true
            Screen.Main to Screen.Levels -> true
            Screen.Levels to Screen.Main -> true
            Screen.Main to Screen.Settings -> true
            Screen.Settings to Screen.Main -> true
            Screen.Main to Screen.Statistics -> true
            Screen.Statistics to Screen.Main -> true
            Screen.Main to Screen.Faq -> true
            Screen.Faq to Screen.Main -> true
            Screen.Pause to Screen.Game() -> true
            Screen.Pause to Screen.Levels -> true
            Screen.WinOrLose to Screen.Game() -> true
            Screen.WinOrLose to Screen.Levels -> true // TODO or to main?
            Screen.Game() to Screen.Settings -> true // TODO should we add such transaction?
            Screen.Settings to Screen.Game() -> true // TODO should we add such transaction?
            else -> false
        }
    }
}
