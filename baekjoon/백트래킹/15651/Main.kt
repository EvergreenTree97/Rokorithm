var N = 0
var M = 0
val sb = StringBuilder()
lateinit var arr: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val read = readLine().split(" ").map { it.toInt() }
    N = read[0]
    M = read[1]
    arr = IntArray(M)
    backTracking(0,0)
    print(sb.toString())
}


fun backTracking(index: Int, length: Int) {
    if (length == M) {
        arr.forEach{
            sb.append("$it ")
        }
        sb.append("\n")
        return
    }
    for (i in 1..N) {
        arr[index] = i
        backTracking(index+1, length+1)
        //체크아웃할 필요가 없음. max depth에서 계속 값이 바뀜
    }
}
