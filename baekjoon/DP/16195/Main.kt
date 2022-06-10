const val MOD = 1000000009

/*
* 시간제한 및 메모리 제한

O(n^2) 풀이 : 시간제한 ok (1000*1000 = 100만이므로, 이론상 0.01초)
자료형 : 최대 30억, long
* /
*
* */

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    val sb = StringBuilder()
    val dp = Array(1001){ //m개 이하를 사용해 n을 1,2,3의 합으로 나타내는 방법의 수
        IntArray(1001)
    }
    dp[1][1] = 1
    dp[2][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 2
    dp[3][3] = 1

    for(i in 4 .. 1000){
        for (j in 2 .. i){
            dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % MOD
        }
    }
    for(tc in 0 until T){
        val (n, m) = readLine().split(" ").map { it.toInt() }
        var sum = 0L
        for (i in 1 .. m){
            sum += dp[n][i] % MOD
        }
        sb.append(sum).append("\n")

    }
    print(sb)
}



//4 2

//1

//1 1, 2

//1 1 1, 2 1, 3

//1 1 1 1, 2 1 1, 3 1, 1 1 2, 2 2, 1 3
