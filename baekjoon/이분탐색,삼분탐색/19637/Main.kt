import kotlin.math.min

/*
* boj 19637
* 배열에 칭호, 상한값을 오름차순으로 둔다, 그리고 순차적으로 찾아가면서 칭호를 출력
* 그러나 시간 초과 발생, 10^5 * 10^5 = 10^10 으로 10^8을 넘겼음
* 상한값을 찾는 과정을 이진탐색 -> 이분탐색으로 바꿔주면 해결 가능
* */
fun main() = with(System.`in`.bufferedReader()) {
    val (N,M) = readLine().split(" ").map { it.toInt() }
    val arr = ArrayList<Node>()
    for (i in 0 until N){
        val (name, value) = readLine().split(" ")
        arr.add(Node(name,value.toInt()))
    }
    val sb = StringBuilder()
    for (i in 0 until M){
        val current = readLine().toInt()
        val idx = binarySearch(current,arr)
        sb.append("${arr[idx].name}\n")
    }
    print(sb)
}

fun binarySearch(target: Int, arr: ArrayList<Node>) : Int{
    var s = 0
    var e = arr.size-1
    while(s < e){
        val mid = (s+e)/2
        if(target <= arr[mid].value){
            e = mid
        }else{
            s = mid+1
        }
    }
    return s
}


data class Node(
    val name: String,
    val value: Int
)
