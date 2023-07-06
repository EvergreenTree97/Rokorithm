fun main() {
    with(System.`in`.bufferedReader()) {
        Array(readLine().toInt()) {
            readLine()
        }.distinct().sortedWith(SortWord).also {
            print(it.joinToString("\n"))
        }
    }
}

object SortWord : Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        return when {
            o1.length < o2.length -> -1
            o1.length > o2.length -> 1
            else -> o1.compareTo(o2)
        }
    }
}