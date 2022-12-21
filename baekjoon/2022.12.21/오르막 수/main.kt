fun main(): Unit = with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val dp = Array(N+1){// i 자리 수 이며
        IntArray(10) // 앞 자리수 (0~9) 인 오르막 수
    }
    (0 .. 9).forEach { i ->
        dp[1][i] = 1 // 한 자리수 이고, 앞 자리수가 i인 오르막 수는 각각 1개임
    }
    if(N == 1) print(10)
    else{
        (2 ..N).forEach { i ->
            (0 .. 9).forEach{j ->
                var sum = 0
                (j .. 9).forEach{k -> // i 자릿수이고, 앞자리수가 k일 때 이전의 값에 더해 오르막 수를 만들 수 있음
                    sum += dp[i-1][k] % 10007
                }
                dp[i][j] = sum
            }
        }
        print(dp[N].sum() % 10007)
    }
}

// 0  1  2  3  4  5  6  7  8  9
// 00 01 02 03 04 05 06 07 08 09
// 11 12 13 14 15 16 17 18 19
// 22 23 24 25 26 27 28 29

