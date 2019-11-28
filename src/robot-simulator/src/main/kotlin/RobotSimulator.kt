class Robot(var gridPosition: GridPosition, var orientation: Orientation = Orientation.NORTH) {
    private fun move(coordinate: Char, amount: Int) {
        return when (coordinate) {
            'x' -> gridPosition = GridPosition(gridPosition.x + amount, gridPosition.y)
            'y' -> gridPosition = GridPosition(gridPosition.x, gridPosition.y + amount)
            else -> {
            }
        }
    }

    fun advance() = when (orientation) {
        Orientation.EAST -> move('x', 1)
        Orientation.WEST -> move('x', -1)
        Orientation.NORTH -> move('y', 1)
        Orientation.SOUTH -> move('y', -1)
    }

    fun simulate(s: String) {
        s.forEach {
            when (it) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> advance()
            }
        }
    }

    private fun valueOf(value: Int): Orientation = Orientation.values().find { it.ordinal == value }!!

    fun turnLeft() {
        orientation = valueOf((orientation.ordinal + 4 - 1) % 4)
    }

    fun turnRight() {
        orientation = valueOf((orientation.ordinal + 1) % 4)
    }

}