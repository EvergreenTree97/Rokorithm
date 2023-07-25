fun main() {
    with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        hashMapOf<String, Int>().apply {
            repeat(N + M) {
                val name = readLine()
                put(name, getOrDefault(name, 0) + 1)
            }
        }.filterValues {
            it >= 2
        }.map {
            it.key
        }
        .sorted()
        .also {
            println(it.count())
            print(it.joinToString("\n"))
        }
    }
}