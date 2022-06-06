fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stack = ArrayList<Int>()
    val sb = StringBuilder()
    var start = 1
    for (i in 0 until n) {
        val number = readLine().toInt()
        while (start <= number) {
            stack.add(start)
            sb.append("+\n")
            start++
        }
        if (stack[stack.size - 1] != number) {
            sb.setLength(0)
            print("NO")
            break
        }
        stack.removeAt(stack.size - 1)
        sb.append("-\n")
    }
    print(sb)

}
