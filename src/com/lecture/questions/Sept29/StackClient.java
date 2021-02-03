package com.lecture.questions.Sept29;

public class StackClient {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }

        for (int i = 0; i <11 ; i++) {
            System.out.println(stack.pop());
        }


    }
}
