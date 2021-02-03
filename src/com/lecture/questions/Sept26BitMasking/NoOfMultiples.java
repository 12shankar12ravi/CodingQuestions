package com.lecture.questions.Sept26BitMasking;

import com.lecture.questions.Sept23BitMasking.BitMaskingQuestions;

import java.util.Scanner;

public class NoOfMultiples {
    public static void main(String[] args) {
        // We need to find the number of multiples for 2 , 3 and 5 , common multiples should be removed
        // A U B U C = A+ B + C - A ^ B - A ^ C - B^C + A ^ B ^ C
        // Here even terms are substracted and odd terms are added .
        // A = no of multiples of 2 in 1 to 100 , B = no of multiples of 3 in 1 to 1000,
        // C = no of multiples of 5 in 1 to 1000
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = scn.nextInt();
        }
        int limit = scn.nextInt();
        System.out.println(findNumberOfMultiples(arr,n,limit));
    }

    private static int findNumberOfMultiples(int[] arr, int n,int limit) {
        // 2, 3 , 5
        int res = 0;
        int divisor = 0;
        for(int i = 1 ; i<(1<<arr.length); i++){
            // Even means substraction
            divisor = getDivisor(i,arr);
            if(BitMaskingQuestions.countNoOfSetBit(i)%2==0){
                res -= limit/divisor;
            }
            else{
                 res+= limit/divisor;
            }
        }
        return  res;
    }

    private static int getDivisor(int i , int[] arr){
        int res = 1;
        int pos = 0;
        while(i>0){
            if((i&1) == 1){
                res *= arr[pos];
            }
            i=i>>1;
            pos++;
        }
        return res;
    }



}
