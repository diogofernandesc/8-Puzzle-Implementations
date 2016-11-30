/**
 * Created by Diogo on 29/11/2016.
 */
public class Node {

    String[] state;
    int agentIndex;
    int depth;
    int estimatedCostToGoal;
    Node parentNode;
    String direction;

    public Node(String[] state, int agentIndex) {
        this.state = state;
        this.agentIndex = agentIndex;
    }

    public Node(String[] state, int agentIndex, int depth, Node parentNode) {
        this.state = state;
        this.agentIndex = agentIndex;
        this.depth = depth;
        this.parentNode = parentNode;
    }

    public String[] getState() {
        return state;
    }

    public int getAgentIndex() {
        return agentIndex;
    }

    public int getDepth() {
        return depth;
    }

    public void setEstimatedCostToGoal(int estimatedCostToGoal) {
        this.estimatedCostToGoal = estimatedCostToGoal;
    }

    public int getEstimatedCostToGoal() {
        return estimatedCostToGoal;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Node getParentNode() {
        return parentNode;
    }
}
