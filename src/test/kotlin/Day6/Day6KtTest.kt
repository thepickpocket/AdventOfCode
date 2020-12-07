package Day6

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day6KtTest {
    @Test
    fun solveSampleInput() {
        var inputs = readFile("day6/sample1.txt")

        var answer1 = solvePuzzle1(inputs)
        var answer2 = solvePuzzle2(inputs)

        assertEquals(11, answer1)
        assertEquals(6, answer2)
    }

    @Test
    fun solveFullInput() {
        var inputs = readFile("day6/fullInput.txt")

        var answer1 = solvePuzzle1(inputs)
        var answer2 = solvePuzzle2(inputs)

        println("Day 6 Answer 1: $answer1")
        assertEquals(6809, answer1)

        println("Day 6 Answer 2: $answer2")
        assertEquals(3394, answer2)
    }
}