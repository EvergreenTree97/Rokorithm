fun main() {
    with(System.`in`.bufferedReader()) {
        Array(readLine().toInt()) {
            Serial(readLine()!!)
        }.sorted().also {
            print(it.joinToString("\n"))
        }
    }
}

data class Serial(
    val number: String,
) : Comparable<Serial> {
    override fun compareTo(other: Serial): Int {
        return when {
            number.length < other.number.length -> -1
            number.length > other.number.length -> 1
            number.mapFold() < other.number.mapFold() -> -1
            number.mapFold() > other.number.mapFold() -> 1
            else -> number.compareTo(other.number)
        }
    }

    override fun toString(): String {
        return number
    }
}

private fun String.mapFold() = map {
    if (it in 'A'..'Z') {
        0
    } else{
        it.toInt()
    }
}.fold(0) { acc, c ->
    acc + c
}
