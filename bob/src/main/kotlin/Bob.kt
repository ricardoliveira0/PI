class Bob(question: String){

    init {
        if(question.endsWith('?')){
            println("Sure.")
        }else{
            if(question.endsWith('!')){
                println("Whoa, chill out!")
            }
            else{
                if(question.endsWith("?!") || question.endsWith("!?")){
                    println("Calm down, I know what I'm doing!")
                }
                else{
                    if(question.isEmpty()){
                        println("Fine. Be that way!")
                    }
                    else{
                        println("Whatever.")
                    }
                }
            }
        }
    }
}

fun main(){
    val input = readLine()!!
    val bob = Bob(input)
}