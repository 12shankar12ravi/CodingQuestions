package com.lecture.questions.DP1;

public class LongestPalindrome {

    // We have to find the longest palindromic string from the given string
    public static void main(String[] args) {

        //"abbacddeeddc";
        String str = "acadda";

        // lets compare a and c not equal
        // start+1 and end-1 => b and d not equal
        Integer[][] mem = new Integer[str.length()][str.length()];
        System.out.println(LPS(str,0,str.length()-1));
        //System.out.println(LPSDp(str,0,str.length()-1,mem));
        System.out.println(LPSDpItr(str,0,str.length()-1,mem));
    }

    private static int LPS(String str,int start,int end) {
        if(start==end){
            return 1;
        }

        if(start>end){
            return 0;
        }

        if(str.charAt(start) == str.charAt(end)){
            return 2 + LPS(str,start+1,end-1);
        }else{
            return Math.max(LPS(str,start+1,end),LPS(str,start,end-1));
        }

    }

    private static int LPSDp(String str,int start,int end,Integer[][] mem) {
        if(start==end){
            return 1;
        }

        if(start>end){
            return 0;
        }

        if(mem[start][end] != null){
            return mem[start][end];
        }

        if(str.charAt(start) == str.charAt(end)){
            mem[start][end] = 2 + LPS(str,start+1,end-1);
        }else{
            mem[start][end] = Math.max(LPS(str,start+1,end),LPS(str,start,end-1));
        }

        return mem[start][end];
    }


    // iterative approach to longest palindrome (DP)
    private static int LPSDpItr(String str,int st,int ed,Integer[][] mem) {
        int start=0,end =0;
        for(int i=0 ; i<str.length() ; i++){
            for (int j = 0; j < str.length() - i; j++) {
                start = j;
                end = j+i;
                if(start==end){
                    mem[start][end] = 1;
                }
                else if(str.charAt(start) == str.charAt(end)) {
                    if(start+1 <= end-1)
                        mem[start][end] = 2 + mem[start+1][end-1];
                    else
                        mem[start][end] = 2;
                }
                else{
                    mem[start][end] = Math.max(mem[start+1][end] , mem[start][end-1]);
                }
            }
        }

        return mem[st][ed];
    }
}
