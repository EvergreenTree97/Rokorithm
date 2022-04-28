val hashMap = HashMap<Long, Int>()
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
    var count = 1
    leftArr.sort()
    rightArr.sort()
    var start = 0
    var end = rightArr.size - 1
    while (start < leftArr.size && end >= 0) {
        if (leftArr[start] + rightArr[end] == 0L) {
            if (count == 1) {
                var idx = end
                while (--idx >= 0 && rightArr[idx] == rightArr[end]) {
                    count++
                }
            }
            ans += count
            start++
        } else if (leftArr[start] + rightArr[end] < 0L) {
            start++
            count = 1
        } else {
            end--
            count = 1
        }
    }
    print(ans)

}
