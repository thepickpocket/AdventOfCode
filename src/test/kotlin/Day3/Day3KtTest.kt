package Day3

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3KtTest {
    @Test
    fun testSampleInput() {
        var slopes = setOf<IntArray>(intArrayOf(1, 1), intArrayOf(3, 1), intArrayOf(5, 1), intArrayOf(7, 1), intArrayOf(1, 2))
        var inputMap = readFile("day3/sample1.txt")

        var answer1 = solvePuzzle1(inputMap, 3, 1)
        var answer2 = solvePuzzle2(slopes, inputMap)

        assertEquals(7, answer1)
        assertEquals(336, answer2)
    }

    @Test
    fun testFullInput() {
        var slopes = setOf<IntArray>(intArrayOf(1, 1), intArrayOf(3, 1), intArrayOf(5, 1), intArrayOf(7, 1), intArrayOf(1, 2))
        var inputMap = readFile("day3/fullInput.txt")

        var answer1 = solvePuzzle1(inputMap, 3, 1)
        var answer2 = solvePuzzle2(slopes, inputMap)

        println("Day 3 Answer 1: $answer1")
        assertEquals(244, answer1)

        println("Day 3 Answer 2: $answer2")
        assertEquals(9406609920, answer2)
    }
}