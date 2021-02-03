package com.lecture.questions.Oct17Heaps;


import java.util.ArrayList;

/**
 * Heap is data structure which is used to get maximum element or min minimum
 * element by getting top element.
 *
 * There are two types of heap data structures
 *   1. Max Heap : It has max element on top
 *   2. Min Heap : It has min element on top
 *
 * There are two types of heap operation
 *   1. Downheap -> Used in case of deletion -> we delete first element and swap last element in 1st position and
 *   then check the first element with its child until we get correct position
 *   2. Upheap -> Used in case of insertion -> we insert our element in the last index then check its value with
 *   the parent node , do swapping if it is smaller than parent node value (Case of Min heap)
 */
public class Heap {

    private ArrayList<Integer> list;

    Heap(){
        this.list = new ArrayList<>();
    }

    public void insert(int value){
        list.add(value);
        upheap(list.size()-1);
    }

    public int delete(){
        int temp = list.get(0);
        if(list.size() == 1){
            return list.remove(list.size()-1);
        }
        list.set(0,list.remove(list.size()-1));
        downheap(0);
        return temp;
    }

    private void downheap(int index){
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int min = index;

        if(leftChild< list.size() && list.get(leftChild) < list.get(min)){
            min = leftChild;
        }

        if(rightChild< list.size() && list.get(rightChild) < list.get(min)){
            min = rightChild;
        }

        if(min!=index){
            swap(min,index);
            downheap(min);
        }

    }

    private void upheap(int index) {
        if(index == 0)
            return;

        int parent =  parent(index);

        if(list.get(parent) > list.get(index)) {
            swap(parent, index);
            upheap(parent);
        }
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index*2 + 1;
    }

    private int rightChild(int index){
        return index*2 + 2;
    }

    private void swap(int first , int second){
        int temp = (int)list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    private void swap(ArrayList<Integer> list , int first , int second){
        int temp = (int)list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    public void display(){
        System.out.println(list);
    }


    /**
     *  Heap sort on the given array
     */
    public void heapSort(ArrayList<Integer> list){
        //create the max heap by calling heapify method for half of the arr
        int n = list.size();
        for (int i = n/2; i >= 0; i--) {
            heapify(list,n,i);
        }


        for (int i = n-1; i > 0 ; i--) {
            // Move current node to end
            swap(list,0,i);

            // call max heapify on the reduced heap
            heapify(list,i,0);
        }

    }


    private void heapify(ArrayList<Integer> list,int n, int index){
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int max = index;

        if(leftChild< n && list.get(leftChild) > list.get(max)){
            max = leftChild;
        }

        if(rightChild< n && list.get(rightChild) > list.get(max)){
            max = rightChild;
        }

        if(max!=index){
            swap(list,max,index);
            heapify(list,n,max);
        }

    }

}
