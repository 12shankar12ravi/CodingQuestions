package com.lecture.questions.Sept23Monu;

import java.util.Scanner;

public class SievePrime {
    public static void main(String[] args) {
        //Optimal solution to find all prime numbers less than N , time complexity will be N log(log N)
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[] trackArr = new boolean[n];
        findAllPrimes(n,trackArr);
    }

    private static void findAllPrimes(int n,boolean[] trackArr) {
        //track arr will array all all integers represted by its indexs and value will be true if it is not prime , false , if it is
        //prime , initially we suppose all are primes
        trackArr[0] =trackArr[1] = true;
        for (int i = 2; i*i < n ; i++) {
            for (int mul = i; mul*i < n ; mul++) {
                trackArr[mul*i] = true;
            }
        }
        printPrimes(trackArr);
    }

    private static void printPrimes(boolean[] trackArr) {
        for (int i = 0; i < trackArr.length; i++) {
            if(!trackArr[i])
                System.out.println(i);
        }
    }


}
