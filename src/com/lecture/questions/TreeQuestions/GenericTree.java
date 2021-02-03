package com.lecture.questions.TreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {

    private Node root;

    public void insert(Scanner scn){
        System.out.println("Please enter the root node");
        this.root = new Node(scn.nextInt());
        insert(scn,root);
    }

    private void insert(Scanner scn, Node node){
        while(true){
            System.out.println("Do you want add the child of "+node.value);
            boolean yes = scn.nextBoolean();
            if(yes){
                System.out.println("Enter the value");
                int val = scn.nextInt();
                Node child = new Node(val);
                node.children.add(child);
                insert(scn,child);
            }else{
                break;
            }
        }
    }

    class Node{
        int value;
        ArrayList<Node> children;
        public Node(int value){
            this.value = value;
            children = new ArrayList<Node>();
        }

        @Override
        public String toString(){
            return value+"";
        }
    }

    public void displayPreorder(){
        displayPreorder(root,"");
    }

    public void displayLevelOrder(){
        levelTraversal(root);
    }

    public void displayInorder(){
        displayInorder(root);
    }

    public void displayPostOrder(){
        displayPostOrder(root);
    }

    // preorder traversal
    private void displayPreorder(Node node,String intent){
        System.out.println(intent+node.value);
        for(int i=0;i<node.children.size();i++){
            displayPreorder(node.children.get(i),intent+"\t");
        }
    }

    // level traversal (by using stack)
    private void levelTraversal(Node root){
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value+" ");
            for (int i= 0; i <node.children.size() ; i++) {
                queue.offer(node.children.get(i));
            }
        }
    }

    // inorder
    private void displayInorder(Node node){
        for (int i = 0; i < node.children.size()-1; i++) {
            displayInorder(node.children.get(i));
        }
        System.out.print(node.value+" ");
        if(node.children.size()>0)
            displayInorder(node.children.get(node.children.size()-1));
    }

    // postorder
    private void displayPostOrder(Node node){
        for (int i = 0; i < node.children.size(); i++) {
            displayPostOrder(node.children.get(i));
        }
        System.out.print(node.value+" ");
    }

    // print  level by index
    public void printLevel(int index){
        printLevel(root,index);
    }

    private void printLevel(Node node, int index) {
        if(index==0){
            System.out.print(node.value+" ");
            return;
        }

        for (int i = 0; i < node.children.size(); i++) {
            printLevel(node.children.get(i),index-1);
        }
    }


}

