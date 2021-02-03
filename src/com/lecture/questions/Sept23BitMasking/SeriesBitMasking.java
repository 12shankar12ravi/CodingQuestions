package com.lecture.questions.Sept23BitMasking;

public class SeriesBitMasking {
    //164065588
    public static void main(String[] args) {
        int n = 10001;
        int sum=0;
        int mul = 5;
        while(n>0){
            sum+= (n&1)*mul;
            mul *= 5;
            n=n>>1;
        }
        System.out.println(sum);
    }
}
