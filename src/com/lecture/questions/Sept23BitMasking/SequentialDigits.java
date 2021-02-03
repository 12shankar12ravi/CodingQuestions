package com.lecture.questions.Sept23BitMasking;

import java.util.Scanner;

public class SequentialDigits {
    public static void main(String[] args) {
        //100 to 4000
        // "123456789"
        //  3 to 4
        String str = "123456789";
        Scanner scn = new Scanner(System.in);
        String min = scn.next();
        String max = scn.next();

        int maxNum = Integer.parseInt(max);
        int minNum = Integer.parseInt(min);
        for (int i = min.length(); i <= max.length(); i++) {
            for(int j=0;j<=str.length()-i;j++){
                if(minNum<Integer.parseInt(str.substring(j,j+i)) && Integer.parseInt(str.substring(j,j+i))< maxNum)
                    System.out.println(str.substring(j,j+i));
            }
        }
    }
}
