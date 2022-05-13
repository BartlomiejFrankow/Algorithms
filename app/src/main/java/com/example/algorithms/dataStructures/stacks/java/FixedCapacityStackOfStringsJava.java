package com.example.algorithms.dataStructures.stacks.java;

public class FixedCapacityStackOfStringsJava {
    private String[] s;
    private int n = 0;

    FixedCapacityStackOfStringsJava(int capacity) {
        s = new String[capacity];
    }

    boolean isEmpty() {
        return n == 0;
    }

    void push(String item) {
        s[n++] = item;
    }

    // Loitering - holding a reference to an object when is no longer needed
    // Loitering pop
    String loiteringPop() {
        return s[--n];
    }

    // This version avoids loitering. Garbage collector can reclaim memory only if no outstanding references
    String pop() {
        String item = s[--n];
        s[n] = null;
        return item;
    }
}
