package com.example.algorithms.union.kotlin
/*
    Quick union - faster than quick find but still too slow
    Takes constant time given roots

    Defects:
    - Trees can get tall
    - Find too expensive (could be N array accesses)
    */

class QuickUnionKotlin {
    private lateinit var id: IntArray
    private lateinit var sizeArray: IntArray // count number of objects in the tree rooted at 'i'

    fun startQuickUnion(N: Int) {
        id = IntArray(N)
        for (i in 0 until N) {
            id[i] = i
        }
    }

    private fun root(i: Int): Int {
        var index = i

        while (index != id[index]) {
            id[index] = id[id[index]] // Path compression improvement line (it's flatting tree)
            index = id[index]
        }
        return index
    }

    fun connected(p: Int, q: Int) = root(p) == root(q)

    // union() implementation
    fun union(p: Int, q: Int) {
        val i = root(p)
        val j = root(q)

        id[i] = j
    }

    /*
    Weight improved union() implementation
    - link root of smaller tree to root of larger tree
    - update the sizeArray[]

    Thanks to update depth of any node 'x' is at most log N (lg - base 2 logarithm)
    */
    fun weightedUnion(p: Int, q: Int) {
        val i = root(p)
        val j = root(q)

        if (i == j) return
        if (sizeArray[i] < sizeArray[j]) {
            id[i] = j
            sizeArray[j] += sizeArray[i]
        } else {
            id[j] = i
            sizeArray[i] += sizeArray[j]
        }
    } // Thanks to all modifications time complexity is O(n) - great!
}
