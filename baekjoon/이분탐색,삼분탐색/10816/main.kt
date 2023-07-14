fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val cards = readLine().split(" ").map(String::toInt).sorted()
        val M = readLine().toInt()
        readLine().split(" ").map {
            cards.upperBound(it.toInt()) - cards.lowerBound(it.toInt())
        }.also {
            print(it.joinToString(" "))
        }

    }
}

fun List<Int>.lowerBound(target: Int): Int {
    var start = 0
    var end = size
    while (start < end) {
        val mid = (start + end) / 2
        if (target <= get(mid)) { // <=에서 target을 찾아도 범위를 줄여버리니까, else에서 start를 mid+1로 올려버리면 while문이 끝난다.
            end = mid
        } else {
            start = mid + 1
        }
    }
    return start
}

fun List<Int>.upperBound(target: Int): Int {
    var start = 0
    var end = size
    while (start < end) {
        val mid = (start + end) / 2
        if (target < get(mid)) { // 현재 값보다 타겟이 작으면, end를 mid로
            end = mid
        } else {
            start = mid +1
        }
    }
    return start
}

/*
* 이분탐색의 upper bound 와 lower bound 개념을 이용해서 중복된 원소가 나오는 첫번째 인덱스와, 마지막 인덱스를 구해야 한다.
*
* */