package com.codingblocks.assignments.recursion;

import java.util.Scanner;

public class RightMostIndexSearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int left = findLeftMostIndex(arr,m,0,n-1);
        int right = findRightMostIndex(arr,m,0,n-1);
        for (int i = left; i <= right ; i++) {
            if(i!=right)
              System.out.print(i+",");
            else
                System.out.print(i);
        }
    }

    private static int findLeftMostIndex(int[] arr, int m, int l, int h) {
        //Base case
        if(l>h)
            return -1;
        int mid = l+(h-l)/2;
        if(arr[mid]==m && (mid==0 || arr[mid-1] != m))
            return mid;
        else if (m<=arr[mid])
            return findLeftMostIndex(arr,m,0,mid-1);
        else
            return findLeftMostIndex(arr,m,mid+1,h);
    }

    private static int findRightMostIndex(int[] arr, int m, int l, int h) {
        //Base case
        if(l>h)
            return -1;
        int mid = l+(h-l)/2;
        if(arr[mid]==m && (mid==arr.length-1 || arr[mid+1] != m))
            return mid;
        else if (m>=arr[mid])
            return findRightMostIndex(arr,m,mid+1,h);
        else
            return findRightMostIndex(arr,m,0,mid-1);
    }
}
