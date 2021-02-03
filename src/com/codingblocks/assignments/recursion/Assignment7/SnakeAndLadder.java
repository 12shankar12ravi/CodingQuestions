package com.codingblocks.assignments.recursion.Assignment7;

import java.util.ArrayList;
import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //Size of board
        int n = scn.nextInt();
        //System.out.println(countAllPossiblePaths(n,0));
        ArrayList<String> list = new ArrayList<>();
        System.out.println(opReturnAllPossiblePaths("",n,0,list));
    }

    private static int countAllPossiblePaths(int n,int sum) {
        if(sum == n){
            return 1;
        }else if(sum > n){
            return 0;
        }

        int count =0;
        for (int i = 1; i <=6; i++) {
            count+= countAllPossiblePaths(n,sum+i);
        }

        return count;
    }

    private static ArrayList<String> returnAllPossiblePaths(String str , int n, int sum) {
        if(sum == n){
            ArrayList<String> list1 = new ArrayList<>();
            list1.add(str);
            return list1;
        }else if(sum > n){
            return new ArrayList<String>();
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <=6; i++) {
            list.addAll(returnAllPossiblePaths(str+i,n,sum+i));
        }

        return list;
    }

    private static ArrayList<String> opReturnAllPossiblePaths(String str , int n, int sum,ArrayList<String> list) {
        if(sum == n){
            list.add(str);
            return list;
        }else if(sum > n){
            return list;
        }

        for (int i = 1; i <=6; i++) {
            list=opReturnAllPossiblePaths(str+i,n,sum+i,list);
        }

        return list;
    }
}
