package Day2

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2KtTest {
    @Test
    fun testSampleInput() {
        var inputLines = readFile("day2/sample1.txt")

        var answer1 = solvePuzzle1(inputLines)
        var answer2 = solvePuzzle2(inputLines)

        println("Day 2 Answer 1: $answer1")
        assertEquals(2, answer1)

        println("Day 2 Answer 2: $answer2")
        assertEquals(1, answer2)
    }

    @Test
    fun testFullInput() {
        var inputLines = readFile("day2/fullInput.txt")

        var answer1 = solvePuzzle1(inputLines)
        var answer2 = solvePuzzle2(inputLines)

        println("Day 2 Answer 1: $answer1")
        assertEquals(548, answer1)

        println("Day 2 Answer 2: $answer2")
        assertEquals(502, answer2)
    }
}