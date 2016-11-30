import java.util.*;

public class BreadthFirstSearch {

    Node startNode;
    String[] goalState;
    Grid grid;
    Queue<Node> stateQueue;
    int gridDimension;
    int noOfNodesExpanded;



    public BreadthFirstSearch(Node startNode, String[] goalState, Grid grid, int gridDimension) {
        this.startNode = startNode;
        this.goalState = goalState;
        this.grid = grid;
        this.gridDimension = gridDimension;
        //System.out.println(Arrays.toString(startState));

    }

    // Determines all the possible moving directions
    protected String getDirections(int agentIndex) {
        String directions = null;

        if (gridDimension == 3) {
            if (agentIndex == 0) {
                directions = "r, d";

            } else if (agentIndex == 1) {
                directions = "l, r, d";

            } else if (agentIndex == 2) {
                directions = "l, d";

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

        } else if (gridDimension == 4) {
            if (agentIndex == 0) {
                directions = "r, d";

            } else if (agentIndex == 1) {
                directions = "l, r, d";

            } else if (agentIndex == 2) {
                directions = "l, r, d";

            } else if (agentIndex == 3) {
                directions = "l, d";

            } else if (agentIndex == 4) {
                directions = "r, u, d";

            } else if (agentIndex == 5) {
                directions = "l, r, u, d";

            } else if (agentIndex == 6) {
                directions = "l, r, u, d";

            } else if (agentIndex == 7) {
                directions = "l, u, d";

            } else if (agentIndex == 8) {
                directions = "r, u, d";

            } else if (agentIndex == 9) {
                directions = "l, r, u, d";

            } else if (agentIndex == 10) {
                directions = "l, r, u, d";

            } else if (agentIndex == 11) {
                directions = "l, u, d";

            } else if (agentIndex == 12) {
                directions = "r, u";

            } else if (agentIndex == 13) {
                directions = "l, r, u";

            } else if (agentIndex == 14) {
                directions = "l, r, u";

            } else if (agentIndex == 15) {
                directions = "l, u";
            }
        }

        return directions;
    }

    @SuppressWarnings("Duplicates")
    protected Node generateNode(String direction, Node currentNode) {

        //System.out.println("Agent index before: "+ agentIndex);
        int moveDifference = 0;
        String[] newState = currentNode.getState().clone();

        int agentIndex = currentNode.getAgentIndex();
        //System.out.println("Agent index is: " + agentIndex);
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


       // System.out.println("Direction: " + direction + " - move difference: " + moveDifference);
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
        //System.out.println("Agent index after is: " + agentIndex);

        //System.out.println("Agent index after: "+ agentIndex);
        return new Node(newState, agentIndex, currentNode);
    }



    protected void compute() {

        //String[] currentState;
        noOfNodesExpanded = 0;

        Node currentNode = this.startNode;

        // Checks if the initial state and the final state are the same
        if (Arrays.equals(startNode.getState(), goalState)) {
            this.grid.printGrid(currentNode.getAgentIndex(), currentNode.getState());
            return;
        }

        //visitedStates = new ArrayList<String[]>();
        stateQueue = new LinkedList<Node>();
        //grid.printGrid();

        stateQueue.add(currentNode);
        //visitedStates.add(startingState);

        while(!stateQueue.isEmpty()) {

            currentNode = stateQueue.remove();
            //System.out.println("---------------");
            //grid.updateGrid(currentNode.getState());
            //grid.printGrid(currentNode.getAgentIndex());
            //System.out.println("ACTUAL AGENT INDEX IS: " + currentNode.getAgentIndex());
            //System.out.println("-------");
            //System.out.println(Arrays.toString(currentNode.getState()));
            //System.out.println("-------");
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
                    Node newNode = generateNode(direction, currentNode);
                    newNode.setDirection(direction);
                    stateQueue.add(newNode);
                    noOfNodesExpanded++;
                    //System.out.println("Number of nodes expanded so far: " + noOfNodesExpanded);
                }

            }

        }

        System.out.println("Final number of nodes expanded: " + noOfNodesExpanded);
        //grid.updateGrid(currentNode.getState());
        //grid.printGrid(currentNode.getAgentIndex());

        ArrayList<String> direction = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        while(currentNode.getParentNode() != null) {
            nodes.add(0, currentNode);
            direction.add(0, currentNode.getDirection());
            currentNode = currentNode.getParentNode();
        }
        nodes.add(0, currentNode);

        for(Node node : nodes) {
            grid.printGrid(node.getAgentIndex(), node.getState());
            System.out.println("---------");
        }

        //grid.printGrid(currentNode.getAgentIndex(), currentNode.getState());

        System.out.println(Arrays.toString(direction.toArray()));
        System.out.println("Amount of steps: " + direction.size());
    }

}
