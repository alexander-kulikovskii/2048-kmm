package by.game.binumbers.di

class LevelsModuleTest : BaseKoinTest(
    listOf(
        LevelsModule,
        mockedStorageModule,
    )
)
