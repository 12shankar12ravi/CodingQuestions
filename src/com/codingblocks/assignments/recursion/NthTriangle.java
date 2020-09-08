package com.codingblocks.assignments.recursion;

import java.util.Scanner;

public class NthTriangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N  = scn.nextInt();
        System.out.println(getNthTriangle(N));
    }

    private static int getNthTriangle(int n) {
        if(n==1)
            return 1;
        return n+getNthTriangle(n-1);
    }
}
