package com.example.algorithms.dataStructures.stacks.java;

public class LinkedStactOfStringsJava {
    private Node first = null;

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
