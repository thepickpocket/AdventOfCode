package Day8

fun solvePuzzle1(inputs: List<String>): Int {
    var accumulator = 0
    var calculatedIndex = 0

    var operationList = mutableListOf<Pair<String, Int>>()
    inputs.forEach { input -> operationList.add(Pair(input, 0)) }

    while (calculatedIndex < operationList.size && operationList[calculatedIndex].second == 0) {
        var input = inputs[calculatedIndex]
        operationList[calculatedIndex] = operationList[calculatedIndex].copy(second = 1)
        when (getOperation(input)) {
            "acc" -> {
                accumulator += getValue(input)
                calculatedIndex++
            }
            "jmp" -> {
                calculatedIndex += getValue(input)
            }
            "nop" -> {
                calculatedIndex++
            }
        }
    }

    return accumulator
}

fun solvePuzzle2(inputs: List<String>): Int {
    var accumulator = 0
    var calculatedIndex = 0

    inputs.forEachIndexed{ index, input ->
        var mutableInputs = inputs.toMutableList()
        if (getOperation(mutableInputs[index]) == "jmp")
            mutableInputs[index] = mutableInputs[index].replace("jmp", "nop")
        else if (getOperation(mutableInputs[index]) == "nop")
            mutableInputs[index] = mutableInputs[index].replace("nop", "jmp")

        var operationList = mutableListOf<Pair<String, Int>>()
        mutableInputs.forEach { input -> operationList.add(Pair(input, 0)) }

        while (calculatedIndex < operationList.size && operationList[calculatedIndex].second == 0) {
            var input = operationList[calculatedIndex]
            operationList[calculatedIndex] = operationList[calculatedIndex].copy(second = 1)
            when (getOperation(input.first)) {
                "acc" -> {
                    accumulator += getValue(input.first)
                    calculatedIndex++
                }
                "jmp" -> {
                    calculatedIndex += getValue(input.first)
                }
                "nop" -> {
                    calculatedIndex++
                }
            }
        }

        if (operationList[operationList.size - 1].second == 1) {
            return accumulator
        }

        accumulator = 0
        calculatedIndex = 0
    }

    return accumulator

}

private fun getOperation(input: String): String {
    return input.subSequence(0, input.indexOf(' ')).toString()
}

private fun getValue(input: String): Int {
    val value = input.substring(input.indexOf(' '))
    if (value.contains('+'))
        return value.substring(value.indexOf('+')).toInt()
    else
        return -Math.abs(value.substring(value.indexOf('-')).toInt())
}