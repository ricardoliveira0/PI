class Triangle(a: Double, b: Double, c: Double) {

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    val isEquilateral: Boolean = a == b && b == c

    val isScalene: Boolean = a != b && b != c && a != c

    val isIsosceles: Boolean = a == b || a == c || b == c

    init {
        require(a > 0 && b > 0 && c > 0)
        require(a + b >= c && a + c >= b && b + c >= a)
    }

}