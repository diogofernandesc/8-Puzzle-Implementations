import java.util.*;

public class BreadthFirstSearch {

    int tile;
    String[] startState;
    String[] goalState;
    Grid grid;
    ArrayList<String[]> visitedStates;
    Queue<String[]> stateQueue;
    Random random;
    int agentIndex;
    int gridDimension;


    public BreadthFirstSearch(String[] startState, String[] goalState, Grid grid, int agentIndex, int gridDimension) {
        this.startState = startState;
        this.goalState = goalState;
        random = new Random();
        this.grid = grid;
        this.agentIndex = agentIndex;
        this.gridDimension = gridDimension;
        System.out.println(Arrays.toString(startState));

    }

    /*
     * 1 = Up
     * 2 = Down
     * 3 = Left
     * 4 = Right

     agentIndex is the location that the agent is in at the moment of the move
     */

//    protected String[] agentMove(String[] currentState) {
//
//        if
//        int directionValue = random.nextInt(4);
//        String direction = null;
//
//        if (directionValue == 1) {
//            if
//            direction ="up";
//
//        } else if (directionValue == 2) {
//            direction = "down";
//
//        } else if (directionValue == 3) {
//            direction = "left";
//
//        } else if (directionValue == 4) {
//            direction = "right";
//        }
//
//        return direction;
//    }

    // Determines all the possible moving directions
    protected String getDirections() {
        String directions = null;

        if (gridDimension == 3) {
            if (agentIndex == 0) {
                directions = "r, d";

            } else if (agentIndex == 1) {
                directions = "l, r, d";

            } else if (agentIndex == 2) {
                directions = "r, d";

            } else if (agentIndex == 3) {
                directions = "r, u, d";

            } else if (agentIndex == 4) {
                directions = "l, r, u, d";

            } else if (agentIndex == 5) {
                directions = "l, u, d";

            } else if (agentIndex == 6) {
                directions = "r, u";

            } else if (agentIndex == 7) {
                directions = "l, r, u";

            } else if (agentIndex == 8) {
                directions = "l, u";
            }
        }

        return directions;
    }

    protected String[] generateState(String direction, String[] currentState) {

        int moveDifference = 0;
        String[] newState = currentState.clone();

        // The move difference for up and down is the grid dimension
        if (direction.equals("l")) {
            moveDifference = -1;

        } else if (direction.equals("r")) {
            moveDifference = 1;

        } else if (direction.equals("u")) {
            moveDifference = -gridDimension;

        } else if (direction.equals("d")) {
            moveDifference = gridDimension;
        }

        String temp = newState[agentIndex];
        newState[agentIndex] = newState[agentIndex + moveDifference];    // Left is one index less on the state
        newState[agentIndex - 1] = temp;

        return newState;
    }


    protected void compute() {

        // Checks if the initial state and the final state are the same
        if (Arrays.equals(startState, goalState)) {
            this.grid.printGrid();
            return;
        }

        //visitedStates = new ArrayList<String[]>();
        stateQueue = new LinkedList<String[]>();
        grid.printGrid();

        stateQueue.add(this.startState);
        //visitedStates.add(startingState);

        while(!stateQueue.isEmpty()) {

            String[] currentState = stateQueue.remove();
            System.out.println("---------------");
            grid.updateGrid(currentState);
            grid.printGrid();

            if (Arrays.equals(currentState, goalState)) {
                break;

            } else {

                String[] directions = getDirections().split(", ");
                for (String direction : directions) {
                    stateQueue.add(generateState(direction, currentState));
                }

            }

        }
    }

}
