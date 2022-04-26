import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val INF = Int.MAX_VALUE
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val map = Array(M) { IntArray(N) }
    val dist = Array(M) { IntArray(N){ INF } }
    for (i in 0 until M) {
        map[i] = readLine().map { it.code - '0'.code }.toIntArray()
    }

    class Node(val x: Int, val y: Int,val count: Int) : Comparable<Node>{
        override fun compareTo(other: Node): Int {
            return this.count.compareTo(other.count)
        }
    }

    val queue = PriorityQueue<Node>()
    queue.add(Node(0, 0, 0))
    dist[0][0] = 0
    var res = Integer.MAX_VALUE
    while (!queue.isEmpty()) {
        val cur = queue.poll()
        if (cur.x == N - 1 && cur.y == M - 1) {
            res = res.coerceAtMost(cur.count)
            break
        }
        for (i in 0..3) {
            val nextX = cur.x + dx[i]
            val nextY = cur.y + dy[i]
            if ((nextX in 0 until N) && (nextY in 0 until M)) {
                if(dist[nextY][nextX] > cur.count + map[nextY][nextX]){
                    dist[nextY][nextX] = cur.count+map[nextY][nextX]
                    queue.add(Node(nextX,nextY,dist[nextY][nextX]))
                }
            }
        }
    }
    print(res)
}
/*
* 1.
* */