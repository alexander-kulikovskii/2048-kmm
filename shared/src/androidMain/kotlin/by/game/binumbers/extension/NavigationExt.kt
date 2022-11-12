package by.game.binumbers.extension

import androidx.navigation.NavController
import by.game.binumbers.base.navigation.FromScreen
import by.game.binumbers.base.navigation.ToScreen

fun NavController.navigateTo(from: FromScreen, to: ToScreen, inclusiveScreen: Boolean = false) {
    this.navigate(to.screen.route) {
        if (inclusiveScreen) {
            popUpTo(from.screen.route) { inclusive = true }
        }
    }
}
