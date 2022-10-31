/*
File name: CellQueue.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/


public class CellQueue {

    private class Node {
        public Node next;
        public Node prev;
        public Cell cell;


        public Node(Cell c) {
            this.next = null;
            this.prev = null;
            this.cell = c;
        }

    }

    Node head;
    Node tail;
    int size;

    //constructor that initializes the fields so it is an empty queue

    public CellQueue() {

        this.head = null ; 
        this.tail = null;
        this.size = 0;

    }

    //inserts the cell at the end of the queue.

    public void offer (Cell c) {

        Node newNode = new Node(c);

        if (size == 0) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            
            this.tail = newNode;

        }

        size++;
        
    }

    // returns but does not remove the Cell at the front of the queue

    public Cell peek() {

        if (head == null) {
            return null;
        }
        return this.head.cell;
    }

    // returns and removes the Cell at the front of the queue.

    public Cell poll() {

        
        if (this.size == 0) {
            return null;
        }
        else if (this.size == 1){

            Cell c = head.cell;
            this.tail = null;
            this.head = null;
            size--;
            return c;
        }
        else {
            Cell t = head.cell;
            this.head = head.next;
            head.prev = null;
            this.size--;
            return t;
        }
        

    }

    //returns the number of Cells in the queue
    
    public int size() {

        return this.size;

    }



}