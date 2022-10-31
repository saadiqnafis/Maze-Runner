/*
File name: CellQueueTests.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/


public class CellQueueTests {
    public CellQueueTests() {


        //testing the head, tail and size
    {
        CellQueue queue = new CellQueue();
        System.out.println(queue.head + " == null");
        System.out.println(queue.tail + " == null");
        System.out.println(queue.size() + " == 0");

        assert queue.head != null: "Error in initializing head";
        assert queue.tail != null: "Error in initializing tail";
        assert queue.size() != 0: "Error in the size of queue";
    }

    //testing the offer, peek and size
    {
        CellQueue queue = new CellQueue();
            for(int i = 0; i < 5; i++){
                queue.offer(new Cell(1,1, Cell.Type.FREE));
            }
            System.out.println(queue.peek().getRow() + " == 1");

            System.out.println(queue.peek().getCol() + " == 1");
            System.out.println(queue.size() + " == 5");
            
            assert queue.size() == 5 : "Error in CellQueue::push()";
            assert queue.peek().getRow() == 1: "Error in CellQueue:: ppek()";
            assert queue.peek().getCol() == 1: "Error in CellQueue:: peek()";


    }
    //testing the poll
    {
        CellQueue queue = new CellQueue();
        for(int i = 0; i < 5; i++){
            queue.offer(new Cell(2,1, Cell.Type.FREE));
        }
        Cell cell = queue.poll();
        System.out.println(cell.getRow() + " = 2");
        System.out.println(cell.getCol() + " = 1");

        System.out.println(queue.size() + " == 4");



    }




    }




    public static void main(String[] args) {
        CellQueueTests tests = new CellQueueTests();
    }


}
