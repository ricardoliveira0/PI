data class Anagram(val word: String) {
    // TODO: implement proper constructor to complete the task

    fun match(anagrams: Collection<String>): Set<String> {
        val wordMap = mapWord(word)
        val copyAnagrams = anagrams
        var result = mutableSetOf<String>()
        copyAnagrams.forEach { anagram ->
            if(checkAnagram(anagram, wordMap))
                result.add(anagram)
        }
        println(result)
        return result
    }
    fun mapWord(string: String): Map<Char, Int>{
        var map = mutableMapOf<Char, Int>()
        string.toLowerCase().forEach { char ->
            map[char]?.let{ value ->
                map[char] = value+1
            }?: map.put(char, 1)
        }
        return map
    }
    fun checkAnagram(string: String, wordMap: Map<Char, Int>): Boolean{
        if(string.toLowerCase() == word.toLowerCase())
            return false
        var map = wordMap.toMutableMap()
        string.toLowerCase().forEach { char ->
            if(map.containsKey(char).not())
                return false
            map[char]?.let{ value ->
                map[char] = value-1
                if(map[char]!! == 0)
                    map.remove(char)
            }
        }
        return map.isEmpty()
    }
}