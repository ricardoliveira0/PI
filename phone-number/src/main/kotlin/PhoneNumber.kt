data class PhoneNumber(val input: String) {

    val number: String by lazy { isTenDigit() }
    val codeArea: String = number.take(3)
    private val middleNo = number.drop(3).take(3)
    private val lastNo = number.takeLast(4)

}