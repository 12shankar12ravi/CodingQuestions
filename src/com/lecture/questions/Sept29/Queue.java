package com.lecture.questions.Sept29;

/**
 * This is the internal implementation of the real life
 * Queue , Where elements are dequeue from the queue in
 * First in First out order.
 * @param <E>
 */
public class Queue<E> {

    /*
      Internal array to store the elements in the Queue
     */
    private Object[] data ;

    /*
      Rear index to enqueue and dequeue elements from the queue
     */
    private int rear = -1;

    /**
     * Create a Queue object with the
     * internal default storage of size 10
     */
    public Queue(){
        this.data = new Object[10];
    }

    /**
     *
     * @return
     */
    private boolean isFull(){
        return rear == data.length-1;
    }

    /**
     *
     * @param element
     */
    public void enqueue (E element) throws QueueException {
        if(isFull()){
            throw new QueueException("Queue is full , can't enqueue more elements , Please dequeue elements first");
        }
        data[++rear] = element;
    }

    /**
     *
     * @return
     */
    private boolean isEmpty(){
        return rear == -1;
    }

    /**
     * In order to dequeue element from the queue we need to
     * run a loop which shifts the elements to left side and
     * dequeue first element
     */
    public E dequeue() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is empty,Please enqueue the elements");
        }
        E temp = (E)data[0];
        for (int i = 1; i <= rear; i++) {
            data[i-1] = data[i];
        }
        rear--;
        return temp;
    }
}
