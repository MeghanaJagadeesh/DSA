package org.topics.LinkedList;

import java.util.LinkedList;

// Leetcode 19 - Remove nth node from the end of the linked list
public class Problem1 {
    static Node head;

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        showData();
        head = removeNthFromEnd(head, 2);
        System.out.println(head.data);
        showData();
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node left = dummy;
        Node right = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;

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

