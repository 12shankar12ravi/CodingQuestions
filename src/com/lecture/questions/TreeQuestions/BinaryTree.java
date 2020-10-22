package com.lecture.questions.Oct11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /*
    5
left
7
right
10
left
left
12
left
right
20
right
right
100
     */
    public void insert(Scanner scn) {
        this.root = insert(root, scn);
    }

    private Node insert(Node node, Scanner scn) {

        if (node == null) {
            System.out.println("enter the value");
            int value = scn.nextInt();
            return new Node(value);
        }

        System.out.println("Enter the direction");
        String dir = scn.next();

        if (dir.equals("left")) {
            node.left = insert(node.left, scn);
        } else {
            node.right = insert(node.right, scn);
        }

        return node;
    }

    public void display(String order) {
        System.out.print("[");
        switch (order){
            case "inorder":
                displayInOrder(root);
                break;
            case "preorder":
                displayPreOrder(root);
                break;
            case "postorder":
                displayPostOrder(root);
                break;
            default:
                displayLevelOrder(root);
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * level order (print by levels)
     * @param node
     */
    private void displayLevelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.value+",");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }

    }

    /**
     * post order (left , right , root)
     * @param node
     */
    private void displayPostOrder(Node node) {
        if(node == null)
            return ;

        displayPostOrder(node.left);
        displayPostOrder(node.right);
        System.out.print(node.value+",");
    }

    /**
     * pre order (root , left , right)
     * @param node
     */
    private void displayPreOrder(Node node) {
        if(node == null)
            return ;

        System.out.print(node.value+",");
        displayPreOrder(node.left);
        displayPreOrder(node.right);
    }

    /**
     * In order (left , root , right)
     * @param node
     */
    private void displayInOrder(Node node) {
        if(node == null)
            return ;

        displayInOrder(node.left);
        System.out.print(node.value+",");
        displayInOrder(node.right);
    }


    //height
    public int height() {
        return height(root);
    }

    /**
     * By using the root node we are traversing to left and right and increasing height in every traversal
     * Once we reach to leaf node by recursion max(height(left) = 0 ,height(right) = 0) + 1  = 1 (height)
     * In the same way we check the left height and right height whichever is maximum return it.
     *
     * @param node
     * @return
     */
    private int height(Node node) {

        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int diameter() {
        return diameter(root);
    }

    /**
     * find diameter of the tree (it means longest stretch from one leaf node to another leaf node)
     * for example for the tree given below -> longest stretch will be fro 12 to 46 = 6
     * 10
     * 12      20
     * 11   34   45   46
     * 12
     * <p>
     * Here we will use the height function already created above.
     *
     * @param node
     */
    private int diameter(Node node) {
        // Base case
        if (node == null)
            return 0;

        //total diameter of current node
        int curr = 1 + height(node.left) + height(node.right);

        return Math.max(Math.max(diameter(node.left), diameter(node.right)), curr);

    }




}
