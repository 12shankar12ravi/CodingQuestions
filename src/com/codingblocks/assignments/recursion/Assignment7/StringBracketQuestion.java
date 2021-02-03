package com.codingblocks.assignments.recursion.Assignment7;

import java.util.Scanner;

/*
The string contains a single pair of parenthesis “(..)”.
Write a recursive function which returns the contents between the parenthesis.
E.g. for “xyz(abc)def” return “abc”. Print the value returned
 */
public class StringBracketQuestion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        //getStringBetweenParenthesis("",str,false);

        //check expression => [a + {b +(c + d) + e} + f]
        System.out.println(checkIfExpressionBalanced(str,0,0));
    }

    // xyz(abc)def
    private static void getStringBetweenParenthesis(String processed, String unprocessed,boolean flag) {
        if(unprocessed.length() == 0 || unprocessed.charAt(0) == ')'){
            System.out.println(processed);
            return;
        }

        if(unprocessed.charAt(0)=='(') {
            flag = true;
            unprocessed = unprocessed.substring(1);
        }

        if (flag) {
            processed += unprocessed.charAt(0);
        }
        getStringBetweenParenthesis(processed,unprocessed.substring(1),flag);
    }

    /**
     * [a + {b +(c + d) + e} + f]
     * @param str
     * @return
     */
    public static boolean checkIfExpressionBalanced(String str,int left,int right){
        if(str.length()==0) {
            return left == right;
        }

        if(str.charAt(0)=='[' || str.charAt(0)=='{' || str.charAt(0) == '('){
            left++;
        }else if(str.charAt(0)==']' || str.charAt(0)=='}' || str.charAt(0) == ')'){
            right++;
        }

        return checkIfExpressionBalanced(str.substring(1),left,right);

    }

}
