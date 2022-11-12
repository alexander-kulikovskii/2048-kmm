package by.game.binumbers.base.navigation

import by.game.binumbers.base.BinumbersNavigation

data class Navigation(
    val from: FromScreen,
    val to: ToScreen,
    val inclusiveScreen: Boolean = false,
) : BinumbersNavigation

data class PopBack(
    val from: FromScreen,
    val to: ToScreen,
    val removeCount: Int,
) : BinumbersNavigation
