import kotlin.math.min

fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val lengths = readLine().split(" ").map(String::toLong).toLongArray()
        val cities = readLine().split(" ").map(String::toLong).toLongArray()
        var gas = cities[0] * lengths[0]
        var index = 1
        var minGasPrice = cities[0]
        while(index < N-1){
            if(cities[index] < minGasPrice){
                minGasPrice = cities[index]
            }
            gas += minGasPrice * lengths[index]
            index++
        }
        print(gas)
    }
}

//1. dp로 풀었으나 ,17점만 나옴
//2. 그리디로 풀 수 있더라.. 하..

