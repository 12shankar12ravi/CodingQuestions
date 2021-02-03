package com.lecture.questions.Sept29;

/**
 *  This is the implementation of the real life stack
 *  where user can push the element and elements are popped
 *  from the Stack in Last In First Out order (LIFO)
 * @param <E> E is the Object type to be pushed in the Stack defined at Initiation of the stack.
 */
public class Stack<E> {

    /*
      Creating a internal array which store the elements of the stack.
     */
    private Object[] data;

    /*
      The index to maintain the top index to push and pop the latest added element
     */
    private int top = -1;

    /**
     * Creation of stack object by initializing the
     * internal array of elements , taking default size as 10.
     */
    public Stack(){
        this.data = new Object[10];
    }

    /*
      Check internally if the stack is full or not. Once top reaches last index then stack is full .
     */
    private boolean ifFull(){
        return top == data.length-1;
    }

    /**
     * Increments the top and Pushes the new element in the stack .
     * @param element The element to be pushed in the Stack (It should be of E type)
     * @throws Exception StackException , when stack is full
     */
    public void push(E element) throws Exception{
        if (ifFull()){
            throw new StackException("Stack is full, Please pop the items");
        }
        data[++top] = element;
    }

    /**
     * Check if stack is empty or not
     * @return true/false if the stack is empty , top is at -1 return true else false
     */
    private boolean isEmpty(){
        return top == -1;
    }

    /**
     *  Pops latest element from the Stack and decrements top index.
     * @return Return Latest element pushed to the stack
     * @throws Exception If the stack is empty , Throw StackException.
     */
    public E pop() throws Exception{
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }

        return (E) data[top--];
    }
}
