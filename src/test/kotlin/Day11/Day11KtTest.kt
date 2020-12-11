package Day11

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day11KtTest {
    @Test
    fun testSampleInput() {
        val inputs = readFile("day11/sample1.txt")

        val answer1 = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        assertEquals(37, answer1)
        assertEquals(26, answer2)
    }

    @Test
    fun testFullInput() {
        val inputs = readFile("day11/fullInput.txt")

        val answer1 = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        println("Day 11 Answer 1: $answer1")
        assertEquals(2222, answer1)

        println("Day 11 Answer 2: $answer2")
        assertEquals(2032, answer2)
    }
}