package Day3

fun solvePuzzle1(mapLines: List<String>, horizontal: Int, vertical: Int): Int {
    var treeCount = 0
    var calculatedIndex = 0
    var calculatedLine = 0
    while (mapLines.size > calculatedLine) {
        var line = mapLines[calculatedLine]
        var newLine = line
        while (calculatedIndex > newLine.length -1)
            newLine += line
        if (newLine[calculatedIndex] == '#')
            treeCount++
        calculatedIndex += horizontal
        calculatedLine += vertical
    }

    return treeCount
}

fun solvePuzzle2(slopes: Set<IntArray>, inputMap: List<String>): Long {
    var treeCountSet = mutableListOf<Int>()
    slopes.forEach { slope ->
        treeCountSet.add(solvePuzzle1(inputMap, slope[0], slope[1]))
    }

    println("Tree count set is: $treeCountSet")
    return treeCountSet.map{it.toLong()}.reduce { acc, i -> acc * i }
}