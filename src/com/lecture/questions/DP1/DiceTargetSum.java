package com.lecture.questions.DP1;

import java.util.Scanner;

public class DiceTargetSum {

    public static void main(String[] args) {
        // Given a sum (target) we need to calculate the no of possibilities to getting this sum by throwing dice any
        // number of times
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the target : ");
        int target = scn.nextInt();
        System.out.println(diceTargetSum(target));

        int[] mem = new int[target+1];
        System.out.println(diceTargetSumRecrDP(target,mem));

        mem = new int[target+1];
        System.out.println(diceTargetSumItrDP(target,mem));

    }

    public static int diceTargetSum(int target){
        if(target == 0)
            return 1;

        int cnt = 0;
        for (int i = 1; i <=6 && i<=target ; i++) {
            cnt+= diceTargetSum(target-i);
        }

        return cnt;
    }

    public static int diceTargetSumRecrDP(int target,int[] mem){
        if(target == 0)
            return 1;

        if(mem[target]!=0){
            return mem[target];
        }

        for (int i = 1; i <=6 && i<=target ; i++) {
            mem[target]+= diceTargetSumRecrDP(target-i,mem);
        }

        return mem[target];
    }

    public static int diceTargetSumItrDP(int target , int[] mem){
        // Store the base cases into memory
        mem[0] = 1;
        mem[1] = 1;

        for (int i = 2; i <= target; i++) {
            for (int j = 1; j <=6 && j<=i ; j++) {
                mem[i] += mem[i-j];
            }
        }

        return mem[target];
    }


}
