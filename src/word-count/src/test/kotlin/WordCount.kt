
fun WordCount(phrase: String){
    val words = ArrayList<String>()
    val word = ""

    for(letter in phrase){
        if(letter != " " || letter.hasNext()){
            word += letter
        }else{
                words.add(word)
        }
    }

    print(words)
}
fun main(){
    WordCount("ola ola adeus")
}