package com.lecture.questions.DP1;

public class MazePath {

    /*
      (3,3) | (3,2)  | (3,1)
      (2,3) | (2,2) | (2,1)
      (1,3) | (1,2) | (1,1)

      Here we need to go from 3,3 to 1,1 , How many ways are there?
      We can solve this by using simple recursion one call horizontal and
      other vertical but it can be optimized by using dynamic programming 2d.
     */
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
        System.out.println(mazePathRec(15,15));
        System.out.println(System.currentTimeMillis());

        int[][] mem = new int[31][31];
        System.out.println(mazePathRecDP(30,30,mem));
        System.out.println(System.currentTimeMillis());

        mem = new int[31][31];
        System.out.println(mazePathItrDp(30,30,mem));
        System.out.println(System.currentTimeMillis());
    }

    static int mazePathRec(int row , int col){
        if(row==1 || col==1){
            return 1;
        }

        int cnt = 0;

        cnt += mazePathRec(row-1,col) + mazePathRec(row , col-1);

        return cnt;
    }

    /*
      Recursive DP
     */
    static int mazePathRecDP(int row , int col , int[][] mem){
        if(row==1 || col==1){
            return 1;
        }

        if(mem[row][col]!=0){
            return mem[row][col];
        }

        mem[row][col] += mazePathRecDP(row-1,col,mem)+mazePathRecDP(row,col-1,mem);

        return mem[row][col];
    }

    /*
      Iterative DP
     */
    static int mazePathItrDp(int row , int col , int[][] mem){

        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= col; j++) {
                if(i==1 || j==1)
                  mem[i][j] = 1;
                else
                  mem[i][j] = mem[i-1][j] + mem[i][j-1];
            }
        }

        return mem[row][col];

    }

}
