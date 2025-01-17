fun transcribeToRna(dna: String) =
    dna.map {
        when (it) {
            'G' -> 'C'
            'C' -> 'G'
            'T' -> 'A'
            'A' -> 'U'
            else -> throw IllegalArgumentException()
        }
    }
    .joinToString("")