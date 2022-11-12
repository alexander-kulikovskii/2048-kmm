package by.game.binumbers.base.model

import kotlin.random.Random

class RandomizerImpl(private val random: Random) : Randomizer {

    override fun getRandomCell(): CellId = if (random.nextInt(RANDOM_UNTIL) == 0) {
        CellId.C_4
    } else {
        CellId.C_2
    }

    override fun shuffleList(listOfEmptyCells: List<Int>): List<Int> {
        return listOfEmptyCells.shuffled()
    }

    private companion object {
        private const val RANDOM_UNTIL = 10
    }
}
