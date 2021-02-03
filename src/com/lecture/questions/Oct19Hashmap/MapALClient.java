package com.lecture.questions.Oct19Hashmap;

public class MapALClient {
    public static void main(String[] args) {
        HashMapAL<Integer,Integer> hashMapAL = new HashMapAL<>();
        for (int i = 0; i <100 ; i++) {
            hashMapAL.put(i,i*3);
        }
        System.out.println(hashMapAL);
        System.out.println(hashMapAL.size());
        System.out.println(hashMapAL.getCapacity());
    }
}
