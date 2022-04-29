var res = 0L
var s = 0
fun main() = with(System.`in`.bufferedReader()) {
    s = readLine().toInt()
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val A = IntArray(m)
    val B = IntArray(n)
    var aSum = 0
    var bSum = 0
    for (i in 0 until m) {
        A[i] = readLine().toInt()
        aSum += A[i]
    }
    for (i in 0 until n) {
        B[i] = readLine().toInt()
        bSum += B[i]
    }
    val countA = hashMapOf<Int,Int>()
    val countB = hashMapOf<Int,Int>()
    getSum(A, countA)
    getSum(B, countB)
    countA[aSum] = 1
    countB[bSum] = 1
    countA[0] = 1
    countB[0] = 1

    for (element in countA.keys) {
        val b = countB.getOrDefault(s-element, -1)
        if(b != -1){
            res += b * countA[element]!!
        }
    }
    print(res)
}

fun getSum(pizza: IntArray, count: HashMap<Int,Int>) {
    for (i in pizza.indices) {
        var sum = 0
        for (j in i until i + pizza.size - 1) {
            sum += pizza[j % pizza.size]
            count[sum] = count.getOrDefault(sum, 0)+1
        }
    }
}
