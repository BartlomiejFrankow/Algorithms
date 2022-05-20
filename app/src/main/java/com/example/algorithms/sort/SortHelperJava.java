package com.example.algorithms.sort;

public class SortHelperJava {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static int compareTo(Comparable v, Comparable w){
        return v.compareTo(w);
    }

}
