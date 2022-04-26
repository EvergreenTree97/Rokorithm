var N = 0
var S = 0
lateinit var map: IntArray
var count : Long = 0
fun main() = with(System.`in`.bufferedReader()) {
    val read = readLine().split(" ").map { it.toInt() }
    N = read[0]
    S = read[1]
    map = readLine().split(" ").map { it.toInt() }.toIntArray()
    val hashMap = hashMapOf<Long, Int>()
    dfs(0, 0, N / 2, hashMap)
    dfs2(N / 2, 0, N, hashMap)
    if(S ==0) count--
    print(count)

}

fun dfs(idx: Int, sum: Long, endIdx: Int, hashMap: HashMap<Long, Int>) {
    if (idx == endIdx) { //hashmap 풀이 - getorDefault는 sum이라는 키값에 값이 없다면 0으로 초기화, 그리고 반환
        hashMap[sum] = hashMap.getOrDefault(sum, 0) + 1
        return
    }
    dfs(idx + 1, sum + map[idx], endIdx, hashMap)
    dfs(idx + 1, sum, endIdx, hashMap)
}

fun dfs2(idx: Int, sum: Long, endIdx: Int, hashMap: HashMap<Long, Int>) {
    if (idx == endIdx) {
        count += hashMap.getOrDefault(S - sum, 0)
        return
    }
    dfs2(idx + 1, sum + map[idx], endIdx, hashMap)
    dfs2(idx + 1, sum, endIdx, hashMap)
}

/*
* 투포인터에 비해 확실히 빠르지만 메모리를 많이 차지한다.
* */

