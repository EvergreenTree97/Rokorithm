fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    val sb = StringBuilder()
    for(i in 0 until T){
        val N = readLine().toInt()
        val coins = readLine().split(" ").map { it.toInt() }
        val M = readLine().toInt()

        val dp = IntArray(10001) //주어진 동전으로 index원을 만드는 경우의 수
        dp[0] = 1

        for (i in 0 until N){
            for (j in coins[i] .. M){
                dp[j] += dp[j - coins[i]]
            }
        }
        sb.append(dp[M]).append("\n")

    }
    print(sb)

}