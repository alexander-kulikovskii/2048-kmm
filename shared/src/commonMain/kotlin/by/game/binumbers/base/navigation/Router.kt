package by.game.binumbers.base.navigation

import by.game.binumbers.base.BinumbersNavigation

interface Router {

    fun navigateWithCommand(navigationCommand: BinumbersNavigation)
}

class RouterImpl(
    private val routeChecker: RouteChecker = RouteCheckerImpl(),
    private val throwException: Boolean = true,
    private val blockNavigation: (FromScreen, ToScreen, Boolean) -> Unit,
    private val blockPopUp: (FromScreen, ToScreen, Int) -> Unit,
) : Router {

    private fun navigateTo(from: FromScreen, to: ToScreen, inclusiveScreen: Boolean) {
        if (routeChecker.checkRoute(from, to)) {
            blockNavigation.invoke(from, to, inclusiveScreen)
        } else {
            if (throwException) {
                throw NavigationException("Can't navigate from <${from.screen.route}> to <${to.screen.route}>")
            }
        }
    }

    private fun popBack(from: FromScreen, to: ToScreen, removeLast: Int = 1) {
        if (routeChecker.checkRoute(from, to)) {
            blockPopUp.invoke(from, to, removeLast)
        } else {
            if (throwException) {
                throw NavigationException("Can't pop up back from <${from.screen.route}> to <${to.screen.route}>")
            }
        }
    }

    override fun navigateWithCommand(navigationCommand: BinumbersNavigation) {
        when (navigationCommand) {
            is Navigation ->
                navigateTo(
                    from = navigationCommand.from,
                    to = navigationCommand.to,
                    inclusiveScreen = navigationCommand.inclusiveScreen,
                )
            is PopBack -> popBack(
                from = navigationCommand.from,
                to = navigationCommand.to,
                removeLast = navigationCommand.removeCount
            )
            else -> throw NavigationException("Unsupported navigation type")
        }
    }
}
