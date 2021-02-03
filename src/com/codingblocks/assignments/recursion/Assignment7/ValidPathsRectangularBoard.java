package com.codingblocks.assignments.recursion.Assignment7;

import java.util.Scanner;

public class ValidPathsRectangularBoard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        printAllValidPaths("",row,col,0,0);
    }

    private static void printAllValidPaths(String str, int row, int col,int i , int j) {
        if(i == row-1 && j == col-1){
            System.out.println(str);
        }

        if(i>row-1 || j>col-1){
            return;
        }

        printAllValidPaths(str+"H",row,col,i+1,j);
        printAllValidPaths(str+"V",row,col,i,j+1);
        if( i == j || (i+j == row-1))
            printAllValidPaths(str+"D",row,col,i+1,j+1);
    }
}
