fun main() = with(System.`in`.bufferedReader()) {
    val (N,M) = readLine().split(" ").map(String::toInt)
    val A = (readLine()+" 0").split(" ").map(String::toInt).toIntArray()
    var start = 0
    var end = 0
    var sum = A[0]
    var count = 0
    while(end < N){
        when{
            sum == M -> {
                count++
                sum -= A[start++]
            }
            sum > M -> {
                sum -= A[start++]
            }
            else -> {
                sum += A[++end]
            }
        }
    }
    print(count)
}
