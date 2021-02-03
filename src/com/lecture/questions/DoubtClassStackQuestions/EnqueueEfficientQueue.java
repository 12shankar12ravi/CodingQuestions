package com.lecture.questions.DoubtClassStackQuestions;


import java.util.Stack;

/**
 *  Given two stacks one is primary and other is secondary,
 *  You need to create a queue by using the two stacks
 *   1. Enqueue efficient queue -> O(1) time enqueue of one element
 *   2. Dequeue efficient queue -> O(1) time dequeue of one element
 *  Note : The enque and deque operations should be done on primary queue , secondary can be used for intermediate states.
 *
 */
public class EnqueueEfficientQueue {

    private Stack primary ;
    private Stack secondary ;

    EnqueueEfficientQueue(){
        this.primary = new Stack();
        this.secondary = new Stack();
    }

    public static void main(String[] args) {
        // Enqueue efficient queue
        EnqueueEfficientQueue queue = new EnqueueEfficientQueue();

        for (int i = 1; i <= 10 ; i++) {
            queue.enqueue(i*2);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());
    }

    // Enqueue efficient queue (enqueue method)
    public void enqueue(int value){
        primary.push(value);
    }

    // Enqueue efficient queue (dequeue method)
    public int dequeue(){
        while(primary.size()>1){
            secondary.push(primary.pop());
        }
        int value = (int)primary.pop();
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
        return value;
    }

    @Override
    public String toString(){
        return primary.toString();
    }

}
