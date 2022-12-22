val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, -1, 0, 1)
val hashMap = hashMapOf<Char, Int>()
lateinit var arr: Array<CharArray>
lateinit var visited: Array<BooleanArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toInt)
    arr = Array(M) { //M과 N을 헷갈리지 않아야 함
        readLine().toCharArray()
    }
    visited = Array(M) {
        BooleanArray(N)
    }
    (0 until M).forEach { i ->
        (0 until N).forEach { j ->
            if (!visited[i][j]) {
                bfs(i, j, arr[i][j], N, M)
            }
        }
    }
    print("${hashMap.getOrDefault('W', 0)} ${hashMap.getOrDefault('B', 0)}")
}

fun bfs(i: Int, j: Int, soldier: Char, N: Int, M: Int) {
    val queue = ArrayList<Pair<Int, Int>>().apply {
        add(Pair(i,j))
    }
    var count = 0
    while (queue.isNotEmpty()) {
        val (curX, curY) = queue.removeAt(0).let { it.first to it.second }
        if (!visited[curX][curY]) {
            visited[curX][curY] = true
            count++
            (0..3).forEach { dir ->
                val nextX = curX + dx[dir]
                val nextY = curY + dy[dir]
                if (nextX in 0 until M &&
                    nextY in 0 until N &&
                    arr[nextX][nextY] == soldier) {
                    queue.add(Pair(nextX, nextY))

                }
            }
        }
    }
    hashMap[soldier] = hashMap.getOrDefault(soldier, 0) + count * count
}

