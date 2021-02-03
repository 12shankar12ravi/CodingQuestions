package com.codingblocks.assignments.recursion.Assignment7;

import java.util.Scanner;

public class StringQuestion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        if(str.charAt(0)!='a')
            System.out.println(false);
        else
            System.out.println(checkAllRulesForString(str,0));

    }

    private static boolean checkAllRulesForString(String str,int i) {
        if (i==str.length()){
            return true;
        }

        // aabbcccd
        // each'a'is followed by nothing or an 'a' or "bb"
        if(str.charAt(i)=='a' && (i==str.length()-1 || str.charAt(i+1) == 'a' || (i+2<=str.length()-1 && str.substring(i+1,i+3).equals("bb")))){
            return checkAllRulesForString(str,i+1);
        }else if(i<=str.length()-2 && str.substring(i,i+2).equals("bb") && (i+2>str.length()-1  || str.charAt(i+2) == 'a')){
            return checkAllRulesForString(str,i+2);
        }

        return false;
    }
}
