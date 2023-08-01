import java.util.*
import kotlin.collections.ArrayList

val sb = StringBuilder()

fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        permutation(N, Stack<Int>(), BooleanArray(N+1))
        println(sb.toString())
    }
}

fun permutation(N:Int, stack: Stack<Int>, visited: BooleanArray){
    if(stack.size == N){
        sb.appendLine(stack.joinToString(" "))
        return
    }
    for(i in 1 ..N){
        if(visited[i].not()){
            visited[i] = true
            permutation(N, stack.also { it.add(i) }, visited)
            stack.pop()
            visited[i] = false
        }
    }
}

// 1부터 N까지의 순열 구하기
