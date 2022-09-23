import java.util.*

fun main() {
    Solution().solution(")(")
}

class Solution {
    fun solution(p: String): String {

        return step12(p)
    }

    fun step12(p: String): String {
        // step 1
        if (p.isEmpty()) {
            return ""
        }
        //step 2
        var count = 0
        val u = StringBuilder()
        val v = StringBuilder()

        for (i in p.indices) {
            if (p[i] == '(') {
                u.append(p[i])
                count++
            } else if (p[i] == ')') {
                u.append(p[i])
                count--
            }

            if (count == 0) {
                v.append(p.substring(i + 1, p.length))
                break
            }
        }
        val stack = Stack<Char>()
        var flag = false
        for (i in u) {
            if (i == '(') {
                stack.push(i)
            } else if (i == ')') {
                if (stack.isEmpty()) {
                    flag = true
                    break
                }
                stack.pop()
            }
        }
        if (flag.not()) {
            return u.append(step12(v.toString())).toString()
        } else {
            val sb = StringBuilder().apply {
                append("(")
                append(step12(v.toString()))
                append(")")
            }
            val newU = u.substring(1, u.length - 1)
            for(i in newU){
                if(i == '('){
                    sb.append(")")
                }else{
                    sb.append("(")
                }
            }
            return sb.toString()
        }
    }
}