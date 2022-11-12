package by.game.binumbers.base.util

import io.kotest.core.spec.style.scopes.BehaviorSpecWhenContainerScope
import io.mockk.MockKVerificationScope
import io.mockk.Ordering
import io.mockk.verify

@Suppress("LongParameterList")
suspend fun BehaviorSpecWhenContainerScope.Verify(
    name: String,
    ordering: Ordering = Ordering.UNORDERED,
    inverse: Boolean = false,
    atLeast: Int = 1,
    atMost: Int = Int.MAX_VALUE,
    exactly: Int = -1,
    timeoutMillis: Long = 0,
    verifyBlock: MockKVerificationScope.() -> Unit,
) = Then(name) {
    verify(
        ordering = ordering,
        inverse = inverse,
        atLeast = atLeast,
        atMost = atMost,
        exactly = exactly,
        timeout = timeoutMillis,
        verifyBlock = verifyBlock,
    )
}

@Suppress("LongParameterList")
suspend fun BehaviorSpecWhenContainerScope.VerifyNo(
    name: String,
    ordering: Ordering = Ordering.UNORDERED,
    inverse: Boolean = false,
    timeoutMillis: Long = 0,
    verifyBlock: MockKVerificationScope.() -> Unit,
) = Verify(
    name,
    ordering,
    inverse,
    exactly = 0,
    timeoutMillis = timeoutMillis,
    verifyBlock = verifyBlock
)
