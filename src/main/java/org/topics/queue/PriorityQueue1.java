package org.topics.queue;

import java.util.PriorityQueue;

public class PriorityQueue1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        input: 5,2,1,9,3,6    output: 1,3,2,9,5,6
//        input: 1,2,3,6,7,7    output: 1 2 3 6 7 7
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(6);
        queue.add(7);
        queue.add(7);
        System.out.println(queue);
    }
}
