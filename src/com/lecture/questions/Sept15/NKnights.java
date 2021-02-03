package com.lecture.questions.Sept15;

import java.util.Scanner;

/*
Place N knights in N*N chess borad so that no knight kills each other
Backtracking question->
We will take a boolean array to persist the state of the board , if we place a queen
in say (i,j) position we make arr[i][j] = true and make a recursive call by incrementing row to place the next
queen on next row and check if it is safe to place the queen at (i,j)

if we are unable to place it on i,j then we increment the col until board.length , then return to previous
recursive call and make board[i][j] = false to check the next possibility..............
 */
public class NKnights {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        boolean[][] board = new boolean[N][N];
        int count = placeNKnights(board,N,0,0,"");
        System.out.println();
        System.out.println(count);
    }

    /**
     *
     * @param board
     * @param n
     * @param row
     */
    private static int placeNKnights(boolean[][] board, int n, int row,int col,String ans) {
        //Base case
        if(n == 0){
            System.out.print(ans+" ");
            return 1;
        }

        if(col==board[0].length){
            return placeNKnights(board,n,row+1,0,ans);
        }

        if(row==board.length)
            return 0;

        int count = 0;
        if(IsItSafe(board,row,col)){
            board[row][col] = true;
            //placed one queen , go to next row
             count += placeNKnights(board,n-1,row,col+1,ans+"{"+row+"-"+col+"} ");
            //Can't place the queen at row,col , before checking next possiblity to place queen
            //remove the current queen from board[row],[col]
            board[row][col] = false;
        }
        count+= placeNKnights(board,n,row,col+1,ans);
        return count;
    }

    private static void disPlayBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board.length ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    /**
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private static boolean IsItSafe(boolean[][] board, int row, int col) {
        if(row-1>=0){
            if(col-2>=0) {
                if (board[row - 1][col - 2])
                    return false;
            } else if(col+2<board.length) {
                if (board[row - 1][col + 2])
                    return false;
            }
        }

        if(row-2>=0){
            if(col-1>=0) {
                if (board[row - 2][col - 1])
                    return false;
            } else if(col+1<board[0].length) {
                if (board[row - 2][col + 1])
                    return false;
            }
        }

        return true;

    }
}
