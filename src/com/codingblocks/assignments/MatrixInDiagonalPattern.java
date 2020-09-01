package com.codingblocks.assignments;

import java.util.ArrayList;

public class MatrixInDiagonalPattern {

    public static void main(String[] args) {
       int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrixDiagonally(arr);

    }

    public static void printMatrixDiagonally(int[][] arr){
        for(int sum=0;sum<=2*(arr.length-1);sum++){
            for(int j=0;j<arr.length;j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    if (j + k == sum)
                        System.out.print(arr[k][j]+" ");
                }
            }
            System.out.println();
        }
    }



}
