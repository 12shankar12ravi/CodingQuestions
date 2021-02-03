package com.lecture.questions.Oct19Hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapAL<K,V> {

    private ArrayList<LinkedList<Entity>> list ;
    
    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private float loadFactor = 0.5f;

    HashMapAL(){
        list = new ArrayList<>();
        for (int i=0; i< DEFAULT_CAPACITY;i++) {
            list.add(new LinkedList<>());
        }
    }
    
    public void put(K key , V value){
        if(list.size()*loadFactor <= size){
            resize();
        }
        
        int index = key.hashCode() % list.size();

        LinkedList<Entity> lList = list.get(index);

        for (Entity entity : lList) {
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        size++;
        lList.add(new Entity(key,value));
    }

    /**
     * Increase the size of the hashmap to size * loadfactor and rehash the value
     * as the size changes then the position of elements also changes
     */
    private void resize() {
        ArrayList<LinkedList<Entity>> oldList = list;
        list = new ArrayList<>();
        for (int i = 0; i <2*oldList.size() ; i++) {
            list.add(new LinkedList<>());
        }
        size = 0;
        for (LinkedList<Entity> ll: oldList) {
            for (Entity entity: ll) {
                put(entity.key,entity.value);
            }
        }
    }

    public V get(K key){
        int index = key.hashCode() % list.size();

        LinkedList<Entity> lList = list.get(index);

        for (Entity entity : lList) {
            if(entity.key.equals(key)){
                return entity.value;
            }
        }

        return null;
    }


    class Entity{
        K key;
        V value;
        public Entity(K key , V value){
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return size;
    }

    /*
     Return current capacity
     */
    public int getCapacity(){
        return list.size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (LinkedList<Entity> ll : list) {
            for (Entity entity: ll) {
                sb.append(entity.key+"=>"+entity.value+"\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
