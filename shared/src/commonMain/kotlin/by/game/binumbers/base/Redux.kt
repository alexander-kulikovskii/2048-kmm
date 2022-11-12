package by.game.binumbers.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface BinumbersState
interface BinumbersAction
interface BinumbersEffect
interface BinumbersNavigation

interface Store<S : BinumbersState, A : BinumbersAction, E : BinumbersEffect, N : BinumbersNavigation> {
    fun observeState(): StateFlow<S>
    fun observeSideEffect(): Flow<E>
    fun observeNavigation(): Flow<N>
    fun dispatch(action: A)
}
