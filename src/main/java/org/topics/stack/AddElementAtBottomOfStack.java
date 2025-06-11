package org.topics.stack;

import java.util.Stack;

//Add element at the bottom of Stack
public class AddElementAtBottomOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        System.out.println(stack);
        pushAtBottom(5, stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek() + " ");
            stack.pop();
        }
    }

    public static void pushAtBottom(int data, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(data, stack);
        stack.push(top);

    }
}
