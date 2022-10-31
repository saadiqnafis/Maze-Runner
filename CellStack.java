/*
File name: CellStack.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/


public class CellStack {

    private class Node {
        public Node next;
        
        public Cell cell;

        //a constructor that initializes next to null and the cell field to c

        public Node(Cell c) {
            this.next = null;
           
            this.cell = c;
        }

    }

    Node head;
   
    int size;

    //initialize the stack's fields

    public CellStack() {

        this.head = null ; 
        
        this.size = 0;

    }

    //push c into the stack

    public void push (Cell c) {

        Node newNode = new Node(c);

        if (size == 0) {
          
            this.head = newNode;
        } 
        else {
            newNode.next = this.head;
            this.head = newNode;
           
            

        }

        size++;
        
    }

    //return the top cell of the stack

    public Cell peek() {

        // if (head == null) {
        //     return null;
        // }
        return this.head.cell;
    }

    //remove and return the top cell of the stack

    public Cell pop() {

        
        if (this.size == 0) {
            return null;
        }
       
        else {
            Cell c = head.cell;
            this.head = head.next;
            
            this.size--;
            return c;
        }
        

    }

    //return the size of the stack

    public int size() {

        return this.size;

    }

    //return if the stack is empty

    public boolean empty() {
        return (this.size == 0);


    }



}