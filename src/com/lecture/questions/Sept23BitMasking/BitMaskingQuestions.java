package com.lecture.questions.Sept23Monu;

import java.util.Scanner;

//Class revision
public class BitMaskingQuestions {
    public static void main(String[] args) {
        // 1. Given a number find ith bit of the number from right
        Scanner scn = new Scanner(System.in);
        /*int n= scn.nextInt();
        int i = scn.nextInt();
        findIthBit(n,i);*/

        // 2. We have given an array that has elements repeated twice & one element is unique , so find the unique element
        /*int n1 = scn.nextInt();
        int[] arr = new int[n1];
        for (int j = 0; j <arr.length ; j++) {
            arr[j] = scn.nextInt();
        }
        System.out.println(findUniqueElementFromArray(n1,arr));*/

        // 3. Count no of set bits in  a number (34 = "100010")
        /*int n2 = scn.nextInt();
        System.out.println(countNoOfSetBit(n2));*/

        // 4. Get number from first set bit from right for example 34 = 10010
        // o/p = number formed by taking first set bit from right = 10
        int n3 = scn.nextInt();
        System.out.println(getIthBitNumber(n3));

    }

    private static int getIthBitNumber(int n) {
        //method 1 : (n ^ n-1) & n
        return  (n^(n-1)) & n;
    }

    public static int countNoOfSetBit(int n) {
        int count =0;
        while(n>0){
            count++;
            n= n&n-1;
        }
        return count;
    }

    private static int findUniqueElementFromArray(int n1, int[] arr) {
        int ans = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

    private static void findIthBit(int n, int i) {
        int mask = 1<<(i-1);
        if((mask & n) ==0)
            System.out.println(0);
        else
            System.out.println(1);
    }
}
