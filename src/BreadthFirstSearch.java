import java.util.*;

public class BreadthFirstSearch {

    int tile;
    String[] startState;
    String[] goalState;
    Grid grid;
    ArrayList<String[]> visitedStates;
    Queue<String[]> stateQueue;
    Random random;

    public BreadthFirstSearch(String[] startState, String[] goalState, Grid grid) {
        this.startState = startState;
        this.goalState = goalState;
        random = new Random();
        this.grid = grid;
    }

    /*
     * 1 = Up
     * 2 = Down
     * 3 = Left
     * 4 = Right
     */
    protected String[] agentMove() {
        int directionValue = random.nextInt(4);
        String direction = null;
        
        if (directionValue == 1) {
            direction ="up";
        
        } else if (directionValue == 2) {
            direction = "down";
        
        } else if (directionValue == 3) {
            direction = "left";
            
        } else if (directionValue == 4) {
            direction = "right";
        }
        
        return direction;
    }

    protected void compute(String[] startingState, String[] goalState) {

        // Checks if the initial state and the final state are the same
        if (Arrays.equals(startingState, goalState)) {
            this.grid.printGrid();
            return;
        }

        visitedStates = new ArrayList<String[]>();
        stateQueue = new LinkedList<String[]>();
        grid.printGrid();

        stateQueue.add(startingState);
        visitedStates.add(startingState);

        while(!stateQueue.isEmpty()) {

            String[] currentState = stateQueue.remove();
            if (Arrays.equals(currentState, goalState)) {
                this.grid.printGrid();
                break;

            } else {
                
            }

        }
    }

}
