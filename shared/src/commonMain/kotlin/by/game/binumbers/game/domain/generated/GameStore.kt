package by.game.binumbers.game.domain.generated

import `by`.game.binumbers.base.BinumbersNavigation
import `by`.game.binumbers.base.Store
import by.game.binumbers.game.domain.model.GameAction
import by.game.binumbers.game.domain.model.GameSideEffect

typealias GameStore = Store<GameState, GameAction, GameSideEffect, BinumbersNavigation>
