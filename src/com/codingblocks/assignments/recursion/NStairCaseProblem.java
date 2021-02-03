package com.codingblocks.assignments.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class NStairCaseProblem {
    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] dp = new long[n+1];
        // steps to reach the top can be 1 or 2
        long curTime = System.currentTimeMillis();
        System.out.println(possibleWayToClimbStairCase(n,dp));
        long finTime = System.currentTimeMillis();
        System.out.println(finTime-curTime);
        System.out.println(Arrays.toString(dp));
    }

    private static long possibleWayToClimbStairCase(int n,long[] dp) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(dp[n]==0) {
            dp[n] += possibleWayToClimbStairCase(n - 1, dp) + possibleWayToClimbStairCase(n - 2, dp);
        }
        return dp[n];
    }

    private static int possibleWayToClimbStairCaseWithoutDp(int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        return possibleWayToClimbStairCaseWithoutDp(n-1)+possibleWayToClimbStairCaseWithoutDp(n-2);
    }
}

