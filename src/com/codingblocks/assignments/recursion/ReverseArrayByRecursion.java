package com.codingblocks.assignments.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayByRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        reverseArray(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr , int l , int h) {
        if(l>h)
            return;
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
        reverseArray(arr,l+1,h-1);
    }
}
