/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Description: Homework 09 - Stack
 */

public class Stack<E> extends LinkedList<E> {

    public void push(E value) {
        add(value);
    }

    public E pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty!");
        Node<E> toBeReturned = head;
        head = head.getNext();
        toBeReturned.setNext(null);
        return toBeReturned.getValue();
    }

    public E peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty!");
        return head.getValue();
    }

}