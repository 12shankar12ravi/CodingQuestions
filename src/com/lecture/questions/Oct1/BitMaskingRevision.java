package com.lecture.questions.Oct1;

public class BitMasking {
    public static void main(String[] args) {
        int x = -100;
        //System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(Integer.toBinaryString(2147483647));
        // 2^-31
        System.out.println(1<<31);
        System.out.println((int)Math.pow(2,31));
    }
}
