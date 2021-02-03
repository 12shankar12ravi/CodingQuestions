package com.codingblocks.assignments.recursion.Assignment7;

import java.util.HashMap;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printAllParenthesis(n-1,n,"(");
    }

    private static void printAllParenthesis(int op, int cl, String str) {
        if(op <=  0 && cl<=0){
            System.out.println(str);
            return;
        }

        if (cl > 0 && op!=cl)
            printAllParenthesis(op, cl - 1, str + ")");
        if (op > 0)
            printAllParenthesis(op - 1, cl, str + "(");
    }
}
