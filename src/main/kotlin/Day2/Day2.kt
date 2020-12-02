package Day2

fun solvePuzzle1(inputLines: List<String>): Int {
    var counter = 0

    inputLines.forEach{ input ->
        var minValue = input.subSequence(0, input.indexOf("-")).toString().toInt()
        var maxValue = input.subSequence(input.indexOf("-") + 1, input.indexOf(" ")).toString().toInt()
        var character = input.subSequence(input.indexOf(" ") + 1, input.indexOf(":")).get(0)
        var password = input.substring(input.indexOf(":") + 2)

        var results = password.groupingBy { it }.eachCount()

        if (results.containsKey(character) && results.getValue(character)!! in minValue..maxValue)
            counter++
    }

    return counter
}

fun solvePuzzle2(inputLines: List<String>): Int {
    var counter = 0

    inputLines.forEach{ input ->
        var minValue = input.subSequence(0, input.indexOf("-")).toString().toInt() - 1
        var maxValue = input.subSequence(input.indexOf("-") + 1, input.indexOf(" ")).toString().toInt() - 1
        var character = input.subSequence(input.indexOf(" ") + 1, input.indexOf(":")).get(0)
        var password = input.substring(input.indexOf(":") + 2)

        if ((password[minValue] == character || password[maxValue] == character) && !(password[minValue] == character && password[maxValue] == character))
            counter++
    }

    return counter
}