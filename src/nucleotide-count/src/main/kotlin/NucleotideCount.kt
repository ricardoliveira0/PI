class Dna(  val sequence : String ) {
    init {
        val nucleotides = "ACGT"
        require(sequence.all { it in nucleotides })
    }
    val nucleotideCounts = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0) + sequence.groupingBy{ it }.eachCount()
}