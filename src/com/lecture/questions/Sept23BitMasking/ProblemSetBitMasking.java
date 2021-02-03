package com.lecture.questions.Sept23BitMasking;

import java.util.Scanner;

public class ProblemSetBitMasking {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int l = scn.nextInt();
        int r = scn.nextInt();
        int x = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(printProblemSets(l,r,x,arr));
    }

    private static int printProblemSets( int l, int r, int x, int[] arr) {
        int pos=0;
        int i1 = 0;
        int min = 0;
        int max = 0;
        int count = 0;
        int sum =0;
        for (int i = 3; i < (1<<arr.length) ; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            if(BitMaskingQuestions.countNoOfSetBit(i)>=2)
            {
                i1 = i;
                pos = arr.length - 1;
                sum = 0;
                while (i1 > 0) {
                    if ((i1 & 1) == 1) {
                        sum += arr[pos];
                        min = Math.min(min, arr[pos]);
                        max = Math.max(max, arr[pos]);
                    }
                    i1 = i1 >> 1;
                    pos--;
                }
                if ((max - min) >= x && sum >= l && sum <= r) {
                    count++;
                }
            }
        }
        return count;
    }


}
