package com.faang.questions;

import java.util.Scanner;

public class BitonicSubsequences {
    public static void main (String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++ ) {
                arr[i] = scn.nextInt();
            }
            System.out.println(bitonicSubsequenceLength(arr,n));
        }
    }

    static int bitonicSubsequenceLength(int[] input , int n){
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        int curr = 1;

        // we are going to find the values of left array
        for (int i=1; i<n ;i++) {
            curr = 1;
            for (int j=0;j<i ;j++) {
                if(input[j]<input[i]){
                    curr = Math.max((left[j]+1) , curr);
                }
            }
            left[i] = curr;
        }

        // we are going to find the values of right array
        for(int i=n-2;i>=0;i--){
            curr = 1;
            for (int j=i+1;j<n;j++) {
                if(input[j]<input[i]){
                    curr = Math.max((right[j]+1) , curr);
                }
            }
            right[i] = curr;
        }

        // Now, we are going to find the longest bitonic subsequence: Max(left[i]+right[i] -1,curr)
        curr = 1;
        for (int i=0;i<n;i++) {
            curr = Math.max(left[i]+right[i]-1,curr);
        }

        return curr;
    }
}
