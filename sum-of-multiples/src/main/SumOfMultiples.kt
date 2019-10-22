class SumOfMultiples {
    companion object {
        fun sum(multiples: Set<Int>, max: Int): Int {
            val result = mutableSetOf<Int>()
            for (multiple in multiples) {
                for (number in (multiple until max step multiple)) {
                    result += number
                }
            }

            return result.sum()
        }
    }
}