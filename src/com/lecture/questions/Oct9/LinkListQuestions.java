package com.lecture.questions.Oct9;

import java.util.Scanner;

public class LinkListQuestions {

    public static void main(String[] args) {
        LinkedList<Integer> lList = new LinkedList<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of elements->");
        int n = scn.nextInt();
        System.out.println("Enter elements one by one");
        while (n-->0){
            lList.insertAtLast(scn.nextInt());
        }
//        System.out.println("Enter looping element");
//        lList.createLoop(scn.nextInt());
//        System.out.println(lList);
//
//        //System.out.println("Loop detected : "+lList.detectLoop());
//
//        // Remove the loop
//        System.out.println(lList.removeLoop());
//        System.out.println(lList);
//
//
//        lList.kReverse(3);
//        System.out.println(lList);

        // Reverse linkedlist
        lList.reverseRecur();
        System.out.println(lList);
    }




}
