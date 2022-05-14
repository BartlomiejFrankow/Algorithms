package com.example.algorithms.dijkstra.java;

import com.example.algorithms.help.StdIn;
import com.example.algorithms.help.StdOut;

import java.util.Stack;

/*
 * When algorithm encounters an operator surrounded by two values
 * within parentheses it leaves the result on the value stack.
 * */

public class DijkstraJava {

    /*
     * Java evaluate:
     * args = "(1 + ((2 + 3) * (4 * 5)))"
     * result is: 101.0
     */
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String string = StdIn.readString();

            if (string.equals("(")) ;
            else if (string.equals("+")) ops.push(string);
            else if (string.equals("*")) ops.push(string);
            else if (string.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() + vals.pop());
            } else {
                vals.push(Double.parseDouble(string));
            }
        }
        StdOut.println(vals.pop());
    }
}
