package com.codingblocks.assignments.recursion.Assignment7;

import java.util.Scanner;

public class TrickyPermutations {
    public static void main(String[] args) {
        // abc -> abc , acb , bca , bac , cab , cba
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        //trickyPermutations("",str);
        dictionaryLarger("",str,str);
    }

    private static void trickyPermutations(String processed , String unprocessed) {
        if(unprocessed.length() == 0) {
            System.out.println(processed);
            return;
        }

        char ch  = unprocessed.charAt(0);
        // "b" -> ba , ab
        // "c" -> cba , bca , bac , cab , cab , abc
        for(int i=0;i<=processed.length();i++){
            String first = processed.substring(0,i);
            String last = processed.substring(i);
            trickyPermutations(first+ch+last,unprocessed.substring(1));
        }

    }

    private static void dictionaryLarger(String processed , String unprocessed,String st) {
        if(unprocessed.length() == 0) {
            if(processed.compareTo(st)>0)
                System.out.println(processed);
            return;
        }

        char ch  = unprocessed.charAt(0);
        // "b" -> ba , ab
        // "c" -> cba , bca , bac , cab , cab , abc
        for(int i=0;i<=processed.length();i++){
            String first = processed.substring(0,i);
            String last = processed.substring(i);
            dictionaryLarger(first+ch+last,unprocessed.substring(1),st);
        }

    }
}
