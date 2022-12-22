fun main() = with(System.`in`.bufferedReader()) {
    val (N,M) = readLine().split(" ").map(String::toInt)
    val dp = Array(N + 1) {
        IntArray(M + 1)
    }
    val orgin = Array(N + 1) {
        IntArray(M + 1)
    }
    (1..N).forEach { i ->
        val line = readLine().split(" ").map(String::toInt)
        (1..M).forEach { j ->
            orgin[i][j]  = line[j-1]
        }
    }
    for (i in 1..N) {
        for (j in 1..M) {  //직사각형의 합 누적합으로 구하기
            dp[i][j] = orgin[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
        }
    }
    val K = readLine().toInt()
    val sb = StringBuilder()
    repeat(K){ //누적합을 가지고 해당 구간을 구하기
        val (x1, y1, x2, y2) = readLine().split(" ").map(String::toInt)
        sb.appendLine(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1])

    }
    print(sb)
}

