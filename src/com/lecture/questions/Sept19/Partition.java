package com.lecture.questions.Sept19;

import java.util.Arrays;
import java.util.Scanner;
import com.common.util.ArrayMethods;

public class Partition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = scn.nextInt();
        }
        int pivotIndex = lomutoPartition(arr,n);
        System.out.println(pivotIndex);
        System.out.println(Arrays.toString(arr));
    }

    private static int lomutoPartition(int[] arr, int n) {
        int p_index = 0;
        int p = arr[n-1];
        int i=0;
        while(i<arr.length-1){
            if(arr[i]<p){
                ArrayMethods.swap(arr,i,p_index);
                p_index++;
            }
            i++;
        }
        ArrayMethods.swap(arr,i,p_index);
        return p_index;
    }
}
