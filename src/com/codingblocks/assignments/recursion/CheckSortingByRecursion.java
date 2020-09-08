package com.codingblocks.assignments.recursion;

import java.util.Scanner;

public class CheckSortingByRecursion {
    /*
     Take as input N, the size of array. Take N more inputs and store that in an array. Write a recursive function which returns true
     if the array is sorted and false otherwise. Print the value returned.
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N  = scn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(checkSorting(arr,N,1));
    }

    private static boolean checkSorting(int[] arr, int n,int i) {
        if(i==n)
            return true;

        if(arr[i]<arr[i-1])
            return false;
        return checkSorting(arr,n,i+1);
    }


}
