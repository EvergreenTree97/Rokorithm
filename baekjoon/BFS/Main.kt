var N = 0
lateinit var g: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var normal = 0
var blindness = 0
fun main() = with(System.`in`.bufferedReader()){
    N = readLine().toInt()
    g = Array(N){
        readLine().toCharArray()
    }
    visited = Array(N){
        BooleanArray(N)
    }

    for(i in 0 until N){
        for(j in 0 until N){
            if(!visited[i][j]){
                bfs(i,j,g[i][j], true)
                normal++
            }
        }
    }
    visited = Array(N){
        BooleanArray(N)
    }
    for(i in 0 until N){
        for(j in 0 until N){
            if(!visited[i][j]){
                bfs(i,j,g[i][j], false)
                blindness++
            }
        }
    }
    print("$normal $blindness")
}
val dx = listOf(-1,0,1,0)
val dy = listOf(0,-1,0,1)
fun bfs(x: Int, y: Int, color: Char, isNormal: Boolean){
    val queue = mutableListOf<Pair<Int,Int>>()
    visited[x][y] = true
    queue.add(Pair(x,y))
    while(queue.isNotEmpty()){
        val pair = queue.removeAt(0)
        val curX = pair.first
        val curY = pair.second
        for (i in 0 .. 3){
            val nextX = curX+ dx[i]
            val nextY = curY+ dy[i]
            if(nextX in 0 until N && nextY in 0 until N){
                if(isNormal){
                    if(color == g[nextX][nextY] && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true
                        queue.add(Pair(nextX,nextY))
                    }
                }else{
                    when(color){
                        'R' ->{
                            if((color == g[nextX][nextY] || 'G' == g[nextX][nextY]) && !visited[nextX][nextY]){
                                visited[nextX][nextY] = true
                                queue.add(Pair(nextX,nextY))
                            }
                        }
                        'G' ->{
                            if((color == g[nextX][nextY] || 'R' == g[nextX][nextY]) && !visited[nextX][nextY]){
                                visited[nextX][nextY] = true
                                queue.add(Pair(nextX,nextY))
                            }
                        }
                        'B' ->{
                            if(color == g[nextX][nextY] && !visited[nextX][nextY]){
                                visited[nextX][nextY] = true
                                queue.add(Pair(nextX,nextY))
                            }
                        }

                    }

                }


            }
        }
    }
}
//https://www.acmicpc.net/problem/10026