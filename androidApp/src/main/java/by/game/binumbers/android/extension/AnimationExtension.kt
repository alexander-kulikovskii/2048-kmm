package by.game.binumbers.android.extension

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry

private const val SPEED_MS = 300

@OptIn(ExperimentalAnimationApi::class)
internal fun AnimatedContentScope<NavBackStackEntry>.slideIntoRight() =
    slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(SPEED_MS))

@OptIn(ExperimentalAnimationApi::class)
internal fun AnimatedContentScope<NavBackStackEntry>.slideIntoLeft() =
    slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(SPEED_MS))

@OptIn(ExperimentalAnimationApi::class)
internal fun AnimatedContentScope<NavBackStackEntry>.slideOutOfRight() =
    slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(SPEED_MS))

@OptIn(ExperimentalAnimationApi::class)
internal fun AnimatedContentScope<NavBackStackEntry>.slideOutOfLeft() =
    slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(SPEED_MS))
