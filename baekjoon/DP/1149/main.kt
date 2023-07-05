import kotlin.math.min

fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val house = Array(N){
            readLine().split(" ").map(String::toInt).toTypedArray()
        }
        for(i in 1 until N){
            house[i][0] += min(house[i-1][1], house[i-1][2])
            house[i][1] += min(house[i-1][0], house[i-1][2])
            house[i][2] += min(house[i-1][0], house[i-1][1])
        }
        print(house[N-1].minOrNull() ?: 0)
    }
}

