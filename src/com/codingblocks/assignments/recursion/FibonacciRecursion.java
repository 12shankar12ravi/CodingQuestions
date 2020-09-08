package com.codingblocks.assignments.recursion;

public class FibonacciRecursion {
    public static void main(String[] args) {
        /** What is fibonacci series?
         *  0 , 1 , 1 , 2 , 3 , 5 , 8 , 13...
         *  first and second element are 0 and 1
         *  and third el = second + first = (n-1)+(n-2)
         */
         int n = 5;
         int output = nthfibonacci(n);
        System.out.println(output);
    }

    private static int nthfibonacci(int n) {
        if(n<2) return n;

        return nthfibonacci(n-1)+nthfibonacci(n-2);
    }
}
