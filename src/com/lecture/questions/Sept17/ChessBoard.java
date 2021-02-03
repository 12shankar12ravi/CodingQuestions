package com.lecture.questions.Sept17;

import java.util.Scanner;

public class ChessBoard {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int res = chessBoardPossiblePaths("", 0, 0, n);
        System.out.println();
        System.out.println(res);
    }

    public static int chessBoardPossiblePaths(String processed, int row, int col, int n) {
        if (row == n - 1 && col == n - 1) {
            System.out.print(processed + "{" + row + "-" + col + "} ");
            return 1;
        }

        if (row >= n || col >= n) {
            return 0;
        }

        int count = 0;
        // check for knights
        // Increase row and column by (+1 , +2 ) or (+2,+1)
        count += chessBoardPossiblePaths(processed + "{" + row + "-" + col + "}" + "K", row + 2, col + 1, n);
        count += chessBoardPossiblePaths(processed + "{" + row + "-" + col + "}" + "K", row + 1, col + 2, n);

        // Check for rook movement
        if (row == 0 || col == 0 || row == n - 1 || col == n - 1) {
            for (int i = 1; i < n; i++) {
                if (col < n)
                    count += chessBoardPossiblePaths(processed + "{" + row + "-" + col + "}" + "R", row, col + i, n);
                else
                    break;
            }
            for (int i = 1; i < n; i++) {
                if (row < n)
                    count += chessBoardPossiblePaths(processed + "{" + row + "-" + col + "}" + "R", row + i, col, n);
                else
                    break;
            }

        }

        // Bishop move
        if (row == col || (row + col) == n - 1) {
            for (int i = 1; i < n; i++) {
                count += chessBoardPossiblePaths(processed + "{" + row + "-" + col + "}" + "B", row + i, col + i, n);
            }

        }

        return count;

    }
}
