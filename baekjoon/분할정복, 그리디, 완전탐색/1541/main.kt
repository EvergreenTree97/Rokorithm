fun main() {
    with(System.`in`.bufferedReader()) {
        readLine().split("-").map{
            it.split("+").map(String::toInt).sum()
        }.reduce { acc, i ->
            acc-i
        }.also(::print)
    }
}

//최소로 만들기 위해서는, 큰 수를 - 해야한다. 이는 곧 +인 부분들을 괄호로 묶어줘야 한다.