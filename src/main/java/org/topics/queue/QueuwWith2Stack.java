package org.topics.queue;

import java.util.Queue;
import java.util.Stack;

public class QueuwWith2Stack {

    public static class Queue {
        static Stack<Integer> stack1 = new Stack<>();
        static Stack<Integer> stack2 = new Stack<>();

        public static void push(int data) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(data);

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public static int pop() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return stack1.pop();
        }

        public static int peek() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return stack1.peek();
        }

        public static void show() {
            while (!stack1.isEmpty()) {
                System.out.print(stack1.pop() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue.push(1);
        Queue.push(2);
        Queue.push(3);
        Queue.push(4);

        System.out.println("pop: " + Queue.pop());
        Queue.push(5);
        Queue.show();
    }
}
