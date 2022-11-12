package by.game.binumbers.tutorial.domain.generated

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.Store
import by.game.binumbers.tutorial.domain.model.TutorialAction
import by.game.binumbers.tutorial.domain.model.TutorialSideEffect

typealias TutorialStore = Store<TutorialState, TutorialAction, TutorialSideEffect, BinumbersNavigation>
