import java.util.*
import kotlin.collections.ArrayDeque

const val APPLE = 2

/*
* 큐, 덱 등을 사용한 구현 문제
* 테스트 케이스에 의존하지 않고, 어디서 어떤 문제가 발생할지 혼자 판단하는 능력이 필요하다.
* */

fun main() {
    with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val K = readLine().toInt()
        val board = Array(N) {
            IntArray(N)
        }.apply {
            repeat(K) {
                val (row, col) = readLine().split(" ").map(String::toInt)
                this[col - 1][row - 1] = APPLE
            }
        }
        val L = readLine().toInt()
        val dirChanges: Queue<Node> = LinkedList<Node>().apply {
            repeat(L) {
                val (count, dir) = readLine().split(" ")
                this.add(Node(count.toInt(), dir))
            }
        }
        var count = 0
        val snakePoints = ArrayDeque<Point>().apply {
            addFirst(Point(0, 0))
        }
        var direction = Direction.RIGHT
        while (true) {
            count++
            val head = snakePoints.first()
            val nextPoint = getNextPoint(direction, head.x, head.y)
            if (nextPoint.x < 0 || nextPoint.x >= N
                || nextPoint.y < 0 || nextPoint.y >= N
                || snakePoints.contains(nextPoint)
            ) {
                break
            }
            if (board[nextPoint.x][nextPoint.y] == APPLE) {
                board[nextPoint.x][nextPoint.y] = 0
                snakePoints.addFirst(nextPoint)
            } else {
                snakePoints.addFirst(nextPoint)
                snakePoints.removeLast()
            }
            if(dirChanges.isNotEmpty() && dirChanges.peek().count == count){
                val node = dirChanges.poll()
                direction = if (node.dir == "L") {
                    direction.rotateLeft()
                } else {
                    direction.rotateRight()
                }
            }
        }
        print(count)
    }
}

fun getNextPoint(direction: Direction, x: Int, y: Int): Point {
    return when (direction) {
        Direction.LEFT -> Point(x - 1, y)
        Direction.RIGHT -> Point(x + 1, y)
        Direction.UP -> Point(x, y - 1)
        Direction.DOWN -> Point(x, y + 1)
    }
}

data class Point(
    val x: Int,
    val y: Int,
)

data class Node(
    val count: Int,
    val dir: String,
)

enum class Direction {
    LEFT, RIGHT, UP, DOWN;

    fun rotateLeft(): Direction {
        return when (this) {
            LEFT -> DOWN
            RIGHT -> UP
            UP -> LEFT
            DOWN -> RIGHT
        }
    }

    fun rotateRight(): Direction {
        return when (this) {
            LEFT -> UP
            RIGHT -> DOWN
            UP -> RIGHT
            DOWN -> LEFT
        }
    }
}
