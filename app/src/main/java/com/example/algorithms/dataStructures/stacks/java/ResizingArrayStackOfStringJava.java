package com.example.algorithms.dataStructures.stacks.java;

/*
The quickies and the most efficient algorithm from 'stacks' package
Every operation takes constant amortized time
Less wasted space
*/

public class ResizingArrayStackOfStringJava {
    private String[] stack;
    private int n = 0;

    ResizingArrayStackOfStringJava() {
        stack = new String[1];
    }

    boolean isEmpty() {
        return n == 0;
    }

    // Double size of array when array is full
    void push(String item) {
        if (n == stack.length) {
            resize(2 * stack.length);
        }
        stack[n++] = item;
    }

    // Divide size of array by half when array is one-quarter full
    String pop() {
        String item = stack[--n];
        stack[n] = null;

        if (n > 0 && n == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    // Inserting first 'n' items takes time proportional to O(n) - not O(n^2)
    private void resize(int capacity) {
        String[] copy = new String[capacity];

        for (int i = 0; i < n; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }
}
