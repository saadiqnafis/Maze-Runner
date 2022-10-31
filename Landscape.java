/*
File name: Landscape.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/


import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
//import Cell.Type;

import java.awt.Color;


public class Landscape {
    private Cell[][] cells;
    private Cell start;
    private Cell target;
    private int rows;
    private int cols;
    private double chance;
    private ArrayList<Cell> list;


    //initializes the constructor and assign the types of the cells

    public Landscape(int rows, int cols, double chance) {
        this.rows = rows;
        this.cols = cols;
        this.chance = chance;
        cells = new Cell[this.rows][this.cols];
        Random rand = new Random();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (rand.nextDouble() < this.chance) {
                    this.cells[i][j] = new Cell(i, j, Cell.Type.OBSTACLE);
                }
                else {
                    this.cells[i][j] = new Cell(i, j, Cell.Type.FREE);

                }

            }
        }
        
            int m = rand.nextInt(this.rows);
            int n = rand.nextInt(this.cols);
            int o = rand.nextInt(this.rows);
            int p = rand.nextInt(this.cols);
            while ( m == 0 && n == p) {
                
                m = rand.nextInt(this.rows);
                n = rand.nextInt(this.cols);
                o = rand.nextInt(this.rows);
                p = rand.nextInt(this.cols);

            }

            cells[m][n] = new Cell(m, n, Cell.Type.START);
            start = cells[m][n];
            
            cells[o][p] = new Cell(o, p, Cell.Type.TARGET);
            target = cells[o][p];


    }

    //resets the maze board

    public void reset() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                cells[i][j].reset();
            }
        }
    }

    //return the starting cell

    public Cell getStart() {
        return start;
        
    }

    //return the target cell

    public Cell getTarget() {
        return target;

    }

    //return the number of rows
    public int getRows() {
        return this.rows;

    }
    //return the number of columns
    public int getCols() {
        return this.cols;
    }
    
    // return the cell at the specified location

    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }

    //return the neighbors in the form of an arraylist

    public ArrayList<Cell> getNeighbors(Cell c) {
        list = new ArrayList<Cell>();
        int row = c.getRow();
        int col = c.getCol();
        
        if ((row - 1 ) > -1) {

            list.add(cells[row - 1][col]);
        }

        if ((col - 1) > -1) {
            list.add(cells[row][col - 1]);
        }

        if ((row + 1) < this.getRows() ) {
            list.add(cells[row + 1][col]);

        }

        if ((col + 1) < this.getCols()) {
            list.add(cells[row][col + 1]);

        }
        return list;


    }

    //draws the landscape and we declare some variables here, like length, speed and time. The length is the path to solve the maze. Speed is another variable which we use
    //determine which path will be faster. In each turn, we decrease the speed by 1, but if there are consecutive cells, we increase the speed by 1.
    // After that, we divide the length by speed to get average time.

    public void draw(Graphics g, int scale) {
        for(int r = 0; r < getRows(); r++){
            for(int c = 0; c < getCols(); c++){
                getCell(r, c).draw(g, scale, this);
            }
        }
        g.setColor(Color.RED);
        CellQueue queue = new CellQueue();
        queue.offer(start);
        while (!(queue.size() == 0)) {
            Cell cur = queue.poll();
    
            for (Cell neighbor : getNeighbors(cur)) {
                if (neighbor.getPrev() == cur) {
                    queue.offer(neighbor);
                    g.drawLine(cur.getCol() * scale + scale / 2, cur.getRow() * scale + scale / 2,
                            neighbor.getCol() * scale + scale / 2, neighbor.getRow() * scale + scale / 2);
                }
            }
        }
    
        if (target.visited()) {
            Cell cur = target.getPrev();
            
            int length = 1;
            int speed = 0;
            

            while (cur != start) {
                g.setColor(Color.GREEN);
                g.fillRect(cur.getCol() * scale + 2, cur.getRow() * scale + 2, scale - 4, scale - 3);
                Cell cell = cur;
                Cell cell1 = cur;
                Cell cell2 = cur.getPrev();
                cur = cur.getPrev();
                length++;

                
                if (cell1.getRow() == cell.getRow()) {
                    speed++;
                    if (cell2.getRow() != cell1.getRow()) {
                        speed--;
                        
                    }
                }
                else if (cell1.getCol() == cell.getCol()) {
                    speed++;
                    if (cell2.getCol() != cell1.getCol()) {
                        speed--;
                        
                    }

                }
                
            }
            //System.out.println("Speed at the end is: "+ speed);
            System.out.println("Length of the path is: " + length);
            double initial = 0.0;
             
            double d1 = Double.valueOf(length);
            double d2 = Double.valueOf(speed);
            double avgSpeed = (initial + d2)/2;
            double d = d1 / d2;
            System.out.println("Average speed is " + avgSpeed);
            System.out.println("The average time required is: "+ d);
            cur = target;

            while (cur != start) {
                g.setColor(Color.BLUE);
                g.drawLine(cur.getCol() * scale + scale / 2, cur.getRow() * scale + scale / 2,
                        cur.getPrev().getCol() * scale + scale / 2, cur.getPrev().getRow() * scale + scale / 2);
                cur = cur.getPrev();
               
            }
           
        }
    }
}
