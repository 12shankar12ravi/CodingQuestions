package com.codingblocks.assignments.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class InverseOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] invArr = new int[n];
        findInverseArray(arr,0,invArr);
        System.out.println(Arrays.toString(invArr));
    }

    private static void findInverseArray(int[] arr, int i, int[] invArr) {
        if(i==arr.length)
            return;
        invArr[arr[i]] = i;
        findInverseArray(arr,i+1,invArr);
    }
}
