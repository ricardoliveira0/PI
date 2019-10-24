
in (6..8) -> five + (6..base).map(){one}.joinToString("")
5 -> "" + five
4 -> "" + one + five
in (1..3) -> (1..base).map(){one}.joinToString("")
0 -> ""
else -> throw IllegalStateException("Math is broken ${base}")