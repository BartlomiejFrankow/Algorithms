package com.example.algorithms.union;

public class QuickUnion {

    /*
    Quick union - faster than quick find but still too slow
    Takes constant time given roots

    Defects:
    - Trees can get tall
    - Find too expensive (could be N array accesses)
    */

    private int[] id;
    private int[] sizeArray; // count number of objects in the tree rooted at 'i'

    public void quickUnion(int N) {
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

    boolean quConnected(int p, int q) {
        return root(p) == root(q);
    }

    // Quick union union() implementation
    public void quUnion(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    /*
    Quick union weight improved union() implementation
    - link root of smaller tree to root of larger tree
    - update the sizeArray[]

    Thanks to update depth of any node 'x' is at most log N (lg - base 2 logarithm)
    */
    public void quWeightedUnion(int p, int q) {
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
