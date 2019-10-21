import java.util.*
import kotlin.collections.ArrayList

class Change(val amount: Int, val coins: IntArray){
    var  change = ArrayList<Int>(0)
    var aux = amount
    var array = coins
    init {
        while (aux != 0){

             if (coins.isNotEmpty()){

                if(aux >= array.max()!!){

                    aux -= array.max()!!
                    change.add(array.max()!!)

                }else{
                    val max = array.max()
                    val index = array.indexOf(max!!)
                    array[index] = 0
                }
            }

        }
        println(change)
    }
}

fun main(){
    val moedas = intArrayOf(1,5,10,25,100)
    val reader = Scanner(System.`in`)
    print("Money to change: ")
    val input = reader.nextInt()
    val change = Change(input,moedas)
}