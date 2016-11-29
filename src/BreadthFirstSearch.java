import java.util.*;

public class BreadthFirstSearch {

    int tile;
    Node startNode;
    String[] goalState;
    Grid grid;
    Queue<Node> stateQueue;
    Random random;
    int gridDimension;



    public BreadthFirstSearch(Node startNode, String[] goalState, Grid grid, int gridDimension) {
        this.startNode = startNode;
        this.goalState = goalState;
        random = new Random();
        this.grid = grid;
        this.gridDimension = gridDimension;
        //System.out.println(Arrays.toString(startState));

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
    protected String getDirections(int agentIndex) {
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

    protected Node generateNode(String direction, Node currentNode) {

        //System.out.println("Agent index before: "+ agentIndex);
        int moveDifference = 0;
        String[] newState = currentNode.getState();

        int agentIndex = currentNode.getAgentIndex();
        System.out.println("Agent index is: " + agentIndex);
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
        System.out.println("Direction: " + direction + " - move difference: " + moveDifference);
        String temp = newState[agentIndex];
//        System.out.println("agent index value before is: " + temp);
//        System.out.println("block of move is: " + newState[agentIndex + moveDifference]);
        newState[agentIndex] = newState[agentIndex + moveDifference];    // Left is one index less on the state
        newState[agentIndex + moveDifference] = temp;

//        System.out.println();
//        System.out.println("Agent index value after is " + newState[agentIndex]);
//        System.out.println("Block index value after is " + newState[agentIndex + moveDifference]);
//        System.out.println("------");

        agentIndex = agentIndex + moveDifference;
        System.out.println("Agent index after is: " + agentIndex);

        //System.out.println("Agent index after: "+ agentIndex);
        return new Node(newState, agentIndex);
    }



    protected void compute() {

        String[] currentState;

        Node currentNode = this.startNode;

        // Checks if the initial state and the final state are the same
        if (Arrays.equals(startNode.getState(), goalState)) {
            this.grid.printGrid(currentNode.getAgentIndex());
            return;
        }

        //visitedStates = new ArrayList<String[]>();
        stateQueue = new LinkedList<Node>();
        //grid.printGrid();

        stateQueue.add(currentNode);
        //visitedStates.add(startingState);

        while(!stateQueue.isEmpty()) {

            currentNode = stateQueue.remove();
            System.out.println("---------------");
            grid.updateGrid(currentNode.getState());
            grid.printGrid(currentNode.getAgentIndex());
            System.out.println("ACTUAL AGENT INDEX IS: " + currentNode.getAgentIndex());
            System.out.println("-------");
            System.out.println(Arrays.toString(currentNode.getState()));
            System.out.println("-------");
//            for (Node node : stateQueue) {
//                System.out.println(Arrays.toString(node.getState()));
//            }
            //System.out.println(agentIndex);
            if (Arrays.equals(currentNode.getState(), goalState)) {
                System.out.println("FINISHED");
                break;

            } else {

                String[] directions = getDirections(currentNode.getAgentIndex()).split(", ");
                for (String direction : directions) {
                    //System.out.println(direction);
                    stateQueue.add(generateNode(direction, currentNode));
                }

            }

        }
    }

}
