package com.codingblocks.assignments.recursion;

public class PrintDecreasing {
    public static void main(String[] args) {
        int n = 5;
        printd(n);
        printdI(n);
    }

    private static void printdI(int n) {
        //Base case
        if(n==0){
            return;
        }
        System.out.println(n);
        printdI(n-1);
        System.out.println(n);
    }

    public  static void printd(int n){
        //Base case
        if(n==0){
            return;
        }
        System.out.println(n);
        printd(n-1);
    }

}
