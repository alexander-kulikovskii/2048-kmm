package by.game.binumbers.di

class TutorialModuleTest : BaseKoinTest(
    listOf(
        TutorialModule,
        mockedStorageModule,
    )
)
