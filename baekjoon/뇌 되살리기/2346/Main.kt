import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var order = 1
    val read = readLine().split(" ").map { Pair(order++, it.toInt()) }
    val list = ArrayList<Pair<Int, Int>>(read)
    var index = 0
    val sb = StringBuilder()
    while (true) {
        sb.append("${list[index].first} ")
        var next = list[index].second
        list.removeAt(index)
        if(list.isEmpty()) break

        if(next >0) next--
        index += next
        while(index !in list.indices){
            if(index <0) index += list.size
            index %= list.size
        }
    }
    print(sb)
}