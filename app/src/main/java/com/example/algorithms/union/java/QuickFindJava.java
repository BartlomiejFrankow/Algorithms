package com.example.algorithms.union.java;

public class QuickFindJava {

     /*
     Quick Find example O(n^2) - too slow for big problems
     It takes time proportional to depth of 'p' and 'q'

     Defects:
     - Union is too expensive (N array accesses)
     - Trees are flat, but too expensive to keep them flat
     */

    private int[] id;

    void quickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }
}
