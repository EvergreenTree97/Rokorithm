fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        readLine()
            .split(" ")
            .map(String::toInt)
            .sorted()
            .foldIndexed(0) { index, acc, value ->
                acc + (N - index) * value
            }
            .also {
                println(it)
            }
    }
}

//12334
//1 3 6 9 13