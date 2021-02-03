package com.codingblocks.assignments.recursion.Assignment7;

import java.util.Scanner;

public class KeyPadCodes {

    public static final String[] keypad = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(printAllWordsFromKeypad("",str));
    }

    private static int printAllWordsFromKeypad(String processed,String unprocessed) {
        if(unprocessed.length() == 0) {
            System.out.println(processed);
            return 1;
        }

        int count = 0;
        String str = keypad[unprocessed.charAt(0) - 49];
        for (int i = 0; i <str.length() ; i++) {
            count+= printAllWordsFromKeypad(processed+str.charAt(i),unprocessed.substring(1));
        }
        return count;
    }
}
