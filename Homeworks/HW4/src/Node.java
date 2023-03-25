/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Description: Homework 04 - LinkedList
 */

class Node {

    private int  value;
    private Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value + "";
    }
}

class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    // TODOd: return true/false depending on whether the list is empty or not
    public boolean isEmpty() {
        return head == null;
    }


    // TODOd: add a new element (with the value) in front of the list!
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.setNext(head);
        head = newNode;
    }

    // TODOd: add a new element (with the value) at the end of the list!
    public void append(int value) {
        Node newNode = new Node(value);
        if (isEmpty())
            head = newNode;
        else {
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            // at this point, what can we tell about current?
            // for sure, current points to the tail node!!!
            current.setNext(newNode);
        }
    }

    // TODOd: returns the # of elements
    public int size() {
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    // TODOd: return a string representation of the object
    @Override
    public String toString() {
        Node current = head;
        String s = "";
        while (current != null) {
            s += current + " ";
            current = current.getNext();
        }
        return s.trim();
    }

    // TODOd: return the element at index location
    public int get(int index) {
        // check if index is valid 1st
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();
        return current.getValue();
    }

    // TODOd: sets value to location at index
    public void set(int index, int value) {
        // check if index is valid 1st
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();
        current.setValue(value);
    }

    // TODOd: inserts value at the given index location
    // throw an exception if index is invalid
    public void insert(int index, int value) {
        // check if index is valid 1st
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        // special case: index is zero
        if (index == 0)
            add(value);
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
                current = current.getNext();
            Node newNode = new Node(value);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    // TODOd: removes the element at the given index location
    // throw an exception if index is invalid
    public void remove(int index) {
        // check if index is valid 1st
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        // special case: index is zero
        if (index == 0) {
            Node toBeRemoved = head;
            head = head.getNext();
            toBeRemoved.setNext(null);
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
                current = current.getNext();
            Node toBeRemoved = current.getNext();
            current.setNext(toBeRemoved.getNext());
            toBeRemoved.setNext(null);
        }
    }

    // TODOd: remove all elements of the linked list, making sure no node's next references are left
    public void clear() throws Exception {

        Node current = head;
        Node prev = head;

        if (isEmpty()){
            throw new Exception("The list is empty.");
        }
        while (current.getNext() != null){
            current = current.getNext();
            prev.setNext(null);
            prev = current;
        }
        head = null;
    }

    public static void main(String[] args) throws Exception {
        LinkedList lst = new LinkedList();
        lst.append(1); lst.append(2); lst.append(3);
        System.out.println("Before clear: " + lst);
        lst.clear();
        System.out.println("After clear: " + lst);
    }
}
