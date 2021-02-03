package com.codingblocks.assignments.recursion.Assignment7;

import java.util.Scanner;
import java.util.TreeSet;

public class LexiographicalNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        TreeSet<String> set = new TreeSet<>();
        printInLexiograpicalOrder(num,set);
    }

    private static void printInLexiograpicalOrder(int num, TreeSet<String> set) {
        if(num==0){
            System.out.println(set);
            return;
        }

        set.add(num+"");
        printInLexiograpicalOrder(num-1,set);
    }

    // 123

}
