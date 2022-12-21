fun main() = with(System.`in`.bufferedReader()) {
    val M = readLine().toInt()
    var sum = 0
    for (i in 1..100000000) {
        var temp = i
        var num = 1
        while (temp % 5 == 0) {
            num++
            temp /= 5
        }
        sum += num
        if (sum == M) {
            print(5 * i)
            break
        } else if (sum > M) {
            print(-1)
            break
        }
    }
}

// 1! = 1
// 2! = 2
// 3! = 6
// 4! = 24
// 5! = 120    // 5 x 1
// 6! = 720
// 7! = 5040
// 8! = 40320
// 9! = 362880
// 10! = 3628800 // 5 x 2
// 15!  5 x 3
// 20! 5 x 4
// 25! 5 x 5  // 5^2 pass