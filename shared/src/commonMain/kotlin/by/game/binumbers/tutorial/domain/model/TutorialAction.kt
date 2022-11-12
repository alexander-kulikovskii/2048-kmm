package by.game.binumbers.tutorial.domain.model

import by.game.binumbers.base.BinumbersAction

sealed class TutorialAction : BinumbersAction {
    object Load : TutorialAction()
    object OnClickDone : TutorialAction()
}
