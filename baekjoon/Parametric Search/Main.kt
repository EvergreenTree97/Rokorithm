fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, l) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.toMutableList()
    list.add(0)
    list.add(l) //구간값을 구하기 위해 0과 마지막도 넣어줘ㅏ야함
    list.sort()

    var left = 1 //탐색의 시작 divide zero를 피하기 위해
    var right = l //탐색의 끝
    while (left <= right) {
        val mid = (left + right) / 2 //휴게소가 없는 구간의 최대값이 mid가 되어야 함
        if (canMake(mid, m, list)) left = mid + 1 else right = mid - 1
    }
    println(left)
}

fun canMake(mid: Int, m: Int, list: List<Int>): Boolean {
    var count = 0
    for (i in 1 until list.size) {
        //해당 식에 많은 것이 숨어있다.
        //1. list[i]-list[i-1] / mid의 몫은 휴게소를 세운 횟수
        //2. list[i]-list[i-1] > mid인 경우 최대 구간의 길이
        //3. 나누어 떨어진다면 휴게소가 이미 있는것이므로 1 빼기
        count += (list[i] - list[i - 1] - 1) / mid 
    }
    return count > m //휴게소 M개를 모두 세울 수 있을 경우 true
}