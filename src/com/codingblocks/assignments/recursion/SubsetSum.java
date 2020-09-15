package com.codingblocks.assignments.recursion;

import java.util.Scanner;

public class SubsetSum {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            System.out.println(checkIfSubsetSumZero(arr,0,0));
        }
    }

    public static boolean checkIfSubsetSumZero(int[] arr , int sum , int i){
        if(i==arr.length){
            if(sum == 0){
                return true;
            }else{
                return false;
            }
        }
        boolean include = checkIfSubsetSumZero(arr,sum+arr[i],i+1);
        boolean exclude = (i==arr.length-1 && sum==0) ? false : checkIfSubsetSumZero(arr,sum,i+1);
        return include || exclude;
    }
}
