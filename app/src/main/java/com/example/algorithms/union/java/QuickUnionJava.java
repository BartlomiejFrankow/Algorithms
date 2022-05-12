package com.example.algorithms.union.java;

public class QuickUnionJava {

    /*
    Quick union - faster than quick find but still too slow
    Takes constant time given roots

    Defects:
    - Trees can get tall
    - Find too expensive (could be N array accesses)
    */

    private int[] id;
    private int[] sizeArray; // count number of objects in the tree rooted at 'i'

    public void startQuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // Path compression improvement line (it's flatting tree)
            i = id[i];
        }
        return i;
    }

    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // union() implementation
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    /*
    Weight improved union() implementation
    - link root of smaller tree to root of larger tree
    - update the sizeArray[]

    Thanks to update depth of any node 'x' is at most log N (lg - base 2 logarithm)
    */
    public void weightedUnion(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if (sizeArray[i] < sizeArray[j]) {
            id[i] = j;
            sizeArray[j] += sizeArray[i];
        } else {
            id[j] = i;
            sizeArray[i] += sizeArray[j];
        }
    }

    // Thanks to all modifications time complexity is O(n) - great!
}
