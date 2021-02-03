package com.lecture.questions.Sept23BitMasking;

import java.util.Scanner;

public class UniqueNumberPart3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = scn.nextInt();
        }
        findUniqueNumberRepeated3Times(arr,n);
    }

    private static void findUniqueNumberRepeated3Times(int[] arr, int n) {
        // 1 1 1 2 2 2 3

    }
}
