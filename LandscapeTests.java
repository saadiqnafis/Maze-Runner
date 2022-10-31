/*
File name: LandscapeTests.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/

public class LandscapeTests {

    public LandscapeTests() {

        //testing the constructor
        {
        Landscape scape = new Landscape(3, 5, 0.25);
        System.out.println(scape.getRows() + " = 3");
        System.out.println(scape.getCols() + " = 5");
        
        assert scape.getRows() != 3: "Error in landscape rows";
        assert scape.getCols() != 5: "Error in landscape columns";

        }

        //testing the getCell(int row, int col)
        
        {
        Landscape scape = new Landscape(3, 5, 0.25);
        Cell cell = scape.getCell(2, 4);
        System.out.println(cell.getRow() + " = 2");
        System.out.println(cell.getCol() + " = 4");


        assert cell.getRow() != 2: "Error in getCell method";
        assert cell.getCol() != 4: "Error in getCell method";
        }


        //testing the getNeighbors() method

        {
        Landscape scape = new Landscape(3, 5, 0.25);
        Cell cell = scape.getCell(0, 0);
        Cell cell1 = scape.getCell(0, 3);
        Cell cell2 = scape.getCell(1, 3);

        System.out.println(scape.getNeighbors(cell).size() + " = 2");
        System.out.println(scape.getNeighbors(cell1).size() + " = 3");
        System.out.println(scape.getNeighbors(cell2).size() + " = 4");

        assert scape.getNeighbors(cell).size() != 2: "Error in getNeighbors method";
        assert scape.getNeighbors(cell1).size() != 3: "Error in getNeighbors method";
        assert scape.getNeighbors(cell2).size() != 4: "Error in getNeighbors method";


        }


    }

    public static void main(String[] args) {
        LandscapeTests tests = new LandscapeTests();

    }
    
}
