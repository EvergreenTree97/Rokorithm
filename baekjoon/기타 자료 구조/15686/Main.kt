import kotlin.collections.ArrayList
import kotlin.math.abs

var min = Int.MAX_VALUE
var temp = 0
val houses = ArrayList<Pair<Int, Int>>()
val chickens = ArrayList<Pair<Int, Int>>()
lateinit var compareAnswer: Array<Pair<Int, Int>>
lateinit var visited: BooleanArray
var N = 0
var M = 0
fun main() = with(System.`in`.bufferedReader()) {
    val a = readLine().split(" ").map { it.toInt() }
    N = a[0]
    M = a[1]
    visited = BooleanArray(13)
    compareAnswer = Array(M) { Pair(0, 0) }
    for (i in 0 until N) {
        val read = readLine().split(" ").map { it.toInt() }
        for (j in read.indices) {
            if (read[j] == 1) {
                houses.add(Pair(i, j))
            } else if (read[j] == 2) {
                chickens.add(Pair(i, j))
            }
        }
    }
    dfs(0, 0)
    print(min)
}

fun dfs(count: Int, start: Int) {
    if (count == M) {
        temp = 0
        houses.forEach { h ->
            var t = Int.MAX_VALUE
            compareAnswer.forEach { c ->
                t = t.coerceAtMost(getDist(c.first, h.first, c.second, h.second))
            }
            temp += t
        }
        min = min.coerceAtMost(temp)
        return
    }
    for (i in start until chickens.size) {
        if (!visited[i]) {
            visited[i] = true
            compareAnswer[count] = chickens[i]
            dfs(count + 1, i)
            visited[i] = false
        }
    }
}


fun getDist(x1: Int, x2: Int, y1: Int, y2: Int): Int {
    return (abs(x2.toDouble() - x1.toDouble()) + abs(y2.toDouble() - y1.toDouble())).toInt()
}