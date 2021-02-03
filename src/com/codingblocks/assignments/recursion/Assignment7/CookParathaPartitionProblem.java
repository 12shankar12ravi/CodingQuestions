package com.codingblocks.assignments.recursion.Assignment7;

/*
The coding blocks members went to the success party of their first ever online boot-camp at Murthal.
They ordered P number of paranthas.
The stall has L cooks and each cook has a rank R.
A cook with a rank R can cook 1 parantha in the first R minutes 1 more parantha in the next 2R minutes,
 1 more parantha in 3R minutes and so on(he can only cook a complete parantha) ( For example if a cook is ranked
 2.. he will cook one parantha in 2 minutes one more parantha in the next 4 mins and one more in the next 6 minutes hence in total 12 minutes he cooks 3 paranthas.
 In 13 minutes also he can cook only 3 paranthas as he does not have enough time for the 4th parantha).
 Calculate the minimum time needed to cook all the paranthas.
 */

import java.util.Scanner;

public class CookParathaPartitionProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nop = scn.nextInt();
        int noc = scn.nextInt();
        int[] ranks = new int[noc];
        for (int i = 0; i <noc ; i++) {
            ranks[i] = scn.nextInt();
        }
        System.out.println(getMinimumTimeToCookParatha(ranks,nop,noc));
    }

    private static int getMinimumTimeToCookParatha(int[] ranks, int nop, int noc) {
        int minTime = 0;
        int maxTime = Integer.MIN_VALUE;
        for (int rank : ranks) {
            maxTime = Math.max(rank, maxTime);
        }
        maxTime *= (nop * (nop+1)) /2;
        // binary search to get minimum time to cook paratha
        int mid = 0;
        int result =0;
        while(minTime<maxTime){
            mid = (minTime+maxTime)/2;
            if(canCookParatha(mid,ranks,nop)){
                result = mid;
                maxTime = mid-1;
            }else{
                minTime = mid+1;
            }
        }

        return result;
    }

    // 10
    // 1 2 3 4
    // 20 min
    private static boolean canCookParatha(int time,int[] ranks,int nop){
        int i = 0;
        int count = 0;
        while(i<ranks.length) {
            int sum = 0;
            int j = ranks[i];
            while (sum <= time) {
                sum += j;
                if(sum<=time)
                  count++;
                j = j + ranks[i];
            }
            i++;
            if(count>=nop)
                return true;
        }

        return false;
    }

}
