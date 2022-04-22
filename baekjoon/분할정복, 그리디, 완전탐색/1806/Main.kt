import java.util.*

lateinit var arr: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (N, S) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    arr = IntArray(N+1)
    for (i in 0 until N){
        arr[i] = st.nextToken().toInt()
    }
    arr[N] = 0
    var s = 0
    var e = 0
    var sum = arr[0]
    var min = N+1
    while(e < N){
        if(sum < S){
            sum += arr[++e]
        }else{
            //length를 저장할 때, 길이를 찾았을 경우에도 비교해야 한다는 것을 잊음
            min = min.coerceAtMost((e-s+1))
            sum -= arr[s++]
        }
    }
    if(min == N+1){
        print(0)
    }else{
        print(min)
    }

}