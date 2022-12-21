import java.util.PriorityQueue

lateinit var g: Array<ArrayList<Node>>
lateinit var dist: IntArray
lateinit var result: IntArray
const val INF = 1000 * 1000

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toInt)
    g = Array(N + 1) { ArrayList() }
    dist = IntArray(N + 1)
    result = IntArray(N+1)
    repeat(M) {
        val (start, end, cost) = readLine().split(" ").map(String::toInt)
        g[start].add(Node(end, cost))
        g[end].add(Node(start, cost))
    }
    dijkstra(1)
    StringBuilder().apply {
        appendLine(N-1)
        (2 .. N).forEach {
            appendLine("$it ${result[it]}")
        }
    }.also { print(it) }
}

fun dijkstra(start: Int) {
    dist.apply {
        fill(INF)
        this[start] = 0
    }
    val queue = PriorityQueue<Node>().apply {
        add(Node(start, 0))
    }
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (dist[current.node] < current.cost) continue

        g[current.node].forEach { other ->
            if (dist[other.node] > current.cost + other.cost) { //현재 가지고 있는 정보를 통해 최단 거리를 갱신하는 구간
                dist[other.node] = current.cost + other.cost
                result[other.node] = current.node // 최단 거리를 갱신 할 때 그냥 넣어주면 될 듯 ?
                queue.add(Node(other.node, dist[other.node]))
            }
        }
    }
}

data class Node(
    val node: Int,
    val cost: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.cost.compareTo(other.cost)
    }
}

// 회선은 양방향 비용 그래프 형태이고, 다른 그래프를 거쳐서 다익스트라를 통해 최단 거리를 구하는게 최선이다. - 간선 수가 N-1 이라는 뜻
// 1번 컴퓨터는 슈퍼컴

// 복구할 회선 갯수와
// 복구한 회선 나열