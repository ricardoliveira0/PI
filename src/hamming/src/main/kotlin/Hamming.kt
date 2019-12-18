object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        if(leftStrand != rightStrand)
        	throw IllegalArgumentException()
        return leftStrand.zip(rightStrand).count { it.first != it.second }
    }
}
