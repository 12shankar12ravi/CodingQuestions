package com.codingblocks.assignments.recursion;

import java.util.Scanner;
import java.util.TreeSet;

public class NumberFollowingPattern {

    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            String pattern = scn.next();
            TreeSet<String> set = new TreeSet<>();
            for (int i = 1; i <=9 ; i++) {
                printMinimum(""+i,pattern,i,set);
            }
            System.out.println(set.first());
        }
    }

    public static void printMinimum(String processed , String pattern , int i ,TreeSet<String> set){
        if(pattern.length()==0){
            set.add(processed);
            return;
        }

        if(i<1 || i>9) {
            return ;
        }


        if(pattern.charAt(0) == 'I'){
            while(i<9){
                printMinimum(processed+(i+1),pattern.substring(1),i+1,set);
                i++;
            }
        }
        else if(pattern.charAt(0) == 'D'){
            while (i>1){
                printMinimum(processed+(i-1),pattern.substring(1),i-1,set);
                i--;
            }
        }

    }
}
