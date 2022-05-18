package com.example.algorithms.sort.merge.java;

import static com.example.algorithms.help.StdOut.println;
import static com.example.algorithms.sort.SortHelperJava.less;

import java.util.Arrays;

/*
 * Time complexity: O(n log n)
 * Compares? Merge sort IS OPTIMAL with respect to number of compares.
 * Space? Merge sort IS NOT OPTIMAL with respect to space usage.
 */
public class MergeSortJava {

    private static long beginTime;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

        println("MERGE SORT JAVA TIME: " + (System.currentTimeMillis() - beginTime) + ", results: " + Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        println("MERGE SORT JAVA INPUT DATA: " + Arrays.toString(a));

        beginTime = System.currentTimeMillis();

        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

}
