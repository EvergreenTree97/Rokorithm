var res = 0
var s = 0
fun main() = with(System.`in`.bufferedReader()) {
    s = readLine().toInt()
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val A = IntArray(m)
    val B = IntArray(n)
    for (i in 0 until m) {
        A[i] = readLine().toInt()
    }
    for (i in 0 until n) {
        B[i] = readLine().toInt()
    }
    val countA = ArrayList<Int>()
    val countB = ArrayList<Int>()
    getSum(A, countA)
    getSum(B, countB)
    countA.add(0)
    countB.add(0) //이거 때문에 문제가 안 풀렸는데, A피자와 B피자 따로 계싼하는 경우 생각하면 추가해 줘야 했다..
    countA.sort()
    countB.sort()
    for (element in countA) {
        val l = lowerCase(countB, s - element)
        val r = upperCase(countB, s - element)
        res += (r - l)
    }
    print(res)
}

fun getSum(pizza: IntArray, count: ArrayList<Int>) {
    var allSum = 0
    for (i in pizza.indices) {
        var sum = 0
        allSum += pizza[i]
        for (j in i until i + pizza.size - 1) {
            sum += pizza[j % pizza.size]
            count.add(sum)
        }
    }
    count.add(allSum)
}

fun lowerCase(arr: ArrayList<Int>, target: Int): Int {
    var s = 0
    var e = arr.size
    while (s < e) {
        val mid = (s + e).shr(1)
        if (arr[mid] < target) {
            s = mid+1
        }else{
            e = mid
        }
    }
    return s
}

fun upperCase(arr: ArrayList<Int>, target: Int): Int {
    var s = 0
    var e = arr.size
    while (s < e) {
        val mid = (s + e).shr(1)
        if (arr[mid] <= target) {
            s = mid+1
        }else{
            e = mid
        }
    }
    return s
}
