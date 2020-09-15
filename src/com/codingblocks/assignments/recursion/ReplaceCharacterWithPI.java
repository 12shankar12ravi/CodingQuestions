package com.codingblocks.assignments.recursion;

import java.util.Scanner;

public class ReplaceCharacterWithPI {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
            String str = scn.next();
            replacePiValue("",str);
            t--;
        }
    }

    public static void replacePiValue(String process , String unprocess){
        if(unprocess.length()==0) {
            System.out.println(process);
            return;
        }

        if(unprocess.charAt(0)=='p' && unprocess.charAt(1)=='i')
            replacePiValue(process+"3.14",unprocess.substring(2));
        else
            replacePiValue(process+unprocess.charAt(0),unprocess.substring(1));

    }
}
