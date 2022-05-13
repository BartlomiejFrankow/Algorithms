package com.example.algorithms.dataStructures.queue.java;

public class LinkedQueueOfStringsJava {

    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    boolean isEmpty() {
        return first == null;
    }

    void enqueue(String item) {
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    String dequeue() {
        String item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        return item;
    }

}
