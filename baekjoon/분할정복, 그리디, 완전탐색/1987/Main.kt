val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, -1, 0, 1)
var check = BooleanArray(26)
var visited: Array<BooleanArray> = arrayOf()
var map: Array<IntArray> = arrayOf()
var R = 0
var C = 0
fun main() = with(System.`in`.bufferedReader()) {
    val maps = readLine().split(" ").map { it.toInt() }
    R = maps[0]
    C = maps[1]
    map = Array(R) { IntArray(C) }
    visited = Array(R) { BooleanArray(C) }
    for (i in 0 until R) {
        val temp = readLine()
        for (j in 0 until C) {
            map[i][j] = temp[j] - 'A'
        }
    }
    print(dfs(0, 0))

}

fun dfs(x: Int, y: Int) : Int{

    var count = 0
    visited[x][y] = true
    check[map[x][y]] = true

    for (i in 0..3) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if ((nextX in 0 until R) && (nextY in 0 until C) && !visited[nextX][nextY]) {
            if (!check[map[nextX][nextY]]) {
                count = count.coerceAtLeast(dfs(nextX, nextY))
            }
        }
    }
    visited[x][y] = false
    check[map[x][y]] = false
    return count+1
}
