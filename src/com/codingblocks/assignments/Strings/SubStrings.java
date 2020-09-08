package com.codingblocks.assignments.Strings;

/**
 * This class contains substrings assignment questions - solutions
 */
public class SubStrings {

    public static void main(String[] args) {
        String str = "abababcde";
        //printAllSubstrings(str);
        System.out.println((char) ('a'-32));

    }

    static void printAllSubstrings(String str){
        for (int i = 0; i <str.length() ; i++) {
            for(int j=i+1;j<=str.length();j++)
                System.out.println(str.substring(i,j));
        }
    }

    static String toggleCasesInString(String str){
        //aBcDeF
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                res.append((char)(str.charAt(i)+32));
            }
        }

        return res.toString();
    }


}
