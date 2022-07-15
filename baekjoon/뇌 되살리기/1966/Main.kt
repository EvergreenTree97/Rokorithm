fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val (N, M) = readLine().split(" ").map { it.toInt() }
        val order = readLine().split(" ")
                .map { Node(it.toInt()) }
        order[M].isGoal = true
        val queue = ArrayList<Node>(order)
        var count = 0
        var isAvailable = true
        while(queue.isNotEmpty()){
            val current = queue.removeAt(0)
            for(node in queue){
                if(current.order < node.order){
                    isAvailable = false
                    break
                }
            }
            if(!isAvailable){
                queue.add(current)
                isAvailable = true
            }else{
                count++
                if(current.isGoal){
                    break
                }
            }
        }
        sb.append("$count\n")
    }
    print(sb.toString())
}

data class Node(
        var order: Int,
        var isGoal: Boolean = false
)