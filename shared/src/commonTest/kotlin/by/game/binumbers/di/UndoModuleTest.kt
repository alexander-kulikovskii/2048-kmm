package by.game.binumbers.di

class UndoModuleTest : BaseKoinTest(
    listOf(
        UndoModule,
        mockedStorageModule,
    )
)
