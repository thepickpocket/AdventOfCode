package Day9

fun solvePuzzle1(inputs: List<String>, preamble: Int) : Long {
    val maxIndex = (inputs.size - 1) - preamble
    var currentIndex = 0

    while (currentIndex != maxIndex) {
        var preambleList = inputs.subList(currentIndex, currentIndex + preamble).map { it.toLong() }
        var leftovers = inputs.subList(currentIndex + preamble, inputs.size - 1).toMutableList().map { it.toLong() }
        var additions = mutableListOf<Long>()
        for (i in 0..preambleList.size - 1) {
            for (k in i+1..preambleList.size - 1) {
                var value = Math.addExact(preambleList[i], preambleList[k])
                additions.add(value)
            }
        }
        if (!additions.contains(leftovers[0])) {
            return leftovers[0]
        }
        currentIndex++
    }
    return -1
}

fun solvePuzzle2(inputs: List<String>, preamble: Int): Long {
    var invalidValue = solvePuzzle1(inputs, preamble)
    var additions = mutableListOf<Long>()
    var values = inputs.toMutableList().map { it.toLong() }

    values.forEachIndexed { index, value ->
        additions = mutableListOf()
        var added = 0L
        var currentIndex = index
        while (added < invalidValue && added != invalidValue) {
            added += values[currentIndex]
            additions.add(values[currentIndex])
            currentIndex++
        }
        if (added == invalidValue) {
            additions.sort()
            return Math.addExact(additions.first(), additions[additions.lastIndex])
        }
    }

    return -1
}