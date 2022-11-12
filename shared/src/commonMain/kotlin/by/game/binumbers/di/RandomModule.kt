package by.game.binumbers.di

import by.game.binumbers.base.model.Randomizer
import by.game.binumbers.base.model.RandomizerImpl
import org.koin.dsl.module
import kotlin.random.Random

internal val RandomModule = module {
    single { RandomizerImpl(Random) as Randomizer }
}
