package Day1

import helpers.readFile
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1KtTest {
    @Test
    fun sampleInputTest() {
        val inputs = readFile("day1/sample1.txt");

        val answer = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        println("Answer: $answer")
        assertEquals(514579, answer)

        println("Answer 2: $answer2")
        assertEquals(241861950, answer2)
    }

    @Test
    fun fullInputTest() {
        val inputs = readFile("day1/fullInput.txt");

        val answer = solvePuzzle1(inputs)
        val answer2 = solvePuzzle2(inputs)

        println("Answer: $answer")
        assertEquals(444019, answer)

        println("Answer 2: $answer2")
        assertEquals(29212176, answer2)
    }
}