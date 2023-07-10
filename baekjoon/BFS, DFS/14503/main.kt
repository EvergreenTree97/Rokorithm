lateinit var places: Array<IntArray>

const val Cleaned = 2

fun main() {
    with(System.`in`.bufferedReader()) {
        val (M, N) = readLine().split(" ").map(String::toInt)
        val (startY, startX, dir) = readLine().split(" ").map(String::toInt)
        places = Array(M) {
            readLine().split(" ").map(String::toInt).toIntArray()
        }
        dfs(Robot(startY, startX, Direction.from(dir)), M, N)
        places.sumOf { place ->
            place.count { it == Cleaned }
        }.also {
            print(it.toString())
        }
    }
}

fun dfs(robot: Robot, M: Int, N: Int) {
    places[robot.y][robot.x] = Cleaned
    for (i in 0..3) {
        robot.dir.rotate(i).forward(robot.y, robot.x).takeIf {
            (it.y in 0 until M) && (it.x in 0 until N) && places[it.y][it.x] == 0
        }?.also {
            dfs(it.copy(), M, N)
            return
        }
    }
    robot.dir.back(robot.y, robot.x).takeIf {
        (it.y in 0 until M) && (it.x in 0 until N) && places[it.y][it.x] != 1
    }?.also {
        dfs(it.copy(), M, N)
    }
}

data class Robot(
    val y: Int,
    val x: Int,
    val dir: Direction,
)

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(-1, 0, 1, 0)

fun Direction.back(y: Int, x: Int): Robot {
    return when (this) {
        Direction.North, Direction.East -> Robot(y + dy[num + 2], x + dx[num + 2], this)
        Direction.South, Direction.West -> Robot(y + dy[num - 2], x + dx[num - 2], this)
    }
}

fun Direction.forward(y: Int, x: Int): Robot {
    return Robot(y + dy[num], x + dx[num], this)
}

fun Direction.rotate(n: Int): Direction {
    return (((num - n + 3) % 4)).let { Direction.from(it) }
}

enum class Direction(
    val num: Int,
) {
    North(0),
    East(1),
    South(2),
    West(3);

    companion object {
        fun from(num: Int): Direction {
            return when (num) {
                0 -> North
                1 -> East
                2 -> South
                3 -> West
                else -> throw IllegalArgumentException()
            }
        }
    }
}