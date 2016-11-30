
public class Starter {

    public static void main(String [] args) {

        String[] startingState = {"□", "□", "□", "□", "□", "□", "A", "B", "□"};
        String[] goalState = {"□", "□", "□", "□", "A", "□", "□", "B", "□"};

        String[] startingState4x4 = {"□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "A", "B", "C", "□"};
        String[] goalState4x4 = {"□", "□", "□", "□", "□", "A", "□", "□", "□", "B", "□", "□", "□", "C", "□", "□"};

        Node startNode = new Node(startingState4x4, 15);
        Node startNodeID = new Node(startingState4x4, 15, 0);
       // String[] startingState = {"0", "1", "2", "3", "4", "5", "A", "B", "8"};
       // String[] goalState = {"0", "1", "2", "3", "A", "5", "6", "B", "8"};
        Grid grid = new Grid(startingState4x4, 4);

        BreadthFirstSearch bfs = new BreadthFirstSearch(startNode, goalState4x4, grid, 4);
        DepthFirstSearch dfs = new DepthFirstSearch(startNode, goalState, grid, 4);
        IterativeDeepeningDFS IDFS = new IterativeDeepeningDFS(startNodeID, goalState4x4, grid, 4);
        //bfs.compute();
        IDFS.compute();
        //dfs.compute();
    }
}
