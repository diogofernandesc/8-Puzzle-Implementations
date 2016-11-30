
// This heuristic uses Manhattan distance

import java.util.*;

public class HeuristicSearch {

    Node startNode;
    String[] goalState;
    Grid grid;
    Stack<Node> stateStack;
    int gridDimension;
    Random random;
    int noOfNodesExpanded;
    PriorityQueue<Node> priorityQueue;

    public HeuristicSearch(Node startNode, String[] goalState, Grid grid, int gridDimension) {
        this.startNode = startNode;
        this.goalState = goalState;
        this.grid = grid;
        this.gridDimension = gridDimension;
        random = new Random();

    }

     /*
     * 1 = Up
     * 2 = Down
     * 3 = Left
     * 4 = Right

     agentIndex is the location that the agent is in at the moment of the move
     */

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

//    protected List<String> getDirections(int agentIndex) {
//        String[] directions = {};
//
//        if (gridDimension == 3) {
//            if (agentIndex == 0) {
//                directions = new String[]{"r", "d"};
//
//            } else if (agentIndex == 1) {
//                directions = new String[]{"l", "r", "d"};
//
//            } else if (agentIndex == 2) {
//                directions = new String[]{"l", "d"};
//
//            } else if (agentIndex == 3) {
//                directions = new String[]{"r", "u", "d"};
//
//            } else if (agentIndex == 4) {
//                directions = new String[]{"l", "r", "u", "d"};
//
//            } else if (agentIndex == 5) {
//                directions = new String[]{"l", "u", "d"};
//
//            } else if (agentIndex == 6) {
//                directions = new String[]{"r", "u"};
//
//            } else if (agentIndex == 7) {
//                directions = new String[]{"l", "r", "u"};
//
//            } else if (agentIndex == 8) {
//                directions = new String[]{"l", "u"};
//            }
//        } else if (gridDimension == 4) {
//            if (agentIndex == 0) {
//                directions = new String[]{"r", "d"};
//
//            } else if (agentIndex == 1) {
//                directions = new String[]{"l", "r", "d"};
//
//            } else if (agentIndex == 2) {
//                directions = new String[]{"l", "r", "d"};
//
//            } else if (agentIndex == 3) {
//                directions = new String[]{"l", "d"};
//
//            } else if (agentIndex == 4) {
//                directions = new String[]{"r", "u", "d"};
//
//            } else if (agentIndex == 5) {
//                directions = new String[]{"l", "r", "u", "d"};
//
//            } else if (agentIndex == 6) {
//                directions = new String[]{"l", "r", "u", "d"};
//
//            } else if (agentIndex == 7) {
//                directions = new String[]{"l", "u", "d"};
//
//            } else if (agentIndex == 8) {
//                directions = new String[]{"r", "u", "d"};
//
//            } else if (agentIndex == 9) {
//                directions = new String[]{"l", "r", "u", "d"};
//
//            } else if (agentIndex == 10) {
//                directions = new String[]{"l", "r", "u", "d"};
//
//            } else if (agentIndex == 11) {
//                directions = new String[]{"l", "u", "d"};
//
//            } else if (agentIndex == 12) {
//                directions = new String[]{"r", "u"};
//
//            } else if (agentIndex == 13) {
//                directions = new String[]{"l", "r", "u"};
//
//            } else if (agentIndex == 14) {
//                directions = new String[]{"l", "r", "u"};
//
//            } else if (agentIndex == 15) {
//                directions = new String[]{"l", "u"};
//            }
//        }
//        List<String> directionsList = Arrays.asList(directions);
//        Collections.shuffle(directionsList); // Shuffle the listen to randomise order
//        return directionsList;
//    }

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
        return new Node(newState, agentIndex, depth, currentNode);
    }

    protected void estimateFutureCost(Node node) {

        int cost = 0;

        String[] nodeState = node.getState();

        int nodeIndexA = Arrays.asList(nodeState).indexOf("A");
        int nodeIndexB = Arrays.asList(nodeState).indexOf("B");

        int goalIndexA = Arrays.asList(goalState).indexOf("A");
        int goalIndexB = Arrays.asList(goalState).indexOf("B");

        int nodeIndexC = 0;
        int goalIndexC = 0;
        if (gridDimension == 4) {
            nodeIndexC = Arrays.asList(nodeState).indexOf("C");
            goalIndexC = Arrays.asList(goalState).indexOf("C");
        }

        // X and Y coordinates at the given Index

        int[] nodeA_XY = getXY(nodeIndexA);
        int[] nodeB_XY = getXY(nodeIndexB);

        int[] goalA_XY = getXY(goalIndexA);
        int[] goalB_XY = getXY(goalIndexB);

        int[] nodeC_XY = {};
        int[] goalC_XY = {};
        if (gridDimension == 4) {
            nodeC_XY = getXY(nodeIndexC);
            goalC_XY = getXY(goalIndexC);
        }

        int costA = Math.abs(nodeA_XY[0] - goalA_XY[0]) + Math.abs(nodeA_XY[1] - goalA_XY[1]);
        int costB = Math.abs(nodeB_XY[0] - goalB_XY[0]) + Math.abs(nodeB_XY[1] - goalB_XY[1]);

        int costC = 0;
        if (gridDimension == 4) {
            costC = Math.abs(nodeC_XY[0] - goalC_XY[0]) + Math.abs(nodeC_XY[1] - goalC_XY[1]);
        }

        cost = costA + costB + costC;

        // f(n) = g(n) + h(n)
        // Where g(n) is the depth of the node and h(n) is the cost just calculated
        //System.out.println(cost);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        node.setEstimatedCostToGoal(node.getDepth() + cost);

    }

    protected int[] getXY(int index) {

        int x, y;

        x = index % gridDimension;
        y = (int) ((double)index / (double) gridDimension);

//        System.out.println("x: " + x);
//        System.out.println("y: " + y);
//        System.out.println("-----");

//        if (gridDimension == 3) {
//            if (index == 0) {
//                x = 0;
//                y = 0;
//
//            } else if (index == 1) {
//                x = 1;
//                y = 0;
//
//            } else if (index == 2) {
//                x = 2;
//                y = 0;
//
//            } else if (index == 3) {
//                x = 3;
//                y = 0;
//
//            }
//        }

        return new int[]{x, y};


    }

    @SuppressWarnings("Duplicates")
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
        //stateStack = new Stack<>();
        //grid.printGrid();

        estimateFutureCost(currentNode);
        Comparator<Node> costComparator = new CostComparator();
        priorityQueue = new PriorityQueue<>(10, costComparator);


        priorityQueue.add(currentNode);
        //visitedStates.add(startingState);

        while(!priorityQueue.isEmpty()) {

            currentNode = priorityQueue.remove();
            //System.out.println("---------------");
//            grid.updateGrid(currentNode.getState());
//            grid.printGrid(currentNode.getAgentIndex());
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
                    Node newNode = generateNode(direction, currentNode, currentNode.getDepth() + 1);
                    newNode.setDirection(direction);
                    estimateFutureCost(newNode);
                    priorityQueue.add(newNode);
                    noOfNodesExpanded++;
                    //System.out.println("Number of nodes expanded so far: " + noOfNodesExpanded);
                }

            }

            System.out.println("Current cost: "+ currentNode.getDepth());
            System.out.println("Future cost: " + currentNode.getEstimatedCostToGoal());
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

