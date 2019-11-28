object Isogram {
    fun isIsogram (input:String):Boolean {
        val alphabet = 'a'..'z'
        for(char in input) {
            if(alphabet.contains(char.toLowerCase()) && input.count { currentChar -> char.equals(currentChar, true) } > 1) {
                return false
            }
        }
        return true
    }
}