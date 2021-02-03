package com.codingblocks.assignments.recursion.Assignment7;

public class StringToInteger {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(parseInt(str,0,0));
    }

    private static int parseInt(String str,int num,int i) {
        if(str.length()==i)
            return num;
        num += (str.charAt(str.length()-i-1)-48)*Math.pow(10,i);
        return parseInt(str,num,i+1);
    }
}
