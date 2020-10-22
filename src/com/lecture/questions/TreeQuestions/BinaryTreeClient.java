package com.lecture.questions.Oct11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryTreeClient {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("input"));
        BinaryTree tree = new BinaryTree();
        tree.insert(scn);
        tree.insert(scn);
        tree.insert(scn);
        tree.insert(scn);
        tree.insert(scn);
        tree.insert(scn);

        System.out.println(tree.height());
        System.out.println(tree.diameter());
        tree.display("preorder");
        tree.display("inorder");
        tree.display("postorder");
        tree.display("levelOrder");
    }
}
