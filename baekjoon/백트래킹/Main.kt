
var N = 0
var M = 0
val sb = StringBuilder()
lateinit var arr : IntArray
lateinit var visited: BooleanArray
fun main() = with(System.`in`.bufferedReader()) {
    val read = readLine().split(" ").map { it.toInt() }
    N = read[0]
    M = read[1]
    arr = IntArray(N){ it+1 }
    for(i in 0 until  N){
        visited = BooleanArray(N+1)
        backTracking("${arr[i]}",1,i)
    }

    print(sb.toString())
}

fun backTracking(sequence: String,length: Int, index: Int){
    visited[index] = true
    if(length == M){
        sb.append("$sequence\n")
        return
    }
    for(i in 0 until N){
        if(!visited[i]){
            backTracking("$sequence ${arr[i]}",length+1, i)
            visited[i] = false
        }
    }
}
/*
* 어느 누군가의 풀이인데, 이런 매커니즘을 잘 기억해 놔야겠다.
* fun BT(idx:Int, N:Int, M:Int, visit: BooleanArray, array:IntArray) {
	if (idx == M) {
		for(a in array) {
			bw.write("${a} ")
		}
		bw.write("\n")
		return
	}

	for(n in 1..N) {
		if (visit[n]) {
			continue
		}

		visit[n] = true
		array[idx] = n
		BT(idx+1, N, M, visit, array)
		visit[n] = false
	}
}
* */
