val sb: StringBuilder = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val (L, C) = readLine().split(" ").map { it.toInt() }
    val str = readLine().split(" ")
        .flatMap { it.toList() }
        .sorted()
        .joinToString("")
    dfs("", str, -1, 0, 0 , L)
    print(sb)
}

fun dfs(current: String, original: String, index: Int, jaeum: Int, moeum: Int, L: Int) {
    if (current.length == L) {
        if (jaeum >= 2 && moeum >= 1) sb.appendLine(current)
    } else {
        (index + 1 until original.length).forEach { index ->
            if (isJaeum(original[index])) {
                dfs(current + original[index], original, index, jaeum + 1, moeum, L)
            } else {
                dfs(current + original[index], original, index, jaeum, moeum + 1, L)
            }
        }
    }
}

fun isJaeum(c: Char): Boolean {
    return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'
}