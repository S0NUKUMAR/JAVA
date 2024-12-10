package javalearning.JavaCollection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackExamples {
    public static void main(String[] args) {
        // Using Stack class
        Stack<String> stack = new Stack<>();
        stack.push("Stack Item 1");
        stack.push("Stack Item 2");
        System.out.println("Stack Class: " + stack.pop());

        // Using ArrayDeque class
        Deque<String> arrayDequeStack = new ArrayDeque<>();
        arrayDequeStack.push("ArrayDeque Item 1");
        arrayDequeStack.push("ArrayDeque Item 2");
        System.out.println("ArrayDeque: " + arrayDequeStack.pop());

        // Using LinkedList class
        LinkedList<String> linkedListStack = new LinkedList<>();
        linkedListStack.push("LinkedList Item 1");
        linkedListStack.push("LinkedList Item 2");
        System.out.println("LinkedList: " + linkedListStack.pop());

    }
}

/*
 */