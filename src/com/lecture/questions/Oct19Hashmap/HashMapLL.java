package com.lecture.questions.Oct19Hashmap;
import java.util.LinkedList;

/**
 * This is the very basic implementation hashmap by using linkedlist , time complexity of insert is O(n)
 *   1. HashCode method is not used here
 *   2. No collision detection mechanism here.
 * K is key of the hashmap and V is the value
 * @param <K>
 * @param <V>
 */
public class HashMapLL<K,V> {

    private LinkedList<Entity<K,V>> list = new LinkedList<>();

    public void put(K key , V value){

        for (Entity<K,V> entity: list) {
            if((key==null && entity.key == null) || entity.key!=null && entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        list.add(new Entity<>(key,value));
    }

    public V get(K key){
        for (Entity<K,V> Entity: list) {
            if(Entity.key.equals(key)){
                return Entity.value;
            }
        }
        return null;
    }

    public V remove(K key){
        Entity<K,V> target = null;
        for (Entity<K,V> entity: list) {
            if(entity.key.equals(key)){
                target = entity;
            }
        }

        V temp = target.value;
        list.remove(target);

        return temp;
    }

    @Override
    public String toString(){
        StringBuilder st = new StringBuilder("{");
        for (Entity<K,V> entity: list) {
            st.append(entity.key).append("=>").append(entity.value).append(" ");
        }
        st.append("}");

        return st.toString();
    }


    class Entity<K,V>{
        K key;
        V value;
        Entity(K key , V value){
            this.key = key;
            this.value = value;
        }
    }
}
