package com.codingblocks.assignments.recursion;

import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = scn.nextInt();
        System.out.println("Enter the power: ");
        int p = scn.nextInt();

        System.out.println(powerOfNumber(n,p));
    }

    private static int powerOfNumber(int n , int pow) {
        //power can be even or odd
        if(pow==0) return 1;
        if(pow==1) return n;

        int temp = powerOfNumber(n,pow/2);
        if(pow%2 ==0)
            return temp*temp;
        else
            return n*temp*temp;
    }
}
