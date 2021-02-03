package com.lecture.questions.DP1;

public class MinEditDistance {
    public static void main(String[] args) {

        String input =  "dpmggg";
        String output = "dogsg";
        Integer[][] mem = new Integer[input.length()+1][output.length()+1];
        System.out.println(minEditDistance(input,output));
        System.out.println(minEditDistanceDP(input,output,mem));
        System.out.println(minDistanceItr(input,output,mem));
    }

    public static int minEditDistance(String input, String output){
         if(input.length()==0){
             return output.length();
         }

         if(output.length()==0){
             return input.length();
         }

         char in = input.charAt(0);
         char op = output.charAt(0);

         if(in == op){
             return minEditDistance(input.substring(1),output.substring(1));
         }else{
             return 1 + Math.min(minEditDistance(input.substring(1),output),
                                Math.min(minEditDistance(input,output.substring(1)),
                                        minEditDistance(input.substring(1),output.substring(1))));
         }

    }


    public static int minEditDistanceDP(String input, String output,Integer[][] mem){
        if(input.length()==0){
            return output.length();
        }

        if(output.length()==0){
            return input.length();
        }

        if(mem[input.length()][output.length()]!=null){
            return mem[input.length()][output.length()];
        }

        char in = input.charAt(0);
        char op = output.charAt(0);

        if(in == op){
            mem[input.length()][output.length()] =  minEditDistance(input.substring(1),output.substring(1));
        }else{
            mem[input.length()][output.length()] =  1 + Math.min(minEditDistance(input.substring(1),output),
                    Math.min(minEditDistance(input,output.substring(1)),
                            minEditDistance(input.substring(1),output.substring(1))));
        }

        return mem[input.length()][output.length()];
    }

    public static int minDistanceItr(String input , String output, Integer[][] mem){
        for (int i = 0; i <= input.length() ; i++) {
            for (int j = 0; j <= output.length() ; j++) {
                if(i==0){
                    mem[i][j] = j;
                }
                else if(j==0){
                    mem[i][j] = i;
                }
                else{
                     if(input.charAt(i-1)==output.charAt(j-1)){
                         mem[i][j] = mem[i-1][j-1];
                     }else{
                         mem[i][j] = 1+ Math.min(mem[i-1][j],
                                           Math.min(mem[i-1][j-1],mem[i][j-1]));
                     }
                }
            }
        }
        return mem[input.length()][output.length()];
    }


}



