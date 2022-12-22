lateinit var arr: IntArray
lateinit var selected: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    arr = IntArray(9){ readLine().toInt() }
    selected = IntArray(7)
    combination(0,0)
}

fun combination(start: Int, count: Int){
    if(count >= 7){
        selected.sum().also {
            if(it == 100){
                selected.forEach { num ->
                    println(num)
                }
                return
            }
        }
        return
    }
    (start until 9).forEach{ i ->
        selected[count] = arr[i]
        combination(i+1, count+1)
    }
}