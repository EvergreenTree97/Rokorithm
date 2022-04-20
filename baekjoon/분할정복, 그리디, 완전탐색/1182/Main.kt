import java.util.*

var N = 0
var S = 0
var count = 0
lateinit var arr: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val nums = readLine().split(" ").map { it.toInt() }
    N = nums[0]
    S = nums[1]
    val st = StringTokenizer(readLine())
    arr = IntArray(N)
    arr.forEachIndexed { index, _ ->
        arr[index] = st.nextToken().toInt()
    }
    for (i in 0 until N){
        dfs(arr[i],i)
    }
    print(count)
}

fun dfs(sum: Int, idx: Int) {
    if(sum == S){
        count++
    }
    for(i in idx+1 until N){
        dfs(sum+arr[i],i)
    }
}
