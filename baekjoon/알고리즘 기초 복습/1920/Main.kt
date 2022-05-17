fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val A = readLine().split(" ").map { it.toLong() }.toLongArray()
    val M = readLine().toInt()
    val B = readLine().split(" ").map{ it.toLong() }
    val sb = StringBuilder()
    A.sort()
    B.forEach{ b ->
        if(binarySearch(A,b)){
            sb.append("1").append("\n")
        }else{
            sb.append("0").append("\n")
        }
    }
    print(sb)
}
fun binarySearch(arr: LongArray, target: Long): Boolean{
    var s = 0
    var e = arr.size-1
    var flag = false
    while(s <= e){
        val mid = (s+e)/2
        val midValue = arr[mid]
        when{
            midValue == target ->{
                flag = true
            }
            midValue < target ->{
                s = mid+1
            }
            midValue > target ->{
                e = mid-1
            }
        }
    }
    return flag
}

// 탐색 nlogn 즉,이분탐색
// 범위 Long
// while은 s<=e , 왜냐하면 탐색의
// 이분탐색의 시작인덱스는 0 , 끝 인덱스는 size-1
