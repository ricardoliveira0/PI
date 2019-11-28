class RomanNumeral {
    companion object {
        fun value(inp: Int): String {
            val stringBuilder = StringBuilder()

            val thousands = inp / 1000
            stringBuilder.append(times(thousands, "M"))

            val hundreds = inp / 100 % 10
            stringBuilder.append(times(hundreds, "C", "D", "M"))

            val tens = inp / 10 % 10
            stringBuilder.append(times(tens, "X", "L", "C"))

            val ones = inp % 10
            stringBuilder.append(times(ones, "I", "V", "X"))


            return String(stringBuilder)
        }

        private fun times(number: Int, char: String): String {
            val stringBuilder = StringBuilder()
            for (i in 0.. number - 1) {
                stringBuilder.append(char)
            }
            return String(stringBuilder)
        }

        private fun times(number: Int, onesChar: String, fivesChar: String, tensChar: String): String {
            when (number) {
                0 -> return ""
                1, 2, 3 -> return times(number, onesChar)
                4 -> return onesChar + fivesChar
                5, 6, 7, 8 -> return fivesChar + times(number - 5, onesChar)
                9 -> return onesChar + tensChar
                else -> throw IllegalArgumentException("Only single digits allowed - not " + number)
            }
        }
    }
}