package change.src.main.kotlin

import java.lang.IllegalArgumentException

class ChangeCalculator(coinList: List<Int>) {
    private var lista = coinList.sorted()

    fun computeMostEfficientChange(value : Int) : List<Int>{

        var change = ArrayList<Int>()
        var aux = value

        if (value < lista.min()!!){
            throw IllegalArgumentException("The total $value cannot be represented in the given currency.")
        }
        if(value < 0){
            throw IllegalArgumentException("Negative totals are not allowed.")
        }
        while (0 < aux){
            if (aux >= lista.max()!!){
                aux -= lista.max()!!
                change.add(lista.max()!!)
            }else{
                lista.drop(lista.max()!!)
            }
        }
        return change
    }
}