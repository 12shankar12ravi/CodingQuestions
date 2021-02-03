package com.codingblocks.assignments.recursion;

import java.util.Arrays;
import java.util.Scanner;
import com.common.util.ArrayMethods;

public class BubbleSortRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N  = scn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }
        bubbleSort(arr,1,N-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr , int j , int i) {
        if(i==0)
            return;
        if(arr[j-1]>arr[j])
            ArrayMethods.swap(arr,j,j-1);
        if(j==i)
            bubbleSort(arr,1,i-1);
        else
            bubbleSort(arr,j+1,i);
    }


}
