package com.codingblocks.assignments.recursion;

public class OddEvenSequence {
    public static void main(String[] args) {
        //Take as input N, a number. Print odd numbers in decreasing sequence (up until 0) and
        // even numbers in increasing sequence (up until N). E.g. for N = 6 print 5, 3, 1, 2, 4.
        int n = 7;
        if(n%2==0)
           printOddIncEvenDecSequence(n-1);
        else
            printOddIncEvenDecSequence(n);
    }

    private static void printOddIncEvenDecSequence(int n) {
        if(n<1)
            return ;

        if(n%2 !=0)
          System.out.println(n);
        printOddIncEvenDecSequence(n-1);

        if(n%2 == 0)
            System.out.println(n);
    }
}
