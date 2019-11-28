import java.util.*

enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <E> List<E>.relationshipTo(list: List<E>): Relationship {
    return when {
        this == list -> Relationship.EQUAL
        Collections.indexOfSubList(this, list) >= 0 -> Relationship.SUPERLIST
        Collections.indexOfSubList(list, this) >= 0 -> Relationship.SUBLIST
        else -> Relationship.UNEQUAL
    }
}