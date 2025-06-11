package org.topics.LinkedList;

import java.util.Collections;

public class Linkedlist {
    static Node head;

    public static void main(String[] args) {
        insert(10);
        insert(12);
        insert(3);
        insert(98);
        insert(9);
        insert(87);
        System.out.print("linkedlist: ");
        showData();

        insertAtStart(2);
        System.out.print("Insert at start: ");
        showData();

        insertAt(2, 11);
        System.out.print("Insert at: ");
        showData();

        deleteAt(3);
        System.out.print("delete at: ");
        showData();

        deleteData(3);
        System.out.print("delete data: ");
        showData();

        insertAtLast(90);
        System.out.print("Insert at last: ");
        showData();

        deleteAtLast();
        System.out.print("Delete at last: ");
        showData();

        reverseIteratively();
        System.out.print("reverse - Iterative: ");
        showData();

        head = reverseRecursively(head);
        System.out.print("reverse - recursively: ");
        showData();

    }

    private static Node reverseRecursively(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newhead = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public static void reverseIteratively() {
        if (head == null || head.next == null) {
            return;
        }
        Node previous = head;
        Node current = head.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }
        head.next = null;
        head = previous;
    }


    private static void deleteAtLast() {
        Node n = head;
        while (n.next.next != null) {
            n = n.next;
        }
        n.next = n.next.next;
    }

    private static void insertAtLast(int data) {
        Node node = new Node(data);
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
    }

    private static void deleteData(int data) {
        Node n = head;
        if (n.data == data) {
            head = head.next;
        } else {
            while (n.next != null) {
                if (n.next.data == data) {
                    n.next = n.next.next;
                }
                n = n.next;
            }
        }
    }

    private static void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    private static void insertAtStart(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private static void insertAt(int index, int data) {
        Node node = new Node(data);
        Node n = head;
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    private static void showData() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print(node.data + " \n");
    }

    public static void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }
}
