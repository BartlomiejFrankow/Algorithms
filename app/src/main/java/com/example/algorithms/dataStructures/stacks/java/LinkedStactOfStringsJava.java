package com.example.algorithms.dataStructures.stacks.java;

// Every operation takes constant time in worst case - super fast!
// Uses extra time and space to deal with the links
public class LinkedStactOfStringsJava {
    private Node first = null;

    // Time complexity: every operation takes constant time in the worst case O(n)
    // Space complexity: stack with N times uses ~ 40N bytes
    private class Node {
        String item;
        Node next;
    }

    boolean isEmpty() {
        return first == null;
    }

    void push(String item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    String pop() {
        String item = first.item;

        first = first.next;
        return item;
    }
}
