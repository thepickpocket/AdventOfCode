package Day1

/**
 * 1. 'it' is used inside a lambda to refer to its parameter implicitly
 * 2. 'hashset' is an optimization in search - O(1)
 * 3. kotlin allows for 'nested'/'local' functions
 */

fun solvePuzzle1(inputValues: List<String>, sumToMatch: Int): Int {
    val values = inputValues.map { it.toInt() }.toHashSet()

    return values.filter { values.contains(sumToMatch - it) }
        .let { it[0] * it[1] }
}

fun solvePuzzle2(inputValues: List<String>, sumToMatch: Int): Int {
    val values = inputValues.map { it.toInt() }.toHashSet()

    fun filterSecondNumber(addUpTo: Int) = values.filter { values.contains(addUpTo - it) }

    return values
        .filter { filterSecondNumber(sumToMatch - it).isNotEmpty() }
        .let { it[0] * it[1] * it[2] }
}