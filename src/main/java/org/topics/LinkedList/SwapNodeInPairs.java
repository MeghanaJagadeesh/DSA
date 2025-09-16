package org.topics.LinkedList;
//Swap a nodes in a pair
//input : 1 -> 2 -> 3 -> 4
//output : 2 -> 1 -> 4 -> 3
public class SwapNodeInPairs {
    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original list:");
        printList(head);

        head = swapPairs(head);

        System.out.println("After swapping in pairs:");
        printList(head);
    }

    private static Node swapPairs(Node head) {
        Node dummy=new Node(0);
        dummy.next=head;

        Node prev=dummy;
        while (prev.next!=null&&prev.next.next!=null){
            // initialise first and second
            Node first=prev.next;
            Node second=first.next;

//          swapping
            first.next=second.next;
            second.next=first;

//          updating dummy or moving forward
            prev.next=second;
            prev=first;
        }
        return dummy.next;


    }

    public static void printList(Node head){
        if(head==null)
            return;
        Node node=head;
        while (node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.println();
    }
}
