package com.lecture.questions.Sept29;

import java.util.Arrays;

/**
 * This is the internal implementation of the real life
 * Queue , Where elements are dequeue from the queue in
 * First in First out order. And it takes O(1) time to dequeue element from the
 * One Disadvantage of this queue is that it just increases the space it is not
 * really removing the element from the queue when we dequeue the element.
 * Queue
 * @param <E>
 */
public class OptimizedQueue<E> {

    /*
      Internal array to store the elements in the Queue
     */
    private Object[] data ;

    /*
      Rear index to enqueue and dequeue elements from the queue
     */
    private int rear = 0;

    /*
      front index kept to deque the elements easily from the queue
     */
    private int front = 0;

    /**
     * Create a Queue object with the
     * internal default storage of size 10
     */
    public OptimizedQueue(){
        this.data = new Object[10];
    }

    /**
     *
     * @return
     */
    private boolean isFull(){
        return rear == data.length;
    }

    /**
     *
     * @param element
     */
    public void enqueue (E element) throws QueueException {
        if(isFull()){
            throw new QueueException("Queue is full , can't enqueue more elements , Please dequeue elements first");
        }
        data[rear++] = element;
    }

    /**
     *
     * @return
     */
    private boolean isEmpty(){
        return front == rear;
    }

    /**
     * In order to dequeue element from the queue we need to
     * just pull the front element and increment the front index
     */
    public E dequeue() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is empty,Please enqueue the elements");
        }

        return (E) data[front++];
    }

    @Override
    public String toString(){
        String str = "[";
        for (int i = front; i < rear ; i++) {
            str+= data[i]+",";
        }
        str+= "]";
        return str;
    }
}
