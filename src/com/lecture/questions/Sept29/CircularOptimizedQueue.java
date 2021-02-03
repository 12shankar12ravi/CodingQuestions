package com.lecture.questions.Sept29;

/**
 * This is the internal implementation of the real life
 * Queue , Where elements are dequeue from the queue in
 * First in First out order. And it takes O(1) time to dequeue element from the
 * queue and it conserves space also.
 * Queue
 * @param <E>
 */
public class CircularOptimizedQueue<E> {

    /*
      Internal array to store the elements in the Queue
     */
    private Object[] data ;

    /*
      Rear index to enqueue and dequeue elements from the queue
     */
    private int rear;

    /*
      front index kept to deque the elements easily from the queue
     */
    private int front;

    private int size;

    /**
     * Create a Queue object with the
     * internal default storage of size 10
     */
    public CircularOptimizedQueue(){

        this.data = new Object[10];
        this.size = 0;
        this.front= 0;
        this.rear = 0;
    }

    /**
     *
     * @return
     */
    private boolean isFull(){
        return size == data.length;
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
        rear = rear % data.length;
        size++;
    }

    /**
     *
     * @return
     */
    private boolean isEmpty(){
        return size == 0;
    }

    /**
     * In order to dequeue element from the queue we need to
     * just pull the front element and increment the front index
     */
    public E dequeue() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is empty,Please enqueue the elements");
        }

        front = front % data.length;
        size--;
        return (E) data[front++];
    }

    public void display(){
        System.out.println("-------start-------");
        for(int i=0;i<size;i++){
            System.out.println(data[(front+i) % data.length]);
        }
        System.out.println("-------end---------");
    }
}
