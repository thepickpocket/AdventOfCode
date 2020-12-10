package Day7

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BagTest {
    @Test
    fun solveSampleInput() {
        val inputs = readFile("day7/sample1.txt")

        val answer1 = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        assertEquals(4, answer1)
        assertEquals(32, answer2)
    }

    @Test
    fun solveFullInput() {
        val inputs = readFile("day7/fullInput.txt")

        val answer1 = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        println("Day 7 Answer 1: $answer1")
        assertEquals(179, answer1)

        println("Day 7 Answer 2: $answer2")
        assertEquals(18925, answer2)
    }
}