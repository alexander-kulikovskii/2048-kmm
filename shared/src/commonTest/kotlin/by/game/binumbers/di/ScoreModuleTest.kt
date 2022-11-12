package by.game.binumbers.di

class ScoreModuleTest : BaseKoinTest(
    listOf(
        ScoreModule,
        mockedStorageModule,
    )
)
