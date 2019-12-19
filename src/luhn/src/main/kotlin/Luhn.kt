object Luhn {

    fun isValid(input: String): Boolean {
        val noSpacesInput = input.filter { it != ' ' }
        if (noSpacesInput.any { !it.isDigit() }) return false

        val length = noSpacesInput.length
        if (length <= 1) return false

        val noSpacesInputInt = noSpacesInput.map { Character.getNumericValue(it) }.toMutableList()
        for (i in (length - 2) downTo 0 step 2) {
            var value = noSpacesInputInt[i] * 2
            if (value > 9) {
                value -= 9
            }
            noSpacesInputInt[i] = value
        }
        return noSpacesInputInt.sum() % 10 == 0
    }

}