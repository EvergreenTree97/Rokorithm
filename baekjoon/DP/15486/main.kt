import java.lang.Integer.max

fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val tp = Array(N + 2) {
            if (it == 0 || it == N + 1) arrayOf(0, 0)
            else readLine().split(" ").map(String::toInt).toTypedArray()
        }
        val dp = IntArray(N+2) // N일까지 받을 수 있는 최대 상담 금액 (N+1에 상담이 끝나도 인정되어 N+2)
        for (i in N downTo 0) {
            if (i + tp[i][0] > N+1) { // 상담이 퇴사 날짜보다 끝난다면, 상담을 하지 않는 다음 날짜의 최대 수익이 현재 날짜의 최대 수익
                dp[i] = dp[i + 1]
            } else { //다음 날짜의 최대 수액 vs 현재 상담의 수익과, 상담이 끝날을 때의 최대 수익을 합친 수익
                dp[i] = max(dp[i + 1], tp[i][1] + dp[i + tp[i][0]])
            }
        }
        print(dp[1])
    }
}

// N <= 150만 이므로 N번의 순회로 해결해야함
// 최대 이익을 구하는 문제이므로 greedy or dp 일 가능성이 높음
// 0부터 N까지 탐색하면 최대 수익을 알 수 없으므로, N부터 진행