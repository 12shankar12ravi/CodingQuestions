package com.lecture.questions.Oct11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTreeClient {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("input"));
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(scn.nextInt());
        bst.insert(scn.nextInt());
        bst.insert(scn.nextInt());
        bst.insert(scn.nextInt());
        bst.insert(scn.nextInt());
        bst.insert(scn.nextInt());
        bst.insert(scn.nextInt());

        //bst.display("inorder");

        //System.out.println(bst.successor(13));

        //bst.elementsInRange(5,40);

        //int[] inorder = {1,3,4,5,6,7,8};

        //bst.inorderTree(inorder);

        //bst.display("preorder");

        //int[] preorder = {5,3,1,4,7,6,8};

//        bst.createPreOrderTree(inorder,preorder);
//
//        bst.display("preorder");

        //int[] postorder = {1,4,3,6,8,7,5};

//        bst.createPostOrderTree(inorder,postorder);
//
//        bst.display("postorder");


        System.out.println(bst.isBalanced());

    }
}
