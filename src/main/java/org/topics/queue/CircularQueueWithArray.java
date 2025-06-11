package org.topics.queue;

public class CircularQueueWithArray {

    static class Queue {

        static int[] arr;
        static int size;
        static int rear = -1;
        static int front = -1;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        //enqueue - O(1)
        public static void enqueue(int data) {
            //is full
            if ((rear + 1) % size == front) {
                System.out.println((rear + 1) % size);
                System.out.println(front);
                System.out.println("queue is full");
            }
            //if first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static void showData() {

        }

        //dequeue - O(1)
        public static int dequeue() {
            if (rear == -1 && front == -1) {
                System.out.println("queue is empty");
                return -1;
            }
            int frontEle = arr[front];
            //if queue has single element
            if (front == rear) {
                rear = front = -1;
            } else { //if not front will be frowarded one step ahead
                front = (front + 1) % size;
            }
            return frontEle;
        }

        //peek - O(1)
        public static int peek() {
            if (rear == -1 && front == -1) {
                System.out.println("Queue is full");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        Queue.enqueue(1);
        Queue.enqueue(2);
        Queue.enqueue(3);
        System.out.println("dequeue => " + Queue.dequeue());
        Queue.enqueue(4);
//        System.out.println("dequeue => " + Queue.dequeue());
        Queue.enqueue(5);

        System.out.println("peek => " + Queue.peek());

//        Queue.showData();

    }
}
