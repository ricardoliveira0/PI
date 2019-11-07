data class PhoneNumber(val input: String) {

    val number: String by lazy { isTenDigit() }
    val codeArea: String = number.take(3)
    private val middleNo = number.drop(3).take(3)
    private val lastNo = number.takeLast(4)

    private fun isTenDigit(): String { 
    	val digits = input.filter { it.isDigit() } * Caso tenha o primeiro digito (1), este será removido.

    	if (digits.first() == '1') {
        	require(digits.length == 11) { "11 digits with country code (1)" }
        	return digits.drop(1)
    	}

    	require(digits.length == 10) { "Must be 10 digits excluding country code" }
    	return digits
    }



}