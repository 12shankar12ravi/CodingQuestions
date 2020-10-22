package com.lecture.questions.DoubtClassStackQuestions;


import java.util.Queue;
import java.util.Stack;

/**
 *  Given two stacks one is primary and other is secondary,
 *  You need to create a queue by using the two stacks
 *   1. Enqueue efficient queue -> O(1) time enqueue of one element
 *   2. Dequeue efficient queue -> O(1) time dequeue of one element
 *  Note : The enque and deque operations should be done on primary queue , secondary can be used for intermediate states.
 *
 */
public class QueueByUsingTwoStacks {

    public static void main(String[] args) {
        Stack primary = new Stack();
        Stack secondary = new Stack();
        for (int i = 1; i <= 10 ; i++) {
            enqueue(i*2,primary);
        }
        System.out.println(primary);
        System.out.println(dequeue(primary,secondary));
    }

    // Enqueue efficient queue (enqueue method)
    public static void enqueue(int value,Stack primary){
        primary.push(value);
    }

    // Enqueue efficient queue (dequeue method)
    public static int dequeue(Stack primary,Stack secondary){
        while(primary.size()>1){
            secondary.push(primary.pop());
        }
        int value = (int)primary.pop();
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
        return value;
    }

}
