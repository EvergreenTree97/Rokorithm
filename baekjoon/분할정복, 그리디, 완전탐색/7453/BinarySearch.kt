var n = 0
fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    val A = LongArray(n)
    val B = LongArray(n)
    val C = LongArray(n)
    val D = LongArray(n)
    val leftArr = LongArray(n * n)
    val rightArr = LongArray(n * n)
    for (i in 0 until n) {
        val read = readLine().split(" ").map { it.toLong() }
        A[i] = read[0]
        B[i] = read[1]
        C[i] = read[2]
        D[i] = read[3]
    }
    var k = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            leftArr[k] = A[i] + B[j]
            rightArr[k] = C[i] + D[j]
            k++
        }
    }
    var ans = 0L
    leftArr.sort()
    rightArr.sort()
    for (element in leftArr){
        val l = lowerCase( rightArr, -element)
        val u = upperCase( rightArr, -element)
        ans += (u-l).toLong()
    }
    print(ans)

}
fun lowerCase(arr: LongArray, target: Long): Int{
    var s = 0
    var e = arr.size
    while(s < e){
        val mid = (s+e).shr(1)
        val cur = arr[mid]
        if(cur < target){ //탐색 값이 주어진 값보다 작다면 s를 mid+1로
            s = mid+1
        }else{ //탐색 값이 주어진 값보다 작거나 같다면 e를 mid로 해서 아래 값을 찾는다. 그리고 최소 경계값을 찾아간다.
            e = mid
        }
    }
    return s
}
fun upperCase( arr: LongArray, target: Long): Int{
    var s = 0
    var e = arr.size
    while(s < e){
        val mid = (s+e).shr(1)
        val cur = arr[mid]
        if(cur <= target){ //탐색 값이 주어진 값보다 작거나 같다면 s를 증가시킨다. 결국은 target보다 바로 다음 값을 찾게 된다.
            s = mid+1
        }else{ //탐색 값이 주어진 값보다 크다면 mid를 좁힌다.
            e = mid
        }
    }
    return s
}
