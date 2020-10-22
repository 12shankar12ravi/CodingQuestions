package com.lecture.questions.Oct11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeClient {
    /*
    generic input
     10
true
30
true
40
false
true
50
false
false
true
70
true
78
false
true
56
false
false
false
     */

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner scn = new Scanner(file);
        GenericTree tree = new GenericTree();
        tree.insert(scn);
        //tree.displayPreorder();
        tree.displayLevelOrder();
        System.out.println();
        tree.displayInorder();
        System.out.println();
        tree.displayPostOrder();
        System.out.println();
        tree.printLevel(0);
    }
}
