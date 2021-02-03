package com.lecture.questions.Sept23BitMasking;

import java.util.Scanner;

public class LuckyNumber {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int count = getIndexOfLuckyNumber(str);
        System.out.println(count+1);
    }

    public static int getIndexOfLuckyNumber(String str){
        int n = str.length();
        int sum  = 2 * ((int)(Math.pow(2,n-1))-1);
        int i = n-1;
        while(i>0){
            if(str.charAt(i)=='7')
                sum+= (int)Math.pow(2,n-i-1);
            i--;
        }
        return sum;
    }
}
