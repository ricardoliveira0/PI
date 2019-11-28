class DiamondPrinter {
    fun printToList(given: Char): List<String> {
        val range = ('A'..given).toList()
        val size = range.size * 2 - 1
        val middle = size / 2
        val result = mutableListOf<String>()
        range.forEachIndexed { i, c ->
            val line = CharArray(size) { ' ' }
            line[middle - i] = c
            line[middle + i] = c
            result.add(line.joinToString(""))
        }
        return result + result.dropLast(1).reversed()
    }
}