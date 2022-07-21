fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val stack = mutableListOf<Char>()
    var k = 1
    var res = 0
    var flag = true
    for (i in str.indices) {
        val top = stack.size - 1
        if (str[i] == '(') {
            stack.add('(')
            k *= 2
        } else if (str[i] == '[') {
            stack.add('[')
            k *= 3
        } else {
            if (str[i] == ')') {
                if (stack.isEmpty() || stack[top] != '(') {
                    flag = false
                    break
                }
                if (str[i - 1] == '(') {
                    res += k
                }
                k /= 2
                stack.removeAt(top)
            } else if (str[i] == ']') {
                if (stack.isEmpty() || stack[top] != '[') {
                    flag = false
                    break
                }
                if (str[i - 1] == '[') {
                    res += k
                }
                k /= 3
                stack.removeAt(top)
            } else {
                flag = false
                break
            }
        }
    }

    if (!flag || stack.isNotEmpty()) {
        print(0)
    } else {
        print(res)
    }
}
// 분배법칙이라는 힌트를 얻고 머리가 띵했다.. 정말 알고리즘의 길은 멀다