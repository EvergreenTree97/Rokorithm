var N = 0
var M = 0
val sb = StringBuilder()
lateinit var arr: IntArray
lateinit var list: MutableList<Int>
fun main() = with(System.`in`.bufferedReader()) {
    val read = readLine().split(" ").map { it.toInt() }
    N = read[0]
    M = read[1]
    arr = IntArray(N) { it + 1 }
    list = mutableListOf()
    backTracking(1)
    print(sb.toString())
}


fun backTracking(index: Int) {
    if (list.size == M) {
        sb.append(list.joinToString(" ")).append("\n")
        return
    }
    for (i in index..N) {
        if (!list.contains(i)) {
            list.add(i)
            backTracking(i + 1)
            list.remove(i)
        }
    }
}
