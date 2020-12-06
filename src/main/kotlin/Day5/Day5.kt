package Day5

import kotlin.math.ceil

fun solvePuzzle1(inputs: List<String>): Long {
    var seatIds = mutableListOf<Long>()
    inputs.forEach{input ->
        var rowNumber = getRowNumber(input.subSequence(0, 7).toString().toCharArray())
        var columnNumber = getColumnNumber(input.subSequence(7, input.length).toString().toCharArray())
        seatIds.add((rowNumber.toLong() * 8) + columnNumber)
    }

    return seatIds.maxOrNull() ?: 0
}

fun solvePuzzle2(inputs: List<String>): Long {
    var seatIds = mutableListOf<Long>()
    inputs.forEach{input ->
        var rowNumber = getRowNumber(input.subSequence(0, 7).toString().toCharArray())
        var columnNumber = getColumnNumber(input.subSequence(7, input.length).toString().toCharArray())
        seatIds.add((rowNumber.toLong() * 8) + columnNumber)
    }

    val seatMapping = seatIds.sorted().windowed(2, 1).first{(a, b) -> a + 1 != b}

    return seatMapping[0] + 1
}

fun getRowNumber(rowPositioning: CharArray): Int {
    var topLimit = 127
    var bottomLimit = 0


    rowPositioning.forEach { position ->
        var calc = ceil((topLimit - bottomLimit).div(2.0)).toInt()
        when (position) {
            'B' -> bottomLimit += calc
            'F' -> topLimit -= calc
        }
    }

    return minOf(topLimit, bottomLimit)
}

fun getColumnNumber(columnPositioning: CharArray): Int {
    var topLimit = 7
    var bottomLimit = 0

    columnPositioning.forEach { column ->
        var calc = ceil((topLimit - bottomLimit).div(2.0)).toInt()
        when (column) {
            'L' -> topLimit -= calc
            'R' -> bottomLimit += calc
        }
    }

    return maxOf(topLimit, bottomLimit)
}