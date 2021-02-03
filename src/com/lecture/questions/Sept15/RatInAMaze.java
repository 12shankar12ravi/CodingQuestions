package com.lecture.questions.Sept15;

import java.util.Scanner;

public class RatInAMaze {
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
        if(arr[n-1][m-1]==-1 || !isPossibleToPathForRat(arr,0,0,n-1,m-1)){
            System.out.println("NO PATH FOUND");
        }
    }

    public static boolean isPossibleToPathForRat(int[][] arr , int i ,int j,int n,int m){
        if(i==n && j==m ){
            display(arr);
            return true;
        }

        boolean left=false,right=false,top=false,bottom=false;

        if(j<n){
            if(isItSafe(arr,i,j)) {
                arr[i][j] = 1;
                right = isPossibleToPathForRat(arr, i, j + 1, n, m);
            }
            arr[i][j] = 0;
        }
        if(i<m){
            if(isItSafe(arr,i,j)) {
                arr[i][j] = 1;
                bottom = isPossibleToPathForRat(arr, i + 1, j, n, m);
            }
            arr[i][j] = 0;
        }
        if(i>0){
            if(isItSafe(arr,i,j)) {
                arr[i][j] = 1;
                top = isPossibleToPathForRat(arr, i - 1, j, n, m);
            }
            arr[i][j] = 0;
        }

        if(j>0){
            arr[i][j] = 1;
            if(isItSafe(arr,i,j))
                left = isPossibleToPathForRat(arr,i,j-1,n,m);
            arr[i][j] = 0;
        }


        if(top||bottom||left||right){
            return true;
        }

        return false;
    }

    public static boolean isItSafe(int[][] arr , int i,int j){
        if(arr[i][j]==0)
            return true;
        return false;
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
