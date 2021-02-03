package com.lecture.questions.Sept23BitMasking;

public class TOH {
    public static void main(String[] args) {
        TOH(3,"A","B","C");
    }

    public static void TOH(int n, String src, String dis, String hel) {
        if (n == 0) {
            return;
        }
        TOH(n - 1, src, hel, dis);
        System.out.println("Move " + n + "th " + "disk from " + src + " to " + dis);
        TOH(n - 1, hel, dis, src);

    }
}
