import kotlin.math.max

lateinit var board: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val valid = hashMapOf<Char, Boolean>()
var result = 0

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, -1, 0, 1)
fun main() = with(System.`in`.bufferedReader()) {
    val (R, C) = readLine().split(" ").map(String::toInt)
    board = Array(R) {
        readLine().toCharArray()
    }
    visited = Array(R) {
        BooleanArray(C) { false }
    }
    dfs(0, 0,1, R, C)
    print(result)
}

fun dfs(r: Int, c: Int, count: Int, R: Int, C: Int) {
// 1. 체크인
    visited[r][c] = true
    valid[board[r][c]] = true
    result = max(result, count)
// 2. 목적지인가?
    // 다 돌아봐야함
// 3. 연결된 곳을 순회
    (0..3).forEach { dir ->
        val nx = r + dx[dir]
        val ny = c + dy[dir]

//    i. 갈 수 있는가?
        if (nx in 0 until R
            && ny in 0 until C
            && visited[nx][ny].not()
            && valid.isTrue(board[nx][ny]).not()
        ) {
            //    ii. 간다
            dfs(nx, ny, count + 1, R, C)
        }
    }
// 4. 체크아웃
    visited[r][c] = false
    valid[board[r][c]] = false
}

fun HashMap<Char, Boolean>.isTrue(c: Char): Boolean {
    return getOrDefault(c, false)
}
