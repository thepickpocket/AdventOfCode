package Day4

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4KtTest {
    @Test
    fun solveSampleInput() {
        var inputs = readFile("day4/sample1.txt")

        var answer1 = solvePuzzle1(inputs)

        assertEquals(2, answer1)
    }

    @Test
    fun solveSampleInput2() {
        var inputs = readFile("day4/sample2.txt")

        var answer2 = solvePuzzle2(inputs)

        assertEquals(4, answer2)
    }

    @Test
    fun solveFullInput() {
        var inputs = readFile("day4/fullInput.txt")

        var answer1 = solvePuzzle1(inputs)
        var answer2 = solvePuzzle2(inputs)

        println("Day 4 Answer 1: $answer1")
        assertEquals(192, answer1)

        println("Day 4 Answer 2: $answer2")
        assertEquals(101, answer2)
    }
}