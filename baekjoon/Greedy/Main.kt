/*
* 아직 그리디를 제대로 이해하지 못한 것 같다.
* w개수와 b개수를 세서 더 많은 걸 고른다면 바로 해결 될 문제였는데
* 탐색해서 바꾸고 하는 곳에 시간을 써버렸다.
* */
fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    val sb = StringBuilder()
    for (i in 0 until T) {
        val N = readLine().toInt()
        val origin = StringBuilder(readLine())
        val goal = StringBuilder(readLine())
        var wCount = 0
        var bCount = 0
        for (i in origin.indices) {
            if (origin[i] != goal[i]) {
                if(origin[i] == 'W'){
                    wCount++
                }else{
                    bCount++
                }
            }
        }
        sb.append(maxOf(wCount,bCount)).append("\n")

    }
    print(sb)
}