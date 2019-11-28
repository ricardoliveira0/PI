class School {

	private var database: MutableMap<Int, List<String>> = mutableMapOf()

    fun db(): Map<Int, List<String>> = database.toMap()

    fun add(student: String, grade: Int) {
        val oldRoster = database[grade] ?: emptyList()
        database.put(grade, oldRoster + student)
    }

    fun grade(grade: Int): List<String> = database[n] ?: emptyList()

    fun sort(): Map<Int, List<String>> = database.to.SortedMap()
    	.mapValues {(_, v) -> v.sorted()}
}
