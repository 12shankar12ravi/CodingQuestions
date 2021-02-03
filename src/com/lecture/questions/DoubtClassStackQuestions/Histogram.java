package com.lecture.questions.DoubtClassStackQuestions;

import java.util.Scanner;
import java.util.Stack;

public class Histogram {
    public static void main(String[] args) {
        //Doing by using divide and conquer (n*log(n) approach)
        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i <length ; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(findMaximumArea(arr,0,length-1));

    }

    // By using the stack , find maximum area
    public static int findMaximumAreaByStack(int[] arr){
        Stack<Integer> stack = new Stack<>();
        // 1 , 2 , 3 , 4 , 5
        int area = Integer.MIN_VALUE;
        int top =0;
        int i=0;
        for (; i < arr.length; i++) {
            if(stack.isEmpty() || arr[stack.peek()]<=arr[i]) {
                stack.push(i);
            }
            else {
                top = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    area = Math.max(area, arr[top] * i);
                } else {
                    area = Math.max(arr[top] * (i - top - 1), area);
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty())
        {
            top = stack.peek();
            stack.pop();
            if (stack.isEmpty()) {
                area = Math.max(area, arr[top] * i);
            } else {
                area = Math.max(arr[top] * (i - top - 1), area);
            }
        }

        return area;
    }

    public static int findMaximumArea(int[] arr,int st, int end) {
        if(st>end)
            return 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = st; i <=end ; i++) {
            if(arr[i]<=min){
                min = arr[i];
                minIndex = i;
            }
        }
        int area = min * (end-st+1);
        int leftArea = findMaximumArea(arr,st,minIndex-1);
        int rightArea = findMaximumArea(arr,minIndex+1,end);
        return Math.max(area, Math.max(leftArea,rightArea));
    }

    private static int minElement(int st ,int end ,int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = st; i <=end ; i++) {
            min = Math.min(min,arr[i]);
        }
        return min;
    }
}
