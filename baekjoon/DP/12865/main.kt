
import java.util.*
import kotlin.math.max


fun main() {
    with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val weights = IntArray(N + 1)
        val values = IntArray(N + 1)
        val dp = Array(N + 1){
            IntArray(K+1)
        }

        for (i in 1..N) {
            val (w, v) = readLine().split(" ").map(String::toInt)
            weights[i] = w
            values[i] = v
        }

        for(i in 1 .. N){
            for(j in 1 .. K){
                if(weights[i] > j){  //i (limit N) 번째 짐이 j(limit K) 무게보다 클 경우 (더 담을 수 없음)
                    dp[i][j] = dp[i-1][j]
                }else{ // 만약 7일경우, 무게가 7일 경우와, 1 + 6인 경우를 비교할 수 있다. 이게 j - weights[i]로 표현
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j - weights[i]] + values[i])
                }
            }
        }
    }
}

/*
짐을 쪼갤수 없는 배낭 문제 - DP
N 개의 짐들에 대해 최대 무게인 K까지의 각 물품 가치를 2차원 배열로 표현

표를 직접 그려보는 것이 확실하다
// K라는 최대 값에 대해서, 1부터 하나하나 조사하면서 K까지 도달할 때 까지 조합 가짓수를 계속 저장해온다.
https://st-lab.tistory.com/141
*/

