package Day8

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day8KtTest {
    @Test
    fun solveSampleInput() {
        var input = readFile("day8/sample1.txt")

        var answer1 = solvePuzzle1(input)
        var answer2 = solvePuzzle2(input)

        assertEquals(5, answer1)
        assertEquals(8, answer2)
    }

    @Test
    fun solveFullInput() {
        var input = readFile("day8/fullInput.txt")

        var answer1 = solvePuzzle1(input)
        var answer2 = solvePuzzle2(input)

        println("Day 8 Answer 1: $answer1")
        assertEquals(1749, answer1)

        println("Day 8 Answer 2: $answer2")
        assertEquals(515, answer2)
    }
}