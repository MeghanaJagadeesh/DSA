package org.topics.stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("input");
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        reverse(stack);
        System.out.println("output");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverse(stack);
        pushAtBottom(top, stack);
    }

    public static void pushAtBottom(int data, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(data, stack);
        stack.add(top);
    }

    public static void show(Stack<Integer> stack) {
        if (stack.isEmpty()) System.out.println("stack is empty");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
