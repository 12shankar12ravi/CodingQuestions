package com.codingblocks.assignments.recursion.Assignment7;

public class DuplicateCharacterStar {
    public static void main(String[] args) {

        // hello
        String str = "mmm";
        System.out.println(addStarInTheString("",str));

        //move all x to end
        // abaxxcdxxp => abacdpxxxx
        String st = "abaxxcdxxp";
        System.out.println(moveAllXToEnd("","",st));

        // abcpihipi remove all hi's
        String s = "ahibhicpihihipi";
        System.out.println(removeAllHi("",s));


        // count all twins in string (AxAxA)
        String string = "AxAxA";
        System.out.println(countNumberOfTwins(string,0));
    }

    private static int countNumberOfTwins(String s,int count) {
        if(s.length() == 2)
            return count;

        if(s.charAt(0) == s.charAt(2))
            count++;
        return countNumberOfTwins(s.substring(1),count);
    }

    private static String removeAllHi(String processed, String unprocessed) {
        if(unprocessed.length()==1){
            return processed+unprocessed.charAt(0);
        }
        if(unprocessed.length()==0){
            return processed;
        }

        if(unprocessed.charAt(0)=='h' && unprocessed.charAt(1)=='i') {
            unprocessed = unprocessed.substring(2);
            //processed+="bye";
        }else {
            processed += unprocessed.charAt(0);
            unprocessed = unprocessed.substring(1);
        }
        return removeAllHi(processed,unprocessed);
    }

    private static String moveAllXToEnd(String s1,String s2, String st) {
        if(st.length()==0)
            return s1+s2;

        if(st.charAt(0) == 'x')
            s2+= st.charAt(0);
        else
            s1+= st.charAt(0);
        return moveAllXToEnd(s1,s2,st.substring(1));
    }

    // hello
    private static String addStarInTheString(String s, String str) {
        if(str.length()==0)
            return s;

        if(s.length()>0 && s.charAt(s.length()-1) == str.charAt(0))
            s+= "*"+str.charAt(0);
        else
            s+= str.charAt(0);
        return addStarInTheString(s,str.substring(1));
    }
}

