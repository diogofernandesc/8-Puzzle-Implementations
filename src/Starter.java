
public class Starter {

    public static void main(String [] args) {

        String[] startingState = {"□", "□", "□", "□", "A", "□", "A", "B", "□"};
        String[] goalState = {"□", "□", "□", "□", "A", "□", "□", "B", "□"};
        Grid grid = new Grid(startingState, 3);

        BreadthFirstSearch bfs = new BreadthFirstSearch(startingState, goalState, grid, 8, 3);
        bfs.compute();
    }
}
