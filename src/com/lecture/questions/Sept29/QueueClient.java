package com.lecture.questions.Sept29;

public class QueueClient {
    public static void main(String[] args) throws QueueException {
        String[] names = {"ravi","sudeep","garima","aishwarya","sachin","kapil","parth","jay","mohit","rajni"};
        OptimizedQueue<String> optimizedQueue = new OptimizedQueue<>();
        CircularOptimizedQueue<Integer> queue = new CircularOptimizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        System.out.println(queue.dequeue());
        queue.enqueue(11);
        queue.display();

        for (String name:names) {
            optimizedQueue.enqueue(name);
        }
//        for (int i = 0; i < 10 ; i++) {
//            System.out.println(optimizedQueue.dequeue());
//        }

        optimizedQueue.dequeue();
        optimizedQueue.dequeue();
        optimizedQueue.dequeue();
        optimizedQueue.dequeue();
        optimizedQueue.dequeue();
        System.out.println(optimizedQueue);
        optimizedQueue.enqueue("ravi shankar");

        //System.out.println(optimizedQueue);


    }
}
