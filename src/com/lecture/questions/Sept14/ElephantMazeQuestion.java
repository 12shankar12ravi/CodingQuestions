package com.lecture.questions.Sept14;

/**
 * N* N chessboard , rook (elephant) starting from (0,0)
 * has to reach (n-1,n-1) , find number of possible ways
  */
public class ElephantMazeQuestion {
    public static void main(String[] args) {
        //
        boolean board[][] = new boolean[4][4    ];
        System.out.println(findPathsForElephant(board,0,0));
    }

    private static int findPathsForElephant(boolean[][] board, int row, int col) {
        if(row == board.length-1 && col == board.length-1)
            return 1;

        int count =0;
        for(int i=1;i<=board.length-1;i++){
            //horizontal move
            if(col+i < board.length) {
                count+=findPathsForElephant(board, row, col + i);
            }else{
                break;
            }
        }

        for(int i=1;i<=board.length-1;i++){
            //vertical move
            if(row+i < board.length) {
                count+=findPathsForElephant(board, row + i, col);
            }else{
                break;
            }
        }
        return count;
    }
}
