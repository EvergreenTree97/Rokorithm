import java.util.*

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (R, C) = readLine().split(" ").map { it.toInt() }
    val map = Array(R) {
        CharArray(C)
    }
    val dp = Array(R) {
        IntArray(C)
    }
    var start: Node = Node(0, 0, '*')
    val queue: Queue<Node> = LinkedList<Node>()
    for (i in 0 until R) {
        val line = readLine()
        for (j in 0 until C) {
            map[i][j] = line[j]
            if (map[i][j] == 'S') start = Node(i, j, 'S')
            else if (map[i][j] == '*') queue.add(Node(i, j, '*'))
        }
    }
    queue.add(start)
    var answer = 0
    while (!queue.isEmpty()) {
        val node = queue.poll()
        if (node.value == 'D') {
            answer = dp[node.x][node.y]
        }
        // 3. 연결된 곳을 순회 -> 좌, 우, 위, 아래
        for (i in 0..3) {
            val nextX = node.x + dx[i]
            val nextY = node.y + dy[i]
            if (nextX in 0 until R && nextY in 0 until C) {
                if (node.value == '.' || node.value == 'S') { // 4. 갈 수 있는가? ( 고슴도치 ) -> . or D, 방문하지 않은 곳
                    if ((map[nextX][nextY] == '.' || map[nextX][nextY] == 'D') && dp[nextX][nextY] == 0) {
                        dp[nextX][nextY] = dp[node.x][node.y] + 1
                        queue.offer(Node(nextX, nextY, map[nextX][nextY]))
                    }
                } else if (node.value == '*') {
                    if (map[nextX][nextY] == '.') {
                        map[nextX][nextY] = '*'
                        queue.offer(Node(nextX, nextY, map[nextX][nextY]))
                    }
                }
            }
        }
    }
    if (answer == 0) {
        print("KAKTUS")
    } else {
        print(answer.toString())
    }
}

data class Node(
    val x: Int,
    val y: Int,
    val value: Char,
)
