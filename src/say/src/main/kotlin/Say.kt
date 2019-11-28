private infix fun Int.divisibleBy(another: Int) = this % another == 0

private val ONES = mapOf(
        0 to "zero",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine"
)

private val TENS = mapOf(
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty",
        60 to "sixty",
        70 to "seventy",
        80 to "eighty",
        90 to "ninety"
)

private val LARGE_GROUPS = mapOf(1 to "", 1000 to "thousand", 1000000 to "million", 1000000000 to "billion")

class NumberSpeller {

    fun say(number: Long): String {
        require(number >= 0) { "Input must be non-negative" }
        require(number < 1000000000000) { "Input must be less than 1000000000000" }

        var spoken: String? = null
        for (largeGroup in LARGE_GROUPS.keys.sortedDescending()) {
            val group = (number / largeGroup % 1000).toInt()
            val suffix = " ${LARGE_GROUPS[largeGroup].orEmpty()}".takeIf { it.isNotBlank() } ?: ""

            if (group != 0) {
                spoken = spoken?.plus(" ").orEmpty() + sayHundred(group) + suffix
            }
        }

        return spoken?.takeIf { it.isNotEmpty() } ?: ONES[0].orEmpty()
    }

    private fun sayHundred(group: Int) = when {
        group >= 100 && group divisibleBy 100 -> "${sayOne(group / 100)} hundred"
        group in 100..999 -> "${sayOne(group / 100)} hundred ${sayTen(group % 100)}"
        else -> sayTen(group)
    }

    private fun sayTen(group: Int) = when (group) {
        in TENS -> TENS[group].orEmpty()
        in 16..19 -> "${ONES[group % 10].orEmpty()}teen"
        in 20..99 -> "${TENS[(group / 10) * 10].orEmpty()}-${sayOne(group % 10)}"
        else -> sayOne(group % 10)
    }

    private fun sayOne(group: Int) = ONES[group].orEmpty()
}