
fun main() {
    val read = System.`in`.bufferedReader().readLine().split(", ").map{ it.replace("[","").replace("]","").replace("\"","")}
    val arr = Array(5){
        Array(5){ "" }
    }
    var x = 0
    for (i in 0 until 5){
        for (j in 0 until 5){
            arr[i][j] = read[x++]
        }
    }

    val s = Solution()
    s.solution(arr)
}

val dx = intArrayOf(-1, 0, 1, 0, -1, 1, 1, -1)
val dy = intArrayOf(0, -1, 0, 1, -1, -1, 1, 1)

var flag = true
class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = IntArray(5)
        for ((idx, place) in places.withIndex()) {
            val map = Array(5) { CharArray(5) }
            for (i in 0 until 5) {
                map[i] = place[i].toCharArray()
            }
            flag = true
            dfs(map, 0, 0)
            if (flag) {
                answer[idx] = 1
            }
        }

        return answer
    }

    private fun dfs(map: Array<CharArray>, col: Int, row: Int){
        if (col == 5) {
            dfs(map, 0, row + 1)
            return
        } else if (row == 5) {
            return
        }
        if (map[col][row] != 'P') {
            dfs(map, col + 1, row)
        }else{
            if (check(map, col, row)) {
                dfs(map, col + 1, row)
            }else{
                flag = false
                return
            }
        }
    }

    private fun check(map: Array<CharArray>, col: Int, row: Int): Boolean {
        for (i in 0 until 4) { //십자가 한칸 체크
            val nx = col + dx[i]
            val ny = row + dy[i]
            if (nx in 0 until 5 && ny in 0 until 5) {
                if (map[nx][ny] == 'P') {
                    return false
                }
            }
            val nx2 = col + dx[i] * 2
            val ny2 = row + dy[i] * 2
            if (nx2 in 0 until 5 && ny2 in 0 until 5) { //십자가 두칸 뒤
                if (map[nx2][ny2] == 'P' && map[nx][ny] == 'O') {
                    return false
                }
            }
        }
        for (i in 4 until 8) { //십자가 대각선
            val nx = col + dx[i]
            val ny = row + dy[i]
            if (nx in 0 until 5 && ny in 0 until 5) {
                if (map[nx][ny] == 'P') {
                    if (map[col][ny] == 'O' || map[nx][row] == 'O') {
                        return false
                    }
                }
            }
        }
        return true
    }
}


