/*
File name: GridSearch.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Course: CS231B
Lab Section: CS231LC
Project 5 
*/

public class GridSearch {
    private CellStack stack;
    public CellQueue queue;
    private Landscape landscape;
    private LandscapeDisplay display;

    //initializes the constructor using the parameters

    public GridSearch() {
        
        landscape = new Landscape(30, 30, 0.25);
        display = new LandscapeDisplay(landscape, 20);

    }

    // This method implements the DFS by using stack

    public boolean depthFirstSearch(int delay) throws InterruptedException {
        stack = new CellStack();
        landscape.getStart().visitFrom(landscape.getStart());
        int n = 0;
       
        
        stack.push(landscape.getStart());
        n++;

        while (stack.size() != 0) {

            if (delay > 0){
                Thread.sleep(delay);
                display.repaint();
            }

            Cell cur = stack.pop();
            
            for (Cell neighbor : landscape.getNeighbors(cur)) {
                if (neighbor.getRow() == landscape.getTarget().getRow() && neighbor.getCol() == landscape.getTarget().getCol()) {
                    //if (neighbor.isEquals(landscape.getTarget()))
                        System.out.println("Number of cells visited in DFS: "+ n);
                        Thread.sleep(2000);
                        return true;
                    }
                if (neighbor.getType() != Cell.Type.OBSTACLE && neighbor.visited() != true) {
                    neighbor.visitFrom(cur);
                    stack.push(neighbor);
                    n++;
                }

                // if (neighbor.getType() != Cell.Type.OBSTACLE && neighbor.visited() != true) {
                //     neighbor.visitFrom(cur);
                //     if (neighbor.getRow() == landscape.getTarget().getRow() && neighbor.getCol() == landscape.getTarget().getCol()) {
                //     //if (neighbor.isEquals(landscape.getTarget()))
                //         System.out.println("Number of cells visited in DFS: "+ n);
                //         Thread.sleep(2000);
                //         return true;
                //     }
                //     stack.push(neighbor);
                //     n++;

                // }

            }
            
        }
        return false;

    }

    //This method implements the BFS using queue

    public boolean breadthFirstSearch(int delay) throws InterruptedException {
        queue = new CellQueue();
        int offer = 0;
        
        landscape.getStart().visitFrom(landscape.getStart());
        
        queue.offer(landscape.getStart());
        offer++;
        while (queue.size() != 0) {

            if (delay > 0){
                Thread.sleep(delay);
                display.repaint();
            }

            Cell cur = queue.poll();
           
            for (Cell neighbor : landscape.getNeighbors(cur)) {
                if (neighbor.getType() != Cell.Type.OBSTACLE && neighbor.visited() != true) {
                    neighbor.visitFrom(cur);
                    
                    if (neighbor.getRow() == landscape.getTarget().getRow() && neighbor.getCol() == landscape.getTarget().getCol()) {
                        
                        System.out.println("Number of cells visited in BFS: "+ offer) ;
                        Thread.sleep(2000);

                        return true;
                    }
                    queue.offer(neighbor);
                    offer++;

                }

            }
            
        }
        return false;


    }

    //resets the maze

    public void reset() {
        landscape.reset();
    }

    // As we run the main method, we will see the maze solving and after that the terminal will print out the length of the path for both the DFS and BFS,
    //and also it will print out number of cells visited, which is the part of our extension
    // Moreover, for another extension, we print out the speed and average time.


    public static void main(String[] args) throws InterruptedException {
        
        
            GridSearch search = new GridSearch();
            
            search.breadthFirstSearch(10);
            search.reset();
            search.depthFirstSearch(10);
        




    }
    
}
