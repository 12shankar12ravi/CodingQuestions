package com.lecture.questions.Oct19Hashmap;

import java.util.HashMap;

public class MapLLClient {

    public static void main(String[] args) {

//        Integer key = 12000000;
//        //System.out.println(x >>> 16);
//        System.out.println(hash(key));
        HashMapLL<String , Integer> hashMapLL = new HashMapLL<>();
        hashMapLL.put("ravi",12);
        hashMapLL.put("shankar",15);
        hashMapLL.put("bhatt",20);
        hashMapLL.put("bhatt",90);
        hashMapLL.put(null,90);
        hashMapLL.put(null,340);
        hashMapLL.put("aba",1000);
        hashMapLL.put("baa",1000);

        HashMap map = new HashMap();
        map.put("ravi","bhatt");

        System.out.println(hashMapLL);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
