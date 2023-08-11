fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val minHeap = MinHeap()
    val sb = StringBuilder()
    for (i in 0 until N) {
        val input = readLine().toInt()
        if (input == 0) {
            sb.appendLine(minHeap.delete())
        } else {
            minHeap.insert(input)
        }
    }
    print(sb.toString())
}

class MinHeap {
    private val list: MutableList<Int> = mutableListOf()

    init {
        list.add(0)
    }

    fun insert(X: Int) {
        list.add(X)
        var cur = list.size - 1
        var parent = cur / 2

        while (true) {
            if (parent == 0 || list[parent] <= list[cur]) break
            val temp = list[parent]
            list[parent] = list[cur]
            list[cur] = temp
            cur = parent
            parent = cur / 2
        }
    }

    fun delete(): Int {
        if (list.size == 1) {
            return 0
        }
        val top = list[1]

        list[1] = list[list.size - 1]
        list.removeAt(list.size - 1)

        var currentPos = 1
        while (true) {
            val leftPos = currentPos * 2
            val rightPos = currentPos * 2 + 1

            if (leftPos >= list.size) {
                break
            }

            var minValue = list[leftPos]
            var minPos = leftPos

            if (rightPos < list.size && list[rightPos] < minValue) {
                minValue = list[rightPos]
                minPos = rightPos
            }
            if (list[currentPos] > minValue) {
                val temp = list[currentPos]
                list[currentPos] = minValue
                list[minPos] = temp
                currentPos = minPos
            } else {
                break
            }
        }
        return top
    }
}