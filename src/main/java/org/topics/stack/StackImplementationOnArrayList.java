package org.topics.stack;

import java.util.ArrayList;
import java.util.List;

public class StackImplementationOnArrayList {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        show();
        System.out.println("pop: " + pop());
        System.out.print("after pop: ");
        show();
        System.out.println("peek: " + peek());
        System.out.print("after peek: ");
        show();
    }

    public static void push(int data) {
        list.add(data);
    }

    public static int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public static int peek() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.get(list.size() - 1);
        }
    }

    public static void show() {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + "->");
        }
        System.out.println();
    }
}
