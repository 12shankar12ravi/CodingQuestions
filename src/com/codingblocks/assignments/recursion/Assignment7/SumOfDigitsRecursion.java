package com.codingblocks.assignments.recursion.Assignment7;


import java.util.Scanner;

public class SumOfDigitsRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Take number as string and get sum of digits.
        // 12345
        String str = scn.next();
        System.out.println(getSumOfDigits(str,0,0));
    }

    private static int getSumOfDigits(String str,int sum,int i) {
        if(i==str.length())
            return sum;
        //'1' = 49-48
        sum+= (int)(str.charAt(i)-48);
        return getSumOfDigits(str,sum,i+1);
    }
}
