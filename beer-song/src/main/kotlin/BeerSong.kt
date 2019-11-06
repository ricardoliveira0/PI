object BeerSong {

    val lyrics: String by lazy { songVerses(99, 0) }

    fun songVerses(n: Int): String {
        require(n in (0..99)) { "Beer song can only start at 99 and end at 0!" }

        val singularOrPlural = if (n - 1 > 1) "bottles" else "bottle"

        return when (n) {
            in 2..99 -> "$n bottles of beer on the wall, $n bottles of beer.\nTake one down and pass it around, ${n-1} $singularOrPlural of beer on the wall.\n"
            1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
            0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
            else -> ""
        }
    }

    fun songVerses(startingBottles: Int, endingBottles: Int): String =
        (startingBottles downTo endingBottles).map { songVerses(it) }.joinToString(separator = "\n")
}