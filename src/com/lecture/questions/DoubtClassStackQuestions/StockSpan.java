package com.lecture.questions.DoubtClassStackQuestions;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String args[]) throws Exception {
        // Your Code Here
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        int[] prices=new int[N];
        for(int i=0;i<N;i++){
            prices[i]=s.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans=StockSpanUsingStacks(prices, stack);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println("END");

    }

    public static int[] StockSpanUsingStacks(int[] arr, Stack<Integer> stack) throws Exception {
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty())
                ans[i] = i+1;
            else
                ans[i] = i-stack.peek();

            stack.push(i);
        }

        return ans;
    }
}
