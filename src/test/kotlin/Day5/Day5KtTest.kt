package Day5

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5KtTest {
    @Test
    fun testSampleInput() {
        var inputs = readFile("day5/sample1.txt")

        var answer1 = solvePuzzle1(inputs)

        assertEquals(820, answer1)
    }

    @Test
    fun testFullInput() {
        var inputs = readFile("day5/fullInput.txt")

        var answer1 = solvePuzzle1(inputs)
        var answer2 = solvePuzzle2(inputs)

        println("Day 5 Answer 1: $answer1")
        assertEquals(894, answer1)

        println("Day 5 Answer 2: $answer2")
        assertEquals(579, answer2)
    }
}