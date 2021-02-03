package com.lecture.questions.DP1;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String first = "abcd";
        String second = "aamc ";
        int[][] mem = new int[first.length()+1][second.length()+1];
        System.out.println(LCS(first,second));
        System.out.println(LCSDpItr(first,second,mem));
    }

    public static int LCS(String first , String second){
        if(first.length()==0 || second.length()==0){
            return 0;
        }

        char f = first.charAt(0);
        char s = second.charAt(0);

        if(f==s){
            return 1 + LCS(first.substring(1),second.substring(1));
        }
        else{
            return Math.max(LCS(first,second.substring(1)),
                                LCS(first.substring(1),second));
        }
    }


    // LCS by recursive DP
    public static int LCSDPRec(String first , String second, Integer[][] mem){
        if(first.length()==0 || second.length()==0){
            return 0;
        }

        char f = first.charAt(0);
        char s = second.charAt(0);

        if(mem[first.length()][second.length()]!=null){
            return mem[first.length()][second.length()];
        }


        if(f==s){
            mem[first.length()][second.length()] =  1 + LCS(first.substring(1),second.substring(1));
        }
        else{
            mem[first.length()][second.length()]=  Math.max(LCS(first,second.substring(1)),
                    LCS(first.substring(1),second));
        }

        return mem[first.length()][second.length()];
    }


    // LCS by iterative DP
    public static int LCSDpItr(String first , String second , int[][] mem){
        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= second.length() ; j++) {
                if(i==0 || j==0){
                    mem[i][j] = 0;
                }else{
                    if(first.charAt(i-1) == second.charAt(j-1)) {
                        mem[i][j] = 1+ mem[i-1][j-1];
                    }else{
                        mem[i][j] = Math.max(mem[i-1][j],mem[i][j-1]);
                    }
                }

            }
        }

        return mem[first.length()][second.length()];
    }


}
