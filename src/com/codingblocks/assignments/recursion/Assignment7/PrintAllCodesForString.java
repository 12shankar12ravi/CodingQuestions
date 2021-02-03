package com.codingblocks.assignments.recursion.Assignment7;

public class PrintAllCodesForString {
    public static void main(String[] args) {
        // 1123 -> aabc , kbc , alc , aaw , kw
        //
        String str = "1123";
        getAllCodes("",str);

    }

    private static void getAllCodes(String processed, String unprocessed) {
        if(unprocessed.length() == 0) {
            System.out.println(processed);
            return;
        }

        getAllCodes(processed+(char)(unprocessed.charAt(0)+48),unprocessed.substring(1));
        if(unprocessed.length() > 1 && Integer.parseInt(unprocessed.substring(0,2))<=26)
           getAllCodes(processed+(char)(Integer.parseInt(unprocessed.substring(0,2))+96),unprocessed.substring(2));
    }
}
