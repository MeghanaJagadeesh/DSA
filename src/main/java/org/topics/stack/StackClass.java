package org.topics.stack;

public class StackClass {
    public static Node head;

    public static void main(String[] args) {
        StackClass stackClass = new StackClass();
        stackClass.push(10);
        stackClass.push(20);
        stackClass.push(30);
        stackClass.push(40);
        stackClass.push(50);
        stackClass.push(60);
        show();
        System.out.println("pop: "+stackClass.pop());
        show();
        stackClass.peek();
        System.out.print("after peek: ");
        show();
    }

    private int peek() {
        if (head == null) {
            return -1;
        } else {
            Node top = head;
            head = head.next;
            return top.data;
        }
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    private static void show() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }

    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}
