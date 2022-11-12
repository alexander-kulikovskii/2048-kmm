package by.game.binumbers.screen.pause

class PauseClickFacade(
    val onBackClick: () -> Unit = {},
    val onBackToLevelsClick: () -> Unit = {},
    val onResumeClick: () -> Unit = {},
    val onRestartClick: () -> Unit = {},
    val onSettingsClick: () -> Unit = {},
)
