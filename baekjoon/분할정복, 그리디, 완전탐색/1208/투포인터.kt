var N = 0
var S = 0
lateinit var map: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val read = readLine().split(" ").map { it.toInt() }
    N = read[0]
    S = read[1]
    map = readLine().split(" ").map { it.toInt() }.toIntArray()
    val leftArr = ArrayList<Long>()
    val rightArr = ArrayList<Long>()
    dfs(0, 0, N / 2, leftArr) // 반을 나누어 저장
    dfs(N / 2, 0, N, rightArr) //반을 나누어 저장
    leftArr.sort() //정렬을 통해 투포인터 사용 가능
    rightArr.sort()
    var ans = 0L
    var p1 = 0
    var p2 = rightArr.size - 1
    var count = 1
    while (p1 < leftArr.size && p2 >= 0) { //배열의 모든 값을 확인
        if (leftArr[p1] + rightArr[p2] == S.toLong()) { //부분 배열의 합이 S와 같다면
            if (count == 1) {
                var idx = p2
                while (--idx >= 0 && rightArr[idx] == rightArr[p2]) { //idx를 감소시키면서 같은 값이 더있나 확인
                    count++
                }
            }
            ans += count
            p1++
        } else if (leftArr[p1] + rightArr[p2] < S.toLong()) { 
            p1++
            count = 1
        } else {
            p2--
            count = 1
        }
    }
    if(S ==0){
        ans--
    }
    print(ans)


}

fun dfs(idx: Int, sum: Long, endIdx: Int, arr: ArrayList<Long>) {
    if (idx == endIdx) {
        arr.add(sum)
        return
    }
    dfs(idx + 1, sum + map[idx], endIdx, arr)
    dfs(idx + 1, sum, endIdx, arr)
}

// 1. 부분 수열은 완전 탐색을 통해 구해야 한다.
// 2. 2^N 이므로 최대 2^40 이므로 시간제한에 걸려버린다
// 3. 중간에서 만나기, 즉 수열을 절반으로 나눈다. MITM(Meet in the Middle)
// 수열의 앞 절반, 수열의 뒤 절반 나올 수 있는 모든 부분수열의 합을 구해 저장해 놓는다
