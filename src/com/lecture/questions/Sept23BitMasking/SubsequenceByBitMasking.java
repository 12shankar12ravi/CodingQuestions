package com.lecture.questions.Sept23BitMasking;

import java.util.Scanner;

public class SubsequenceByBitMasking {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter the string to find all subsequences:");
        String str = scn.next();
        String res = "";
        findSubsequences(str,res);
        // 000,001,010,011,100,101,110,111
        //findSubsequencesOptimized(str,res);
    }

    // time complexity - (2^n) * b   -> b = no of set bits
    private static void findSubsequencesOptimized(String str, String res) {
        int t=0;
        int mask = 0;
        for (int i = 1; i < (1<<str.length())  ; i++) {
            mask = i;
            res="";
            while(mask>0) {
                t = (mask ^ (mask-1)) & mask;
                res += str.charAt((int)(Math.log(t)/Math.log(2)));
                mask= ~t & mask;
            }
            System.out.println(res);
        }
    }

    // time complexity - (2^n) * l   -> l = length of binary string
    private static void findSubsequences(String str, String res) {
        int t=0;
        int i1 = 0;
        for (int i = 1; i < (1<<str.length()) ; i++) {
            i1 = i;
            t=str.length()-1;
            res="";
            while(t>=0) {
                if((i1 & 1) ==1)
                    res = str.charAt(t) + res;
                i1=i1>>1;
                t--;
            }
            System.out.println(res);
        }
    }

}
