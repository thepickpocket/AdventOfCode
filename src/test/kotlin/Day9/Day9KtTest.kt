package Day9

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day9KtTest {
    @Test
    fun solveSampleInput() {
        val inputs = readFile("day9/sample1.txt")

        val answer1 = solvePuzzle1(inputs, 5)
        val answer2 = solvePuzzle2(inputs, 5)

        assertEquals(127, answer1)
        assertEquals(62, answer2)
    }

    @Test
    fun solveFullInput() {
        val inputs = readFile("day9/fullInput.txt")

        val answer1 = solvePuzzle1(inputs, 25)
        val answer2 = solvePuzzle2(inputs, 25)

        println("Day 9 Answer 1: $answer1")
        assertEquals(41682220, answer1)

        println("Day 9 Answer 2: $answer2")
        assertEquals(5388976, answer2)
    }
}