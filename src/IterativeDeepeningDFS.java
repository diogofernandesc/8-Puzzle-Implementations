import java.util.*;

/**
 * Created by Diogo on 29/11/2016.
 */
public class IterativeDeepeningDFS {

    Node startNode;
    String[] goalState;
    Grid grid;
    Stack<Node> stateStack;
    int gridDimension;
    Random random;
    int noOfNodesExpanded;
    int maxDepth;

    public IterativeDeepeningDFS(Node startNode, String[] goalState, Grid grid, int gridDimension) {
        this.startNode = startNode;
        this.goalState = goalState;
        this.grid = grid;
        this.gridDimension = gridDimension;
        random = new Random();
    }

    @SuppressWarnings("Duplicates")
    protected List<String> getDirections(int agentIndex) {
        String[] directions = {};

        if (gridDimension == 3) {
            if (agentIndex == 0) {
                directions = new String[]{"r", "d"};

            } else if (agentIndex == 1) {
                directions = new String[]{"l", "r", "d"};

            } else if (agentIndex == 2) {
                directions = new String[]{"l", "d"};

            } else if (agentIndex == 3) {
                directions = new String[]{"r", "u", "d"};

            } else if (agentIndex == 4) {
                directions = new String[]{"l", "r", "u", "d"};

            } else if (agentIndex == 5) {
                directions = new String[]{"l", "u", "d"};

            } else if (agentIndex == 6) {
                directions = new String[]{"r", "u"};

            } else if (agentIndex == 7) {
                directions = new String[]{"l", "r", "u"};

            } else if (agentIndex == 8) {
                directions = new String[]{"l", "u"};
            }
        } else if (gridDimension == 4) {
            if (agentIndex == 0) {
                directions = new String[]{"r", "d"};

            } else if (agentIndex == 1) {
                directions = new String[]{"l", "r", "d"};

            } else if (agentIndex == 2) {
                directions = new String[]{"l", "r", "d"};

            } else if (agentIndex == 3) {
                directions = new String[]{"l", "d"};

            } else if (agentIndex == 4) {
                directions = new String[]{"r", "u", "d"};

            } else if (agentIndex == 5) {
                directions = new String[]{"l", "r", "u", "d"};

            } else if (agentIndex == 6) {
                directions = new String[]{"l", "r", "u", "d"};

            } else if (agentIndex == 7) {
                directions = new String[]{"l", "u", "d"};

            } else if (agentIndex == 8) {
                directions = new String[]{"r", "u", "d"};

            } else if (agentIndex == 9) {
                directions = new String[]{"l", "r", "u", "d"};

            } else if (agentIndex == 10) {
                directions = new String[]{"l", "r", "u", "d"};

            } else if (agentIndex == 11) {
                directions = new String[]{"l", "u", "d"};

            } else if (agentIndex == 12) {
                directions = new String[]{"r", "u"};

            } else if (agentIndex == 13) {
                directions = new String[]{"l", "r", "u"};

            } else if (agentIndex == 14) {
                directions = new String[]{"l", "r", "u"};

            } else if (agentIndex == 15) {
                directions = new String[]{"l", "u"};
            }
        }
        List<String> directionsList = Arrays.asList(directions);
        Collections.shuffle(directionsList); // Shuffle the listen to randomise order
        return directionsList;
    }

    @SuppressWarnings("Duplicates")
    protected Node generateNode(String direction, Node currentNode, int depth) {

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

        //    //System.out.println("Agent index after: "+ agentIndex);
        return new Node(newState, agentIndex, depth);
    }

    @SuppressWarnings("Duplicates")
    protected void compute() {

        //String[] currentState;
        noOfNodesExpanded = 0;

        Node currentNode = this.startNode;

        // Checks if the initial state and the final state are the same
        if (Arrays.equals(startNode.getState(), goalState)) {
            this.grid.printGrid(currentNode.getAgentIndex());
            return;
        }

        //visitedStates = new ArrayList<String[]>();
        stateStack = new Stack<>();
        //grid.printGrid();


        //visitedStates.add(startingState);

        maxDepth = 0;

        while (!Arrays.equals(currentNode.getState(), goalState)) {

            stateStack.push(this.startNode);

            while (!stateStack.isEmpty()) {

                currentNode = stateStack.pop();
                System.out.println("---------------");
                grid.updateGrid(currentNode.getState());
                grid.printGrid(currentNode.getAgentIndex());
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

                    if (currentNode.getDepth() < maxDepth) {

                        List<String> directions = getDirections(currentNode.getAgentIndex());
                        for (String direction : directions) {
                            stateStack.push(generateNode(direction, currentNode, currentNode.getDepth() + 1));
                            noOfNodesExpanded++;
                            System.out.println("Number of nodes expanded so far: " + noOfNodesExpanded);

                        }

                    }


                }

            }

            maxDepth++;
        }


        System.out.println("Final number of nodes expanded: " + noOfNodesExpanded);
    }
}
