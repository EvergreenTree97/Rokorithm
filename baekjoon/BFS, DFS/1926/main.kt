import java.util.*

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, -1, 0, 1)
lateinit var map: Array<IntArray>
lateinit var visited: Array<BooleanArray>
var N = 0
var M = 0

fun main() {
    with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).also {
            N = it[0]
            M = it[1]
        }
        map = Array(N) {
            readLine().split(" ").map(String::toInt).toIntArray()
        }
        visited = Array(N) {
            BooleanArray(M) { false }
        }
        var max = 0
        var count = 0
        for (x in map.indices) {
            for (y in map[x].indices) {
                if (visited[x][y].not() && map[x][y] == 1) {
                    count++
                    max = max.coerceAtLeast(bfs(x, y))
                }
            }
        }
        println(count)
        println(max)
    }
}

fun bfs(
    x: Int,
    y: Int,
): Int {
    var size = 0
    val queue: Queue<IntArray> = LinkedList<IntArray>().apply {
        visited[x][y] = true
        size++
        add(intArrayOf(x, y))
    }
    while ((queue.isNotEmpty())) {
        val (curX, curY) = queue.poll()
        for (i in 0..3) {
            val nextX = curX + dx[i]
            val nextY = curY + dy[i]
            if (nextX in 0 until N
                && nextY in 0 until M
                && map[nextX][nextY] == 1
                && visited[nextX][nextY].not()
            ) {
                size++
                visited[nextX][nextY] = true
                queue.add(intArrayOf(nextX, nextY))
            }
        }
    }
    return size
}
