
public class Starter {

    public static void main(String [] args) {

        String[] startingState = {"□", "□", "□", "□", "□", "□", "A", "B", "□"};
        String[] goalState = {"□", "□", "□", "□", "A", "□", "□", "B", "□"};

       // String[] startingState = {"0", "1", "2", "3", "4", "5", "A", "B", "8"};
       // String[] goalState = {"0", "1", "2", "3", "A", "5", "6", "B", "8"};
        Grid grid = new Grid(startingState, 3);

        BreadthFirstSearch bfs = new BreadthFirstSearch(startingState, goalState, grid, 8, 3);
        bfs.compute();
    }
}
