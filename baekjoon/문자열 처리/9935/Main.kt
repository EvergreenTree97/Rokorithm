import java.util.*

fun main() {
    with(System.`in`.bufferedReader()) {
        val str = readLine()
        val bombStr = readLine()
        print(str.explode(bombStr))
    }
}

fun String.explode(bombStr: String): String {
    val stack = Stack<Char>()
    var i = 0
    while (i < this.length) {
        stack.push(this[i++])
        if (stack.size >= bombStr.length) {
            var flag = true
            for (j in bombStr.lastIndex downTo 0) {
                if (bombStr[bombStr.lastIndex - j] != stack[stack.lastIndex - j]) {
                    flag = false
                    break
                }
            }
            if (flag) {
                for (j in 0 until bombStr.length) {
                    stack.pop()
                }
            }
        }
    }
    val result = StringBuilder().apply {
        stack.forEach {
            append(it)
        }
    }.toString()
    return result.ifEmpty {
        "FRULA"
    }
}

/*
Try 1 : string의 replace를 활용하여 bomb를 치환
결과 -> 1퍼에서 시간초과

Try 2 : string의 split을 활용하여 bomb를 삭제
결과 -> 40퍼에서 메모리 초과

이 둘의 공통점. replace, split 둘다 최악의 경우 O(N)의 시간복잡도를 사용하므로
결과적으로 O(N^2)이 발생. 이를 줄일 수 있는 방안을 생각해 봐야 함

Try 3 : 스택에 문자 하나하나 넣어가면서 체크

*/
