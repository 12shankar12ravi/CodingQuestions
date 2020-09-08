package com.codingblocks.assignments.recursion;

import java.util.Scanner;

public class PalindromeByRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.next().charAt(0);
        }
        System.out.println(checkPalindrome(arr,0,n-1));
    }

    private static boolean checkPalindrome(char[] arr , int l , int h) {
        if(l>h)
            return true;

        if(arr[l]!=arr[h])
            return false;

        return checkPalindrome(arr,l+1,h-1);
    }
}
