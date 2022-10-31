/*
File name: Cell.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/


import java.awt.Graphics;
import java.awt.Color;

/*
constructor that sets up the row, col, and type as specified; prev should be null and visited should be false
*/
public class Cell {
    public enum Type {

        FREE, OBSTACLE, START, TARGET
    }
    private boolean visited;
    private Cell prev;
    private int row, col;
   // private int col;
    private Type type;
    
    /*
    constructor that sets up the row, col, and type as specified; prev should be null and visited should be false
    */
    public Cell(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.prev = null;
        this.visited = false;

    }

    //return the row
    public int getRow() {

        return this.row;

    }

    //return the column

    public int getCol() {

        return this.col;
    }

    //return the type of the cell

    public Type getType() {
        return this.type;
    }

    //return if the cell is visited or not

    public boolean visited() {

        return this.visited;

    }

    //return the previous cell
    public Cell getPrev() {

        return prev;


    }

    

    //sets visited to true and prev to c

    public void visitFrom(Cell c) {

        this.visited = true;
        this.prev = c;

    }

    //sets visited to false and prev to null


    public void reset() {

        this.visited = false;
        this.prev = null;
    }

    // draws the cell

    public void draw(Graphics g, int scale, Landscape scape) {
        g.setColor(Color.BLACK);
        g.drawRect(getCol() * scale, getRow() * scale, scale, scale);
        switch (getType()) {
            case FREE:
                g.setColor(visited() ? Color.YELLOW : Color.GRAY);
                break;
            case OBSTACLE:
                g.setColor(Color.BLACK);
                break;
            case START:
                g.setColor(Color.BLUE);
                break;
            case TARGET:
                g.setColor(Color.RED);
                break;
        }
        g.fillRect(getCol() * scale + 2, getRow() * scale + 2, scale - 4, scale - 3);
    
        g.setColor(Color.RED);
        if (getPrev() != null && getPrev() != this) {
            int midX = ((getCol() + getPrev().getCol()) * scale + scale) / 2;
            int midY = ((getRow() + getPrev().getRow()) * scale + scale) / 2;
            g.drawLine(getCol() * scale + scale / 2, getRow() * scale + scale / 2,
                    midX, midY);
        }
        for (Cell neighbor : scape.getNeighbors(this)) {
            if (neighbor.getPrev() == this) {
                int midX = ((getCol() + neighbor.getCol()) * scale + scale) / 2;
                int midY = ((getRow() + neighbor.getRow()) * scale + scale) / 2;
                g.drawLine(getCol() * scale + scale / 2, getRow() * scale + scale / 2,
                        midX, midY);
            }
        }
    }     
    
     

}
