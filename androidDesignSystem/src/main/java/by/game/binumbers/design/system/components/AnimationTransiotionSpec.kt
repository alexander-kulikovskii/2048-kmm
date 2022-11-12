package by.game.binumbers.design.system.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with

@OptIn(ExperimentalAnimationApi::class)
internal val transitionSpec: AnimatedContentScope<Long>.() -> ContentTransform = {
    if (targetState > initialState) {
        slideInVertically { height -> height } + fadeIn() with slideOutVertically { height -> -height } + fadeOut()
    } else {
        slideInVertically { height -> -height } + fadeIn() with slideOutVertically { height -> height } + fadeOut()
    }.using(
        SizeTransform(clip = false)
    )
}
