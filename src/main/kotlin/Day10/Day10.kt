package Day10

fun solvePuzzle1(inputs: List<String>): Int {
    var startJoltage = 0L
    val sortedJoltageAdapters = inputs.map { it.toLong() }.sorted()
    var countings = mutableMapOf<Int, Int>()

    for (joltageAdapter in sortedJoltageAdapters) {
        val difference = Math.subtractExact(joltageAdapter, startJoltage).toInt()
        if (joltageAdapter >= startJoltage && (difference in 1..3)) {
            countings.putIfAbsent(difference, 0)
            countings.replace(difference, countings.getOrDefault(difference, 0) + 1)

            startJoltage = joltageAdapter
        }
    }

    // last one is always a difference of 3
    countings.replace(3, countings.getOrDefault(3, 0) + 1)

    return Math.multiplyExact(countings.getOrDefault(1, 0), countings.getOrDefault(3, 0))
}

fun solvePuzzle2(inputs: List<String>): Long {
    val nums = inputs.map { it.toLong() }.toMutableList()

    val dp = ArrayList<Long>(nums.size + 2)
    val all = ArrayList<Long>(nums.size + 2).apply {
        add(0)
        addAll(nums.sorted())
        add(last() + 3)
    }

    for (i in all.indices) {
        when (i) {
            0, 1 -> dp.add(1)
            else -> {
                dp.add(
                    (if (all[i] - all[i - 1] < 4) dp[i - 1] else 0) +
                            (if (all[i] - all[i - 2] < 4) dp[i - 2] else 0) +
                            (if (i > 2 && all[i] - all[i - 3] < 4) dp[i - 3] else 0)
                )
            }
        }
    }

    return dp.last()
}