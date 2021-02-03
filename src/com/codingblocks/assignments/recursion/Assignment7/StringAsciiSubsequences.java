package com.codingblocks.assignments.recursion.Assignment7;

import java.util.ArrayList;
import java.util.Scanner;

public class StringAsciiSubsequences {
    public static void main(String[] args) {
        // ab = a,b,96,97
        // '',a, b, ab
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> list = new ArrayList<>();
        printAsciiSubsequences("",str,list);
        System.out.println(list);
    }

    private static void printAsciiSubsequences(String processed, String unprocessed,ArrayList<String> list) {
        if(unprocessed.length() == 0){
            list.add(processed);
            return;
        }
        printAsciiSubsequences(processed+unprocessed.charAt(0),unprocessed.substring(1),list);
        printAsciiSubsequences(processed+(int)unprocessed.charAt(0),unprocessed.substring(1),list);
        printAsciiSubsequences(processed,unprocessed.substring(1),list);

    }
}
