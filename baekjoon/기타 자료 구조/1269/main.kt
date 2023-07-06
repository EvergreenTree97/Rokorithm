fun main() {
    with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val a = readLine().split(" ").map(String::toInt).toSet()
        val b = readLine().split(" ").map(String::toInt).toSet()
        print(a.getSubtractionCount(b)+b.getSubtractionCount(a))
    }
}

fun <T> Set<T>.getSubtractionCount(other: Set<T>) = toMutableSet().run{
    other.forEach {
        if(contains(it)){
            remove(it)
        }
    }
    count()
}
