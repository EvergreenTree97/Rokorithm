val hashmap = hashMapOf<Char, Double>()
fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val expression = readLine().toString()
    var order = 0
    var str: String? = ""
    while (true) {
        str = readLine()
        if (str.isNullOrBlank()) break
        hashmap[(order + 'A'.code).toChar()] = str.toDouble()
        order++
    }
    var result: Double
    val stack = ArrayList<Double>()
    expression.forEach { element ->
        if (element.isAlphabet()) {
            stack.add(hashmap[element]!!)
        } else {
            val operand2 = stack.removeAt(stack.size - 1)
            val operand1 = stack.removeAt(stack.size - 1)
            result = when (element) {
                '+' -> operand1 + operand2
                '-' -> operand1 - operand2
                '*' -> operand1 * operand2
                else -> operand1 / operand2
            }
            stack.add(result)
        }
    }
    print(String.format("%.2f",stack[0]))

}

fun Char.isAlphabet(): Boolean {
    return (this.code >= 'A'.code && this.code <= 'Z'.code)
}