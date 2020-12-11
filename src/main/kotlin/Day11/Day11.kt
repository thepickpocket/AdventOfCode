package Day11

import java.lang.IndexOutOfBoundsException

private val adjacents = listOf(
    -1 to -1,
    -1 to 0,
    -1 to 1,
    0 to -1,
    0 to 1,
    1 to -1,
    1 to 0,
    1 to 1
)

fun solvePuzzle1(inputs: List<String>): Int {

    val input = inputs.map { it.toList() }

    return simulateSeats(input, 1)
}

fun solvePuzzle2(inputs: List<String>): Int {
    val input = inputs.map { it.toList() }

    return simulateSeats(input, 2)
}

private fun simulateSeats(seats: List<List<Char>>, puzzleNumber: Int): Int {
    val currentState = seats.map { it.toCharArray() }.toTypedArray()
    val prevState = Array(currentState.size) { CharArray(seats[0].size) }

    do {
        currentState.forEachIndexed { y, row ->
            row.forEachIndexed { x, c ->
                prevState[y][x] = c
            }
        }

        prevState.forEachIndexed { y, row ->
            row.forEachIndexed { x, c ->
                val neighbors = countAdjacents(puzzleNumber, prevState, x, y)
                val maxNeighbors = if (puzzleNumber == 1) 4 else 5
                when {
                    c == 'L' && neighbors == 0 -> currentState[y][x] = '#'
                    c == '#' && neighbors >= maxNeighbors -> currentState[y][x] = 'L'
                }
            }
        }
    } while (!currentState.contentDeepEquals(prevState))

    return prevState.sumBy { row -> row.count { c -> c == '#' } }
}

private fun countAdjacents(puzzleNumber: Int, seats: Array<CharArray>, posX: Int, posY: Int): Int {
    return adjacents.count { (dirX, dirY) ->
        if (puzzleNumber == 1)
            isNextToSeat(seats, posX, posY, dirX, dirY)
        else
            isImmediateNextToSeat(seats, posX, posY, dirX, dirY)
    }
}

private fun isNextToSeat(seats: Array<CharArray>, posX: Int, posY: Int, dirX: Int, dirY: Int): Boolean {
    return try {
        seats[posY + dirY][posX + dirX] == '#'
    } catch (e: IndexOutOfBoundsException) {
        false
    }
}

private fun isImmediateNextToSeat(seats: Array<CharArray>, posX: Int, posY: Int, dirX: Int, dirY: Int): Boolean {
    try {
        var i = 0
        while (true) {
            i++
            val nextSeat = seats[posY + dirY * i][posX + dirX * i]
            if (nextSeat == '#')
                return true
            else if (nextSeat == 'L')
                return false
        }
    } catch (e: IndexOutOfBoundsException) {
        return false
    }
}