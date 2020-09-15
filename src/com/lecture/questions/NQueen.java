package com.lecture.questions;

import java.util.Arrays;

/*
Place N queens in N*N chess borad so that no queen's doesn't kill each other
Backtracking question->
We will take a boolean array to persist the state of the board , if we place a queen
in say (i,j) position we make arr[i][j] = true and make a recursive call by incrementing row to place the next
queen on next row and check if it is safe to place the queen at (i,j)

if we are unable to place it on i,j then we increment the col until board.length , then return to previous
recursive call and make board[i][j] = false to check the next possibility..............
 */
public class NQueen {
    public static void main(String[] args) {
        int N =8;
        boolean[][] board = new boolean[N][N];
        placeNQueens(board,N,0);
    }

    /**
     *
     * @param board
     * @param n
     * @param row
     */
    private static void placeNQueens(boolean[][] board, int n, int row) {
        //Base case
        if(n==0){
            disPlayBoard(board);
            return;
        }

        //Negative test case
        if(row>board.length){
            return;
        }

        // Loop to iterate to same row next column -> go horizontally
        for(int col=0;col<board[0].length;col++){
            if(IsItSafe(board,row,col)){
                board[row][col] = true;
                //placed one queen , go to next row
                placeNQueens(board,n-1,row+1);
                //Can't place the queen at row,col , before checking next possiblity to place queen
                //remove the current queen from board[row],[col]
                board[row][col] = false;
            }
        }
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
        //check in the column
        int r = row-1;
        while(r>=0){
            if(board[r][col])
                return false;
            r--;
        }

        r = row-1;
        int c = col-1;
        //check in the left diagonal
        while (r>=0 && c>=0){
            if(board[r][c])
                return false;
            r--;c--;
        }

        //check in the right diagonal
        r = row-1;
        c = col+1;
        //check in the left diagonal
        while (r>=0 && c<board[0].length){
            if(board[r][c])
                return false;
            r--;c++;
        }
        return  true;
    }
}
