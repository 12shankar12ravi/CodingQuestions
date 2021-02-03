package com.codingblocks.assignments.recursion.Assignment7;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        ArrayList<ArrayList<Integer>> listOfSets = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        // 1 , 2 , 3 , 4
        for (int i = 0; i <n ; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        //System.out.println(noOfSubSetsSumToTarget(arr,0,0,target,list,listOfSets));

        //System.out.println(noOfSubSetsSumToTarget(arr,0,0,target));

        noOfSubSetsSumToTarget(arr,0,0,target,list);
    }

    private static ArrayList<ArrayList<Integer>> noOfSubSetsSumToTarget(int[] arr, int sum ,int i , int target ,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> listOfSets ) {
        if(i == arr.length){
            if(sum == target) {
                listOfSets.add(list);
            }
            return listOfSets;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.add(arr[i]);
        listOfSets=noOfSubSetsSumToTarget(arr,sum+arr[i],i+1,target,list1,listOfSets);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        listOfSets=noOfSubSetsSumToTarget(arr,sum,i+1,target,list2,listOfSets);

        return listOfSets;
    }

    private static void noOfSubSetsSumToTarget(int[] arr, int sum ,int i , int target ,ArrayList<Integer> list ) {
        if(i == arr.length){
            if(sum == target) {
                System.out.println(list);
            }
            return;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.add(arr[i]);
        noOfSubSetsSumToTarget(arr,sum+arr[i],i+1,target,list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        noOfSubSetsSumToTarget(arr,sum,i+1,target,list2);

    }


    private static int noOfSubSetsSumToTarget(int[] arr, int sum ,int i , int target) {
        if(i == arr.length){
            if(sum == target) {
                System.out.println(sum);
                return 1;
            }else{
                return 0;
            }
        }

        int count = 0;
        count+=noOfSubSetsSumToTarget(arr,sum+arr[i],i+1,target);
        count+=noOfSubSetsSumToTarget(arr,sum,i+1,target);

        return count;
    }
}
