package Day7

/**
 * this was cray -_-
 * Utilizing doubly linked graphs
 */
data class Bag(val color: String) {
    val containsBagWithCount = mutableMapOf<Bag, Int>()
    val containedInBags = mutableListOf<Bag>()
}

fun solvePuzzle1(inputs: List<String>): Int {
    val bags = buildGraph(inputs)

    fun traverseParents(bag: Bag?): Set<Bag> =
        bag?.let { bag.containedInBags.plus(bag.containedInBags.flatMap { traverseParents(it) }).toSet() } ?: emptySet()

    return traverseParents(bags["shiny gold"]).size
}

fun solvePuzzle2(inputs: List<String>): Int {
    val bags = buildGraph(inputs)

    fun count(bag: Bag?): Int = bag?.let { 1 + bag.containsBagWithCount.map { it.value * count(it.key) }.sum() } ?: 0
    return (count(bags["shiny gold"]) - 1)
}

fun buildGraph(bagInputs: List<String>): MutableMap<String, Bag> {
    val bags = mutableMapOf<String, Bag>()

    bagInputs.forEach {
        val (bagString, other) = it.split(" bags contain ")

        bags.getOrPut(bagString) { Bag(bagString) }
            .apply {
                containsBagWithCount.putAll(
                    other.split(" bags, ", " bag, ")
                        .map {
                            it.replace(" bags.", "")
                                .replace(" bag.", "")
                                .replace("no other", "")
                        }
                        .filter(CharSequence::isNotEmpty)
                        .associate {
                            val (count, color) = Regex("""(\d) (.*)""").find(it)!!.destructured

                            val contained = bags.getOrPut(color) { Bag(color) }
                            contained.containedInBags.add(this)

                            Pair(contained, count.toInt())
                        }
                )
            }
    }

    return bags
}