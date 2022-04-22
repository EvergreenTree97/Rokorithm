import kotlin.math.sqrt

var N = 0
lateinit var isPrime : BooleanArray
fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    isPrime = BooleanArray(N+2)
    getPrime()
    var s = 2
    var e = 2
    var sum = 2
    var count = 0
    while(e <= N){
        if(sum == N){
            if(isPrime[s]) {
                s++
                continue
            }
            count++
            sum -= s++
        }else if(sum < N){
            e++
            if(isPrime[e]) continue
            sum += e
        }else if(sum > N){
            if(isPrime[s]) {
                s++
                continue
            }
            sum -= s++
        }
    }
    print(count)


}
fun getPrime() {
    isPrime[0] = true
    isPrime[1] = true
    for (i in 2 .. sqrt(N.toDouble()).toInt()){ //에라토스테네스의 체 최적화
        if(!isPrime[i]){
            for (j in i*i .. N step i ){
                isPrime[j] = true
            }
        }
    }
}
