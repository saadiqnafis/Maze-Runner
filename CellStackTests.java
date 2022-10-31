/*
File name: CellStackTests.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/


public class CellStackTests {
    
    public static void CellStackTests() {
        
        //testing the constructor

        {

            CellStack stack = new CellStack();
            System.out.println(stack.head + " == null");
            
            System.out.println(stack.size() + " == 0");


            assert stack.head != null: "Error in initliazing head";
            assert stack.size != 0: "Error in stack size";
        }

        {

        //testing the push and size

            CellStack stack = new CellStack();
            for(int i = 0; i < 5; i++){
                stack.push(new Cell(1,1, Cell.Type.FREE));
            }

            
            System.out.println(stack.size() + " == 5");
            
            
            assert stack.size() != 5 : "Error in CellStack::push()";
        }

      
        {
           
        //testing the peek

            CellStack stack = new CellStack();
            for(int i = 1; i < 5; i++){
                stack.push(new Cell(i, i, Cell.Type.OBSTACLE));
            }
            

            
            System.out.println(stack.size() + " == 4");

            
         
            assert stack.size() == 4 : "Error in CellStack::peek()";
        }

        //testing the pop
       
        {
           
            CellStack stack = new CellStack();
            for(int i = 1; i < 5; i++){
                stack.push(new Cell(i, i, Cell.Type.FREE));
            }
            

            System.out.println(stack.size() + " == 3");
           
           
          
            assert stack.size() == 3 : "Error in CellStack::pop()";
            
        }
    }


    public static void main(String[] args) {
        CellStackTests();
    }
}
        
    

