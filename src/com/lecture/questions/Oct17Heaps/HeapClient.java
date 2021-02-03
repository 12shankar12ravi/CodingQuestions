package com.lecture.questions.Oct17Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapClient {

    public static void main(String[] args) {
          Heap heap = new Heap();
//        heap.insert(80);
//        heap.insert(10);
//        heap.insert(30);
//        heap.insert(40);
//        heap.insert(5);
//
//        heap.display();
//
//        System.out.println(heap.delete());
//        System.out.println(heap.delete());
//        System.out.println(heap.delete());
//        System.out.println(heap.delete());
//        System.out.println(heap.delete());
//
//        heap.display();

        Integer[] arr = {5,17,4,1,3,9};
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i: arr) {
            list.add(i);
        }
        heap.heapSort(list);

        System.out.println(list);




    }
}
