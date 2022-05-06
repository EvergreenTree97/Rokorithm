import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val n = 8
    val k = 2
    val read = System.`in`.bufferedReader().readLine().split(",").map { it.replace("[", "").replace("]", "").replace("\"", "") }
    val arr = read.toTypedArray()
    val s = Solution()
    print(s.solution(n, k, arr))
}

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer: String = ""
        val cache = ArrayList<Int>()
        var size = n
        var cursor = k
        for (c in cmd) {
            val command = c.split(" ")
            when (command[0]) {
                "U" -> {
                    val dist = command[1].toInt()
                    cursor -= dist
                }
                "D" -> {
                    val dist = command[1].toInt()
                    cursor += dist
                }
                "C" -> {
                    size--
                    cache.add(cursor)
                    cursor = if (cursor == size) {
                        cursor - 1
                    } else {
                        cursor
                    }
                }
                else -> {
                    val restore = cache.removeAt(cache.size - 1)
                    cursor = if (restore <= cursor) {
                        cursor + 1
                    } else {
                        cursor
                    }
                    size++
                }
            }
        }
        val sb = StringBuilder(answer)
        sb.append("O".repeat(size))
        while (cache.isNotEmpty()) {
            sb.insert(cache.removeAt(cache.size - 1), 'X')
        }
        return sb.toString()
    }
}