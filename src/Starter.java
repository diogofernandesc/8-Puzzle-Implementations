
public class Starter {

    public static void main(String [] args) {

        String[] startingState = {"□", "□", "□", "□", "□", "□", "A", "B", "□"};
        String[] goalState = {"□", "□", "□", "□", "A", "□", "□", "B", "□"};

        Node startNode = new Node(startingState, 8);
       // String[] startingState = {"0", "1", "2", "3", "4", "5", "A", "B", "8"};
       // String[] goalState = {"0", "1", "2", "3", "A", "5", "6", "B", "8"};
        Grid grid = new Grid(startingState, 3);

        BreadthFirstSearch bfs = new BreadthFirstSearch(startNode, goalState, grid, 3);
        DepthFirstSearch dfs = new DepthFirstSearch(startNode, goalState, grid, 3);
        //bfs.compute();
        dfs.compute();
    }
}
