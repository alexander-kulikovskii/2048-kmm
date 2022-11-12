package by.game.binumbers.base.model

interface Randomizer {

    fun getRandomCell(): CellId

    fun shuffleList(listOfEmptyCells: List<Int>): List<Int>
}
