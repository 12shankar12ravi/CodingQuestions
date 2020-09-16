package com.lecture.questions.Sept14;

/*
Place r queens in a 1D board of N length , all possibilities
Case 1 : {q1b0,q2b1} , q1b1,q2b0}  permutations (all possible arrangements)
Case 2 : {q1b0,q2b1} combinations (all possible combinations)
 */
public class QueenPermutationsAndCombinations {
    public static void main(String[] args) {
        int nq = 2;
        int n = 4;
        boolean[] board = new boolean[n];
        queenCombinations(nq,0,board,"",-1);

        //queenPermutations(nq,0,board,"");

    }

    private static void queenPermutations(int nq,int qp, boolean[] board, String result) {
        if(qp==nq){
            System.out.println(result);
            return;
        }

        for (int i = 0; i <board.length ; i++) {
            if(!board[i]) {
                board[i] = true;
                queenPermutations(nq, qp + 1, board, result + "q" + qp + "b" + i);
                board[i] = false;
            }
        }
    }



    private static void queenCombinations(int nq, int qp, boolean[] board, String result,int index) {
        if(qp==nq){
            System.out.println(result);
            return;
        }

        for (int i = index+1; i <board.length ; i++) {
            if(!board[i]) {
                board[i] = true;
                queenCombinations(nq, qp + 1, board, result + "q" + qp + "b" + i,i);
                board[i] = false;
            }
        }
    }


}


