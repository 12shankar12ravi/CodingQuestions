package com.codingblocks.assignments.recursion;

import java.util.Scanner;


public class BinarySearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        System.out.println(binarySearchByRecursion(arr,m,0,n-1));
    }

    private static boolean binarySearchByRecursion(int[] arr, int m , int l , int h) {
        //Base case
        if(l>h)
            return false;
        int mid = l+(h-l)/2;
        if(arr[mid]==m)
            return true;
        else if (m>arr[mid])
            return binarySearchByRecursion(arr,m,mid+1,h);
        else
            return binarySearchByRecursion(arr,m,0,mid-1);
    }

}
