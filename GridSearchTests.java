public class GridSearchTests {
    
    public GridSearchTests() throws InterruptedException {

        {

            GridSearch search = new GridSearch();
            boolean bool = search.depthFirstSearch(0);
            //System.out.println(bool);
            search.reset();
            boolean bool1 = search.breadthFirstSearch(0);
            

            //System.out.println(bool1);
            // System.out.println();
            System.out.println(bool + " = " + bool1);

            assert bool != bool1 : "Error in GridSearch";

        }


    }

    public static void main(String[] args) throws InterruptedException {
        GridSearchTests gridTests = new GridSearchTests();
    }
}
