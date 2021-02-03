package com.lecture.questions.Oct19Hashmap;

import java.util.HashMap;

/**
 *  This is the second level implementation of the HashMap By using array
 *    1. HashCode method is used to find the index .
 *    2. In case of collsion (Two objects hashcode same and index also comes same , we lose the previous value as we
 *    overide the entry in this case) . Collision case is not handled here.
 */
public class HashMapArray<K,V> {

    Entity[] entities = new Entity[10];

    public void put(K key,V value){
        int index = Math.abs(key.hashCode() % entities.length);

        entities[index] = new Entity<K,V>(key,value);
    }

    public V get(K key){
        int index = key.hashCode() % entities.length;
        if(entities[index]!=null && entities[index].key.equals(key)){
            return (V)entities[index].value;
        }
        return null;
    }


    public V remove(K key){
        int index = key.hashCode() % entities.length;
        V temp = null;
        if(entities[index]!=null && entities[index].key.equals(key)){
            temp = (V)entities[index].value;
            entities[index] = null;
        }

        return temp;
    }


    class Entity<K,V>{
        K key;
        V value;
        public Entity(K key , V value){
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Entity entity : entities) {
            if(entity!=null)
                sb.append(entity.key+"=>"+entity.value+" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
