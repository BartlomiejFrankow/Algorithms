package com.example.algorithms.union.kotlin

/*
    Quick Find example O(n^2) - too slow for big problems
    It takes time proportional to depth of 'p' and 'q'

    Defects:
    - Union is too expensive (N array accesses)
    - Trees are flat, but too expensive to keep them flat
    */

class QuickFindKotlin {

    private lateinit var id: IntArray

    fun quickFind(N: Int) {
        id = IntArray(N)

        for (i in 0 until N) {
            id[i] = i
        }
    }

    fun connected(p: Int, q: Int) = id[p] == id[q]

    fun union(p: Int, q: Int) {
        val pid = id[p]
        val qid = id[q]

        for (i in id.indices) {
            if (id[i] == pid) id[i] = qid
        }
    }
}

