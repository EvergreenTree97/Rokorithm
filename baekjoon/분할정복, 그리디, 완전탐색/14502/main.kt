import java.util.*
import kotlin.math.max

val viruses = ArrayList<IntArray>()
lateinit var map: Array<IntArray>
var N: Int = 0
var M: Int = 0
const val MAX_WALL = 3
val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)
var max = 0

fun main() {
    with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).also {
            N = it[0]
            M = it[1]
        }
        map = Array(N) { i ->
            readLine().split(" ").map(String::toInt).toIntArray().also {
                it.forEachIndexed { j, element ->
                    element.takeIf { param -> param == 2 }?.also { viruses.add(intArrayOf(i, j)) }
                }
            }
        }
        dfs(0)
        print(max)
    }
}


fun dfs(wall: Int) { //dfs
    if (wall == MAX_WALL) {
        bfs()
        return
    }
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 0) {
                map[i][j] = 1
                dfs(wall + 1)
                map[i][j] = 0
            }
        }
    }
}

fun bfs() { // bfs
    val temp = map.map { it.copyOf() }.toTypedArray()
    val queue: Queue<IntArray> = LinkedList<IntArray>().apply {
        viruses.forEach { add(it) }
    }
    while (queue.isNotEmpty()) {
        val next = queue.poll()
        for (i in 0..3) {
            val nextX = next[0] + dx[i]
            val nextY = next[1] + dy[i]
            if (nextX in 0 until N
                && nextY in 0 until M
                && temp[nextX][nextY] == 0
            ) {
                temp[nextX][nextY] = 2
                queue.add(intArrayOf(nextX, nextY))
            }
        }
    }
    max = max(
        a = max,
        b = temp.sumBy {
            it.count { element -> element == 0 }
        }
    )
}

//목표 : 벽 3개 세워서 안전 영역 크기의 최댓값 구하기
// 크기가 N * M
// 0 : 빈칸
// 1 : 벽
// 2 : 바이러스

/*
*  N, M 둘다 최대 8이므로, 완전 탐색으로 문제를 접근할 수 있다.
*  dfs로 모든 벽을 설치하는 경우의 수를 찾는다
*  bfs로 바이러스를 확산시켜서 safe zone을 계산한다.
* */