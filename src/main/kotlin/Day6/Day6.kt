package Day6

fun solvePuzzle1(inputs: List<String>) : Int {
    var groupedInputs = getGroupInputs(inputs)
    var sumOfGroupedInputs = 0

    sumOfGroupedInputs = getAnswer1(groupedInputs, sumOfGroupedInputs)

    return sumOfGroupedInputs
}

fun solvePuzzle2(inputs: List<String>): Int {
    var groupedInputs = getGroupInputs(inputs)
    var sumOfGroupedInputs = 0

    sumOfGroupedInputs = getAnswer2(groupedInputs, sumOfGroupedInputs)

    return sumOfGroupedInputs
}

private fun getAnswer1(
    groupedInputs: List<String>,
    sumOfGroupedInputs: Int
): Int {
    var sumOfGroupedInputs1 = sumOfGroupedInputs
    groupedInputs.forEach { groupInput ->
        sumOfGroupedInputs1 += groupInput.toCharArray().distinct().filter { char -> char != ' ' }.size
    }
    return sumOfGroupedInputs1
}

private fun getAnswer2(
    groupedInputs: List<String>,
    sumOfGroupedInputs: Int
): Int {
    var sumOfGroupedInputs1 = sumOfGroupedInputs
    groupedInputs.forEach { groupInput ->
        var groups = groupInput.groupingBy { it }.eachCount()
        var countLimit = groups.getOrDefault(' ', 0)

        groups.forEach{ entry ->
            if (entry.value == countLimit + 1) {
                sumOfGroupedInputs1++
            }
        }
    }
    return sumOfGroupedInputs1
}

fun getGroupInputs(inputs: List<String>) : List<String> {
    var groupInputs = mutableListOf<String>()

    var groupInput = ""
    inputs.forEach { line ->
        if (!line.isNullOrEmpty()) {
            if (groupInput.isNullOrEmpty())
                groupInput += line
            else
                groupInput += " $line"
        } else {
            groupInputs.add(groupInput)
            groupInput = ""
        }
    }

    return groupInputs
}