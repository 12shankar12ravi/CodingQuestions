package com.lecture.questions.Oct11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private Node root;
    
    class Node{
        int value;
        Node left;
        Node right;
        int height;
        Node(int value){
            this.value = value;
            this.height=  1;
        }
    }

    public void insert(int value) {
        this.root = insert(root, value);
    }

    private Node insert(Node node, int value) {

        if (node == null) {
            return new Node(value);
        }
        
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void display(String order) {
        switch (order){
            case "inorder":
                displayInOrder(root,"");
                break;
            case "preorder":
                displayPreOrder(root,"");
                break;
            case "postorder":
                displayPostOrder(root,"");
                break;
            default:
                displayLevelOrder(root,"");
        }
        System.out.println();
    }

    /**
     * level order (print by levels)
     * @param node
     * @param s
     */
    private void displayLevelOrder(Node node, String s) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.value+s);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            s = s+"\t";
        }

    }

    /**
     * post order (left , right , root)
     * @param node
     * @param s
     */
    private void displayPostOrder(Node node, String s) {
        if(node == null)
            return ;

        displayPostOrder(node.left, s+"\t");
        displayPostOrder(node.right, s+"\t");
        System.out.println(s+node.value);
    }

    /**
     * pre order (root , left , right)
     * @param node
     * @param s
     */
    private void displayPreOrder(Node node, String s) {
        if(node == null)
            return ;

        System.out.println(s+node.value);
        displayPreOrder(node.left, s+"\t");
        displayPreOrder(node.right, s+"\t");
    }

    /**
     * In order (left , root , right)
     * @param node
     * @param s
     */
    private void displayInOrder(Node node, String s) {
        if(node == null)
            return ;

        displayInOrder(node.left, s+"\t");
        System.out.println(s+node.value);
        displayInOrder(node.right, s+"\t");
    }


    // successor logic need to be written
    /**
     *
     */
     public int getSuccessor(Node node){
         if(node.right!=null){
             return checkInRightSubTree(node.right);
         }else{

         }

         return -1;
     }

    private int checkInRightSubTree(Node node) {
         if(node.left==null)
             return node.value;

         return checkInRightSubTree(node.left);
    }


    /**
     * Find the successor of the node , next node value that is greater than given
     *  For example :
     *  inorder : [1,2,3,4,5,6,7] , successor of 5 will be 6
     * @param value
     * @return
     */
    public int successor(int value){
         Node succ = null;
         Node curr = root;
         while(curr!=null){
             if(value<curr.value){
                 succ = curr;
                 curr = curr.left;
             }else{
                 curr = curr.right;
             }
         }
        if (succ != null) {
            return succ.value;
        }
        return  -1;
    }


    /**
     *
     * print nodes in a range k1 to k2  , k1 and
     *  k2 should be exclusive
     * @param k1 (low)
     * @param k2 (high)
     */
    public void elementsInRange(int k1 , int k2){
        printInRange(root,k1,k2);
    }

    private void printInRange(Node node, int k1, int k2) {
        if(node==null)
            return;

        if(node.value>k1 && node.value<k2){
            System.out.println(node.value);
        }

        if(node.value>k1){
            printInRange(node.left, k1,k2);
        }

        if(node.value<k2){
            printInRange(node.right,k1,k2);
        }
    }


    /**
     *  Given an sorted array , create a tree which should not be skewed
     */
     public void inorderTree(int[] arr){
         this.root = inorderTree(root,arr,0,arr.length-1);
     }

    private Node inorderTree(Node node , int[] arr, int l, int h) {
         if(l>h){
             return node;
         }

         int mid = (l+h)/2;
         node = new Node(arr[mid]);
         node.left = inorderTree(node.left,arr,l,mid-1);
         node.right = inorderTree(node.right,arr,mid+1,h);

         return node;
    }


    /**
     *  Given a preorder and inorder array of a tree , please construct a tree in preorder
     *  inorder : [1,2,3,4,5,6]
     *  preorder: [4,2,1,3,5,6]
     *  root will be preorder[0] , lets find root in inorder array -> index is 3
     *  Now we know that there are three element to the left of 4 and 2 element to the right
     *  inorder_left = [1,2,3]
     *  inorder_right = [5,6]
     *    using the index , we find out from 1 to 3 index left elements and 4 to 6 right elements in
     *    preorder array
     *  preorder_left = [2,1,3]
     *  preorder_right = [5,6]
     *    Do the recursion call for preorder_left and inorder_left and find the next left element
     *    Do the recursion call of  preorder_right and inorder_right and find the next right element
     *
     *    ....so on
     *
     *            4
     *         2    5
     *       1   3    6
     *
     */
     public void createPreOrderTree(int[] inorder , int[] preorder){
           this.root = createPreOrderTree(root,inorder,preorder);
     }

    private Node createPreOrderTree(Node node, int[] inorder, int[] preorder) {
         if(inorder.length==0){
             return null;
         }

         node = new Node(preorder[0]);
         int index = findIndex(inorder,preorder[0]);
         int[] inorder_left = Arrays.copyOfRange(inorder,0,index);
         int[] inorder_right = Arrays.copyOfRange(inorder,index+1,inorder.length);
         int[] preorder_left = Arrays.copyOfRange(preorder,1,index+1);
         int[] preorder_right = Arrays.copyOfRange(preorder,index+1,preorder.length);

         node.left = createPreOrderTree(node.left,inorder_left,preorder_left);
         node.right = createPreOrderTree(node.right,inorder_right,preorder_right);

         return node;
    }

    public void createPostOrderTree(int[] inorder , int[] postorder){
         this.root = createPostOrderTree(root,inorder,postorder);
    }

    // Same logic as the createPreOrderTree
    private Node createPostOrderTree(Node node, int[] inorder, int[] postorder) {
         if(inorder.length == 0 ){
             return null;
         }

        node = new Node(postorder[postorder.length-1]);
        int index = findIndex(inorder,postorder[postorder.length-1]);
        int[] inorder_left = Arrays.copyOfRange(inorder,0,index);
        int[] inorder_right = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] postorder_left = Arrays.copyOfRange(postorder,0,postorder.length-index-1);
        int[] postorder_right = Arrays.copyOfRange(postorder,postorder.length-index-1,postorder.length-1);

        node.left = createPostOrderTree(node.left,inorder_left,postorder_left);
        node.right = createPostOrderTree(node.right,inorder_right,postorder_right);

        return node;

    }

    //

    private int findIndex(int[] arr,int value){
         int l = 0 , h = arr.length-1;
         int mid = 0;
         while(l<=h){
             mid = (l+h)/2;
             if(arr[mid] == value){
                 return mid;
             }else if(arr[mid] < value){
                 l = mid+1;
             }else{
                 h = mid-1;
             }
         }
         return  -1;
    }

    //height
    public int height() {
        return height(root);
    }

    /**
     *
     * @param node
     * @return
     */
    private int height(Node node) {

        if (node == null) {
            return 0;
        }
        return node.height;
    }


    public boolean isBalanced (){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if(node==null){
            return true;
        }

        int leftHeight = 0;
        int rightHeight = 0;
        if(node.left!=null)
          leftHeight = node.left.height ;
        if(node.right!=null)
          rightHeight = node.right.height;

        int diff = Math.abs(leftHeight - rightHeight);
        if(diff>1){
            return false;
        }else{
            return isBalanced(node.left) && isBalanced(node.right);
        }
    }

}
