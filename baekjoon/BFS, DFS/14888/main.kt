import kotlin.math.max
import kotlin.math.min

var max = Int.MIN_VALUE
var min = Int.MAX_VALUE

fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val operands = readLine().split(" ").map(String::toInt).toIntArray()
        val operators = readLine().split(" ").map(String::toInt).toIntArray() // +, - , *, /
        backtracking(operands[0], 1, N, operands, operators)
        println(max)
        println(min)
    }
}

fun backtracking(number: Int, index: Int, N: Int, operands: IntArray, operators: IntArray) {
    if (index == N) {
        max = max.coerceAtLeast(number)
        min = min.coerceAtMost(number)
        return
    }
    for (i in 0 until 4) {
        if (operators[i] > 0) {
            operators[i]--
            when (i) {
                0 -> backtracking(number + operands[index], index + 1, N, operands, operators)
                1 -> backtracking(number - operands[index], index + 1, N, operands, operators)
                2 -> backtracking(number * operands[index], index + 1, N, operands, operators)
                else -> backtracking(number / operands[index], index + 1, N, operands, operators)
            }
            operators[i]++
        }
    }
}

// N이 1~10이므로 그리디쪽 보다는 완전탐색 이라고 생각
//
