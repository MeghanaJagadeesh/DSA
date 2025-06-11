package org.topics.queue;

public class QueueWithLL {
    static Node head = null;
    static Node tail = null;

    // enqueue = O(1)
    public static void enqueue(int data) {
        Node node = new Node(data);
        //if it is first element
        if (tail == null) {
            head = node;
            tail = node;
            return;
        }
        //if we have single element
        if (head == tail) {
            tail = null;
        }
        tail.next = node;
        tail = node;
    }

    //  dequeue = O(1)
    public static int dequeue() {
        if (tail == null || head == null) {
            System.out.println("queue id empty");
            return -1;
        }
        Node n = head;
        head = head.next;
        return n.data;
    }

    public static int front() {
        if (tail == null && head == null) {
            System.out.println("queue is empty");
            return -1;
        }
        return head.data;
    }

    public static void showData() {
        Node n = head;
        while (n.next != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        System.out.println("dequeue: " + dequeue());
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        showData();
        System.out.println("front: " + front());
        System.out.println("dequeue: " + dequeue());
        showData();

    }
}
