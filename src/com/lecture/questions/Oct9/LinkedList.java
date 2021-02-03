package com.lecture.questions.Oct9;


import java.util.Stack;

public class LinkedList<E> {

    private Node head ;
    private Node tail;

    class Node<E>{
        Node<E> next;
        E value;
        Node(E value){
            this.value = value;
        }
    }

    public void insertAtFirst(E value){
        Node<E> temp = new Node<>(value);
        temp.next = head;
        head = temp;

        if(tail==null){
            tail = temp;
        }
    }

    public void insertAtLast(E value){
        if(tail==null){
            insertAtFirst(value);
            return;
        }

        Node<E> temp = new Node<>(value);
        tail.next = temp;
        tail = temp;
    }

    // 1 2 3 4 5 6
    // 2
    public void createLoop(E loopEl ){
        Node<E> temp = head;
        while (temp!=null){
            if(temp.value == loopEl) {
                tail.next = temp;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Loop not possible, as element is not present in linked list");
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node temp = head;
        while(temp!=tail){
            builder.append(temp.value+"->");
            temp = temp.next;
        }
        builder.append(temp.value+"->");
        //if loop exist then print tail.next in next line
        if(temp.next!=null)
            builder.append("\n-----------"+temp.next.value);
        else
            builder.append("End");
        return builder.toString();
    }

    //
    public Node detectLoop() {
        // slow and fast pointer concept
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                return slow;
        }
        return null;
    }

    // Remove the loop from the linked list
    public String removeLoop(){
        Node detNode = detectLoop();
        System.out.println("Removing loop");
        if(detNode!=null){
            Node ptr = head;
            while(true){
                if(detNode == ptr) {
                    break;
                }
                ptr = ptr.next;
                detNode = detNode.next;
            }
            while(ptr.next !=detNode){
               ptr = ptr.next;
            }
            ptr.next = null;
            tail = ptr;
            return "Loop is removed";
        }else{
            return "Loop not exist";
        }
    }


    // K reverse linkedlist
    /*  reverse in bunch of k=3
     *  1-2-3-4-5-6-end
     *  3-2-1-6-5-4-end
     *  save in stack
     */

    public void kReverse(int k){
        Stack stack = new Stack();
        Node<E> temp = head;
        int i = 0 ;
        Node<E> prev = null;
        while(temp!=null) {
            i=0;
            while (temp!=null && i < k ) {
                stack.push(temp);
                temp = temp.next;
                i++;
            }

            if(prev==null){
                prev = (LinkedList.Node)stack.pop();
                head = prev;
            }

            while(!stack.isEmpty()){
                prev.next = (LinkedList.Node)stack.pop();
                prev = prev.next;
            }

        }

        prev.next = null;
        tail = prev;
    }



    // reverse linkedlist (normal method)
    public void reverse(){
        // 1 2 3 4 5 end
        // p c n  ,
        Node<E> p = null;
        Node<E> c = head;
        Node<E> n = null;
        tail = c;

        while(c!=null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        head = p;

        //System.out.println("Current = "+c.value);
        System.out.println("Tail = "+tail.value);
    }


    // reverse by recursion
    /**
     *        1 ->  2 ->  3 ->  4 ->  5 ->  null
     *
     */

    public void reverseRecur(){
        reverse(head);
    }


    private void reverse(Node node){

        if(node==tail) {
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;

        node.next = null;

        tail = node;
    }


    // find intersection of two linkedlists


    // delete one node from linkedlist


    // palindrome


    // insertAtIndex


    // delete first


    //delete last


    // get node by index


    //

}
