package com.lecture.questions.Sept15;

import java.util.Scanner;

public class RatInAMaze2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            String str = scn.next();
            for(int j=0;j<m;j++){
                if(str.charAt(j) == 'X')
                    arr[i][j] = -1;
                else
                    arr[i][j] = 0;
            }
        }
        if(arr[n-1][m-1]==-1 || !isPossibleToPathForRat(arr,0,0)){
            System.out.println("-1");
        }
    }

    public static boolean isPossibleToPathForRat(int[][] arr , int i ,int j){
        if(i==arr.length-1 && j==arr[0].length-1){
            display(arr);
            return true;
        }

        boolean res = false;
        if(j<arr[0].length-1)
        {
            if(isItSafe(arr,i,j)){
                arr[i][j] = 1;
                res = isPossibleToPathForRat(arr,i,j+1);
                if(res)
                    return true;
                else
                    arr[i][j] = 0;
            }
        }
        if(i<arr.length-1){
            if(isItSafe(arr,i,j)){
                arr[i][j] = 1;
                res = isPossibleToPathForRat(arr,i+1,j);
                if(res)
                    return true;
                else
                    arr[i][j] = 0;
            }
        }

        if(i>0){
            if(isItSafe(arr,i,j)){
                arr[i][j] = 1;
                res = isPossibleToPathForRat(arr,i-1,j);
                if(res)
                    return true;
                else
                    arr[i][j] = 0;
            }
        }

        if(j>0){
            if(isItSafe(arr,i,j)){
                arr[i][j] = 1;
                res = isPossibleToPathForRat(arr,i,j-1);
                if(res)
                    return true;
                else
                    arr[i][j] = 0;
            }
        }

        return false;
    }

    public static boolean isItSafe(int[][] arr ,int i,int j){
        if(arr[i][j]==-1 || arr[i][j]==1)
            return false;
        return true;
    }

    public static void display(int[][] arr){
        arr[arr.length-1][arr[0].length-1] = 1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==-1)
                    System.out.print("0 ");
                else
                    System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
