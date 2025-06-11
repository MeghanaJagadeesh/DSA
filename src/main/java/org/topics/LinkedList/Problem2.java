package org.topics.LinkedList;

import java.util.LinkedList;

public class Problem2 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        printList(head);

        head = reverseBetween(head, 2, 4);

        System.out.println("After reversing from position 2 to 4:");
        printList(head);

    }

    //  1,2,3,4,5,6,7       //1,4,3,2,5,6
    private static Node reverseBetween(Node head, int left, int right) {

        if (head == null || head.next == null || left == right) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        //pre 1
        Node current = prev.next;     //2
        Node next = current.next;     //3
        for (int i = 1; i < right - left; i++) {
            current.next = next.next;

        }
        return null;
    }

    public static void printList(Node head) {
        if (head == null)
            return;
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }
}
