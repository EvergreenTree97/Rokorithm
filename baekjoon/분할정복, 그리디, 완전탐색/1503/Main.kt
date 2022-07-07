import kotlin.math.abs
import kotlin.math.min



/*
boj - 1503
절대값이 안붙은 N - xyz는 xyz가 최대임을 만족하는 그리디 알고리즘을 사용할 수 있음.
하지만 절대값이 붙어 그리디를 사용할 수 없음. 따라서 완전탐색을 해줘야함
그런데 완전탐색으로 풀 수 있을까? 보통 10^8, 즉 1억개의 데이터를 처리할 때 1초라고 가정해본다.
이 문제는 M이 50이고, 3개를 고르는 문제니까 50C3, 최대 2만개이므로 가능하다.
이 문제의 가장 큰 함정은, 선택하지 말아야 할 범위가 1000이하라는 것이고, 사실 범위는 무한대다.
하지만 N- xyz가 최소가 되려면 xyz가 더더욱 커지게 되면 절대값이 커질 것이기 떄문에 사실상
1001로 제한하면 된다
* */

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val ban = BooleanArray(1002)
    readLine().split(" ").map { it.toInt() }.forEach {
        ban[it] = true
    }
    var min = Integer.MAX_VALUE
    for (i in 1..1001) {
        if (ban[i]) continue
        for (j in 1..1001) {
            if (ban[j]) continue
            for (k in 1..1001) {
                if (ban[k]) continue
                min = min(min, abs(N - i * j * k))

            }
        }
        if(min == 0) break; // 가지치기
    }
    print(min.toString())

}
