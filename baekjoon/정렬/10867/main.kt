fun main() {
    with(System.`in`.bufferedReader()) {
        readLine().toInt()
        readLine()
            .split(" ")
            .map(String::toInt)
            .toTypedArray()
            .distinct()
            .sorted()
            .run {
                print(joinToString(" "))
            }
    }
}
