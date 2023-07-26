fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val g= Array(N){ i ->
            readLine().split(" ").map(String::toInt).toIntArray()
        }
        for(k in g.indices){
            for(i in g.indices){
                for(j in g.indices){
                    if(g[i][k] == 1 && g[k][j] == 1){
                        g[i][j] = 1
                    }
                }
            }
        }
        val sb = StringBuilder()
        for(i in g.indices){
            for(j in g.indices){
                sb.append("${g[i][j]} ")
            }
            sb.appendLine()
        }
        print(sb.toString())
    }
}

/*
* 모든 정점에서 모든 정점 까지의 최단 거리를 구하는 Floyd-Washall 알고리즘을 응용
*
*
* */