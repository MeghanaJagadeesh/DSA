package org.topics.queue;

// Queue Implementation with array
public class QueueWithArray {

    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;

        Queue(int size) {
            arr = new int[size];
            this.size = size;
        }

        //      enqueue or push
        public static void enqueue(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        //        dequeue or poll
        public static int dequeue() {
            if (rear == -1) {
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        //      front or peek
        public static int front() {
            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

        public static void showData() {
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Queue queue = new Queue(3);
        Queue.enqueue(1);
        Queue.enqueue(2);
        Queue.enqueue(3);

        Queue.showData();
        System.out.println("front/peek : " + Queue.front());
        Queue.showData();
        System.out.println("dequeue/poll : " + Queue.dequeue());
        Queue.showData();
        Queue.enqueue(4);
        Queue.showData();
//        Queue.enqueue(5);
    }

}
