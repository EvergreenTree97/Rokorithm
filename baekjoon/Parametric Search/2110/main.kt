fun main() {
    with(System.`in`.bufferedReader()) {
        val (N, C) = readLine().split(" ").map(String::toInt)
        IntArray(N) {
            readLine().toInt()
        }.sorted()
        .parametricSearch(C)
        .also(::print)
    }
}

fun List<Int>.parametricSearch(C: Int): Int {
    var start = 1
    var end = this.last() - this[0] + 1
    while (start < end) {
        val mid = (start+end) / 2
        if(canInstall(mid) < C){
            end = mid
        }else{
            start = mid+1
        }
    }
    return start-1
}

fun List<Int>.canInstall(distance: Int): Int{
    var count = 1 //처음 집 설치
    var lastPosition = this[0] // 마지막 설치한 집 위치
    for(i in count until size){
        val currentPosition = this[i]
        if(currentPosition- lastPosition >= distance){
            count++
            lastPosition = currentPosition
        }
    }
    return count
}

//최대 설치되는 집 간의 거리를 벌릴 수 있게 만들고 싶다.
// 최소 거리에 따라 설치될 수 있는 공유기의 개수가 달라지고 있음
// 거리를 탐색 범위로 잡고, 이분탐색을 하면서 탐색 거리의 범위를 좁혀나가기
// 최대로 가질 수 있는 최소 거리 -> Upper Bound
