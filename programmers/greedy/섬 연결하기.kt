class Solution {
    lateinit var parent: IntArray
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        parent = IntArray(n) { it }
        costs.sortBy { it[2] }
        for (element in costs) {
            val (a, b, cost) = element
            val findA = find(a)
            val findB = find(b)
            if (findA != findB) {
                answer += cost
                union(findA, findB)
            }
        }
        return answer
    }

    fun union(a: Int, b: Int) {
        val findA = find(a)
        val findB = find(b)
        if (findA < findB) {
            parent[findB] = findA
        } else {
            parent[findA] = findB
        }
    }

    fun find(x: Int): Int {
        return if (x == parent[x]) x
        else {
            find(parent[x]).also {
                parent[x] = it
            }
        }
    }
}