import java.util.*

const val MAX = 6
val sb = StringBuilder()
lateinit var S : IntArray
fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val st = StringTokenizer(readLine())
        val k = st.nextToken().toInt()
        if (k == 0) {
            break;
        }
        S = IntArray(k)
        for (i in 0 until k) {
            S[i] = st.nextToken().toInt()
        }
        for (i in 0 .. k-MAX){
            dfs(S[i].toString(),1,i)
        }
        sb.append("\n")
    }
    print(sb)
}

fun dfs(s: String, length: Int, idx: Int) {
    if (length == MAX) {
        sb.append(s+"\n")
        return
    }
    for (i in idx+1 .. S.size){
       if(S.size - i >= MAX - length && i < S.size ){
           dfs(s+" "+S[i],length+1,i)
       }
    }

}
//현재 길이 3  = 남은게 3
// 123 0 0 0 에서   1 2 3 | 4 5 6 7 중 4와 5는 고를 수 있는데 67은 못고름