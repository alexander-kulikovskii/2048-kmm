package by.game.binumbers.di

class BoardModuleTest : BaseKoinTest(
    listOf(
        BoardModule,
        RandomModule,
        mockedStorageModule,
    )
)
