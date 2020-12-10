package Day10

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day10KtTest {
    @Test
    fun solveSample1Input() {
        val inputs = readFile("day10/sample1.txt")

        val answer1 = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        assertEquals(35, answer1)
        assertEquals(8, answer2)
    }

    @Test
    fun solveSample2Input() {
        val inputs = readFile("day10/sample2.txt")

        val answer1 = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        assertEquals(220, answer1)
        assertEquals(19208, answer2)
    }

    @Test
    fun solveFullInput() {
        val inputs = readFile("day10/fullInput.txt")

        val answer1 = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        println("Day 10 Answer 1: $answer1")
        assertEquals(1980, answer1)

        println("Day 10 Answer 2: $answer2")
        assertEquals(4628074479616, answer2)
    }
}