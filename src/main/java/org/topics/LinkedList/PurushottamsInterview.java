package org.topics.LinkedList;

// we have two node
// l1=1,2,3,4,5,6;
// l2=4,5,6,7,8,9;
// return me a node at which node it is merging
public class PurushottamsInterview {
    public static void main(String[] args) {
        Node common = new Node(6);
        common.next = new Node(7);
        common.next.next = new Node(8);

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = common; // 3 -> 6 -> 7 -> 8

        Node head2 = new Node(1);
        head2.next = new Node(5);
        head2.next.next = common;

        PurushottamsInterview interview = new PurushottamsInterview();
        Node result = interview.mergedNode(head1, head2);
        System.out.println(result != null ? "Intersection at node with value: " + result.data : "No intersection");

        System.out.print("All Common Nodes: ");
        interview.getAllCommonNode(head1, head2);
    }

    public Node mergedNode(Node head1, Node head2) {
        Node pt1 = head1;
        Node pt2 = head2;
        while (pt1 != pt2) {
            pt1 = (pt1 == null) ? head2 : pt1.next;
            pt2 = (pt2 == null) ? head1 : pt2.next;
        }
        return pt1;
    }

    public void getAllCommonNode(Node head1, Node head2) {
        Node merge = mergedNode(head1, head2);
        while (merge != null) {
            System.out.print(merge.data + " ");
            merge = merge.next;
        }
    }
}
