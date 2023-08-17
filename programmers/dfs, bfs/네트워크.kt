fun main(){
    Solution().solution(3, arrayOf(
        intArrayOf(1,1,0),
        intArrayOf(1,1,1),
        intArrayOf(0,1,1)
    ))
}

class Solution {
    lateinit var visited: BooleanArray
    fun solution(n: Int, computers: Array<IntArray>): Int {
        visited = BooleanArray(n)
        var count = 0
        for (i in 0 until n) {
            if (visited[i].not()) {
                count++
                find(i, computers, visited)
            }
        }
        return count
    }

    fun find(start: Int, computers: Array<IntArray>, visited: BooleanArray) {
        for (next in computers[start].indices) {
            if (
                visited[next].not()
                && computers[start][next] == 1
                && start != next
            ) {
                visited[next] = true
                find(next, computers, visited)
            }
        }
    }
}