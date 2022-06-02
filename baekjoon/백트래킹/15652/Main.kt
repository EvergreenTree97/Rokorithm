var N = 0
var M = 0
val sb = StringBuilder()
lateinit var arr: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val read = readLine().split(" ").map { it.toInt() }
    N = read[0]
    M = read[1]
    arr = IntArray(M)
    backTracking(0,0,1)
    print(sb.toString())
}


fun backTracking(index: Int, length: Int,start: Int) {
    if (length == M) {
        arr.forEach{
            sb.append("$it ")
        }
        sb.append("\n")
        return
    }
    for (i in start..N) {
        arr[index] = i
        backTracking(index+1, length+1,i)
    }
}
