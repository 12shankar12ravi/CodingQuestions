package com.lecture.questions.Sept23BitMasking;

import java.util.Scanner;

/* 2 3 4 5
 Two players Modi and trump plays a game of picking coins , they pick coins alternatively, Any person can pick the first or last
 coin and removes it then next player picks from the remaining
 First move is of Modi . We want modi to win the game . But both players plays optimally
 4 3 8 5
 5 -> Min((4,3),(3,8)) -> (4, 8) -> 4
 4 -> Min((3,8),(8,5)) -> (8,8) -> 8 -> Modi Wins
 First player will seek for max value and second will take a value such that next player gets min value.
 */
public class OptimalGameStrategy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(optimalGameStrategy(arr,0,arr.length-1));
    }

    private static int optimalGameStrategy(int[] arr,int i,int j) {
        //base case (2 members will remain)
        // 2 3 4 5
        if(i==j-1)
            return Math.max(arr[i],arr[j]);

        int a1 = arr[i]+Math.min(optimalGameStrategy(arr,i+2,j),optimalGameStrategy(arr,i+1,j-1));
        int b1 = arr[j]+Math.min(optimalGameStrategy(arr,i,j-2),optimalGameStrategy(arr,i+1,j-1));
        return Math.max(a1,b1);
    }
}
