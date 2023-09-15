import java.util.*
import kotlin.math.abs

var N: Int = 0
var L: Int = 0
var R: Int = 0

lateinit var visited: Array<BooleanArray>
lateinit var map: Array<IntArray>
lateinit var unions: MutableList<Union>

fun main() {
    with(System.`in`.bufferedReader()) {
        with(System.out.bufferedWriter()) {
            readLine().split(" ").map(String::toInt).run {
                N = this[0]
                L = this[1]
                R = this[2]
            }
            map = Array(N) {
                readLine().split(" ").map { it.toInt() }.toIntArray()
            }

            var day = 0
            while (true) {
                visited = Array(N) {
                    BooleanArray(N) { false }
                }
                unions = mutableListOf()
                for (i in 0 until N) {
                    for (j in 0 until N) {
                        if (visited[i][j].not()) {
                            unions.add(findSection(i, j))
                        }
                    }
                }
                var flag = false
                unions.forEach {
                    val average = it.sum / it.points.size
                    it.points.apply {
                        if (size > 1) {
                            flag = true
                        }
                        forEach { node ->
                            map[node.x][node.y] = average
                        }
                    }
                }
                if (flag.not()) {
                    break
                }
                //인구 이동이 가능한 날짜 증가
                day++
            }
            print(day)

            close()
        }
        close()
    }
}

fun findSection(x: Int, y: Int): Union {
    val union = Union()
    val queue: Queue<Node> = LinkedList<Node>().apply {
        visited[x][y] = true
        Node(x, y).also {
            add(it)
            union.points.add(it)
            union.sum += map[x][y]
        }
    }
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (i in 0..3) {
            val nextX = current.x + dx[i]
            val nextY = current.y + dy[i]
            if (nextX in 0 until N
                && nextY in 0 until N
            ) {
                if (visited[nextX][nextY].not()) {
                    if (abs(map[current.x][current.y] - map[nextX][nextY]) in L..R) {
                        visited[nextX][nextY] = true
                        Node(nextX, nextY).also {
                            queue.add(it)
                            union.apply {
                                points.add(it)
                                sum += map[nextX][nextY]
                            }
                        }
                    }
                }
            }
        }
    }
    return union
}

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)

data class Node(
    val x: Int,
    val y: Int
)

data class Union(
    var sum: Int = 0,
    val points: MutableList<Node> = mutableListOf(),
)
