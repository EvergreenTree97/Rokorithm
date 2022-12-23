import java.lang.StringBuilder

const val INF =  5000000
fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toInt)
    val dist = LongArray(N + 1)
    dist.fill(INF.toLong())
    dist[1] = 0
    val edges = ArrayList<Edge>()
    repeat(M) {
        val (v1, v2, cost) = readLine().split(" ").map(String::toInt)
        edges.add(Edge(v1, v2, cost))
    }
    var cycle = false
    (1..N).forEach { i ->
        for (edge in edges) {
            if (dist[edge.v1] == INF.toLong()) continue

            if (dist[edge.v2] > dist[edge.v1] + edge.cost) {
                if (i == N) {
                    cycle = true
                    break
                }
                dist[edge.v2] = dist[edge.v1] + edge.cost
            }
        }
    }
    val sb = StringBuilder()
    if (cycle) sb.appendLine("-1")
    else {
        (2..N).forEach { i -> //음수 사이클
            if (dist[i] == INF.toLong()) sb.appendLine("-1")
            else sb.appendLine(dist[i])
        }
    }
    print(sb)
}

data class Edge(
    val v1: Int,
    val v2: Int,
    val cost: Int,
)