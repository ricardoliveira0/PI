object BeerSong {

    val lyrics: String by lazy { songVerses(99, 0) }

    fun songVerses(n: Int): String {
        require(n in (0..99)) { "Beer song can only start at 99 and end at 0!" }

        val bottleOrBottles = if (n - 1 > 1) "bottles" else "bottle"
    }
}