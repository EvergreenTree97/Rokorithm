lateinit var visited: BooleanArray
var input = ""
val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()){
    input = readLine()
    visited = BooleanArray(input.length)
    dfs(0,input.length-1)
    print(sb)

}
fun dfs(left: Int, right: Int){
    if(left > right) return // 탈출조건

    var idx = left
    for(i in left .. right){ //범위 내에서 최소값을 찾는다
        if(input[idx] > input[i]){
            idx = i
        }
    }
    visited[idx] = true
    for (i in input.indices){ //출력
        if(visited[i]){
            sb.append(input[i])
        }
    }
    sb.append("\n")
    dfs(idx+1,right) // 오른 쪽 먼저 확인
    dfs(left, idx -1) // 왼쪽 확인

}

//https://www.acmicpc.net/problem/16719