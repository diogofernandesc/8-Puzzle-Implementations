
public class Starter {

    public static void main(String [] args) {

        String[] startingState = {"□", "□", "□", "□", "□", "□", "A", "B", "□"};
        String[] goalState = {"□", "□", "□", "□", "A", "□", "□", "B", "□"};

        String[] startingState4x4 = {"□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "□", "A", "B", "C", "□"};
        String[] goalState4x4 = {"□", "□", "□", "□", "□", "A", "□", "□", "□", "B", "□", "□", "□", "C", "□", "□"};

        Node startNode3x3 = new Node(startingState, 8);
        Node startNodeID = new Node(startingState4x4, 15, 0, null);

       // String[] startingState = {"0", "1", "2", "3", "4", "5", "A", "B", "8"};
       // String[] goalState = {"0", "1", "2", "3", "A", "5", "6", "B", "8"};
        Grid grid3x3 = new Grid(startingState, 3);
        Grid grid4x4 = new Grid(startingState4x4, 4);

        BreadthFirstSearch bfs = new BreadthFirstSearch(startNode3x3, goalState, grid3x3, 3);
        //DepthFirstSearch dfs = new DepthFirstSearch(startNode3x3, goalState, grid3x3, 3);
        //IterativeDeepeningDFS IDFS = new IterativeDeepeningDFS(startNodeID, goalState4x4, grid, 4);
        //HeuristicSearch hs = new HeuristicSearch(startNode, goalState4x4, grid, 4);


        bfs.compute();
        //dfs.compute();
        //IDFS.compute();
        //hs.compute();
    }
}
