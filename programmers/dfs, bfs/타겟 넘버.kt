class Solution {
    var count = 0
    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            with(list) { map { it + i } + map { it - i } }
        }.count { it == target }
    }

    // 정석 dfs 풀이.. 위 코드는 fold를 활용한 함수형 풀이
    fun dfs(numbers: IntArray, current: Int, target: Int, index: Int) {
        if (index > numbers.lastIndex) {
            if (current == target) count++
            return
        }
        dfs(numbers, current + numbers[index], target, index + 1)
        dfs(numbers, current - numbers[index], target, index + 1)
    }
}