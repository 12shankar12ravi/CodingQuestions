package com.lecture.questions.Sept15;

public class SudokuSolver {
    public static void main(String[] args) {
        int board[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        System.out.println("INPUT SUDOKU----------------------->");
        displaySudokuInFormattedManner(board);
        System.out.println();
        System.out.println("OUTPUT SUDOKU---------------------->");
        if(!solveSudoku(board,0,0))
            System.out.println("WRONG SUDOKU , CAN'T SOLVE!");
    }

    private static boolean solveSudoku(int[][] board, int row, int col) {
        // Base case
        if(row==9){
            displaySudokuInFormattedManner(board);
            return true;
        }

        // You have iterated till end of nth row , so go to next row
        if(col==9){
            return solveSudoku(board,row+1,0);
        }

        //Only checking for the empty places where there is zero in the board
        //if no zero then skipping to next column
        if(board[row][col] !=0){
            return solveSudoku(board,row,col+1);
        }else{
            for (int val = 1; val <=9 ; val++) {
                if(isItSafe(board,row,col,val)){
                    board[row][col] = val;
                    boolean result = solveSudoku(board,row,col+1);
                    if(result){
                        return result;
                    }else {
                        board[row][col] = 0; // backtrack and clear last position , check next possible number
                    }
                }
            }
        }

        return false;
    }

    private static boolean isItSafe(int[][] board, int row, int col, int val) {
        //check in the current row
        int c = 0;
        int r = 0;
        while(c<board[0].length){
            if(board[row][c]==val)
                return false;
            c++;
        }

        //check in the current column
        while(r<board.length){
            if(board[r][col]==val)
                return false;
            r++;
        }

        //check in the current grid (3*3)
        int rin = row - row%3;
        int cin = col - col%3;
        for (int i = rin; i <rin+3 ; i++) {
            for (int j = cin; j < cin+3; j++) {
                if(board[i][j] == val)
                    return false;
            }
        }
        return true;
    }

    private static void displaySudokuInFormattedManner(int[][] board) {
        System.out.println("_________________________");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(j%3==0)
                    System.out.print("| "+board[i][j]+" ");
                else if(j==board[0].length-1)
                    System.out.print(board[i][j]+" |");
                else
                    System.out.print(board[i][j]+" ");
            }
            if((i+1)%3==0) {
                System.out.println();
                System.out.println("_________________________");
            }else{
                System.out.println();
            }
        }
    }
}
