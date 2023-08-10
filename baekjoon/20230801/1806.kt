import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (N,S) = readLine().split(" ").map(String::toInt)
    val A = IntArray(N+1).apply {
        val readLine = (readLine()).split(" ").map(String::toInt).toIntArray()
        for(i in 0 until N){
            this[i] = readLine[i]
        }
    }
    var sum = A[0]
    var start = 0
    var end = 0
    var currentLength = 1
    var minLength = Int.MAX_VALUE
    while(end < N){
        if(sum >= S){
            minLength = minLength.coerceAtMost(currentLength--)
            sum -= A[start++]
        }else{
            currentLength++
            sum += A[++end]
        }
    }
    if(minLength == Int.MAX_VALUE){
        print(0)
    }else{
        print(minLength)
    }
}
