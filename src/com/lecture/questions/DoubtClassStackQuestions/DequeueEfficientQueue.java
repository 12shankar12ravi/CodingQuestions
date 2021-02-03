package com.lecture.questions.DoubtClassStackQuestions;

import java.util.Stack;

public class DequeueEfficientQueue {
    private Stack<Integer> primary ;
    private Stack<Integer> secondary ;

    DequeueEfficientQueue(){
        this.primary = new Stack<>();
        this.secondary = new Stack<>();
    }

    public static void main(String[] args) {
        // Enqueue efficient queue
        DequeueEfficientQueue queue = new DequeueEfficientQueue();

        for (int i = 1; i <= 10 ; i++) {
            queue.enqueue(i*2);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    // Dequeue efficient queue (enqueue method)
    public void enqueue(int value){
        while(!primary.isEmpty()){
            secondary.push(primary.pop());
        }
        primary.push(value);
        while (!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
    }

    // Dequeue efficient queue (dequeue method)
    public int dequeue(){
        return primary.pop();
    }

    @Override
    public String toString(){
        return primary.toString();
    }
}
