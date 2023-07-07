fun main() {
    with(System.`in`.bufferedReader()) {
        val T = readLine().toInt()
        val sb = StringBuilder()
        repeat(T) { tc ->
            val N = readLine().toInt()
            val arr = Array(N) {
                val (document, interview) = readLine().split(" ").map { it.toInt() }
                Score(document, interview)
            }.sortedBy { it.document }
            var count = 1 // 서류 1등은 프리패스
            var min = arr[0].interview
            for (i in 1 until arr.size) {
                if(min > arr[i].interview){
                    count++
                    min = arr[i].interview
                }
            }
            sb.appendLine(count)
        }
        print(sb.toString())
    }
}

data class Score(
    val document: Int,
    val interview: Int,
)