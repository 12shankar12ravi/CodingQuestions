package com.lecture.questions.DP1;

public class fibonicai {

    public static void main(String[] args) {

//        // Without DP
        int n = 35;
        int[] mem = new int[n+1];
        long startTime = System.nanoTime();
        System.out.println(fibonicaiDP(n,mem));
        System.out.println("Time taken to execute fibonicai for "+n+" without dp : "+(System.nanoTime() - startTime)/1000000 +" ms");

    }


    public static int fibonicai(int n){
        if(n<2){
            return n;
        }

        return fibonicai(n-1) + fibonicai(n-2);
    }

    public static int fibonicaiDP(int n,int[] mem){
        if(n<2){
            return n;
        }

        if(mem[n]!=0){
            return mem[n];
        }

        mem[n] =  fibonicai(n-1) + fibonicai(n-2);

        return mem[n];
    }

    public static int fibonicaiItr(int n , int[] mem){
        mem[0] = 0;
        mem[1] = 1;

        for (int i = 2; i <= n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }

        return mem[n];
    }

}
