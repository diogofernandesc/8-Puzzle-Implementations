/**
 * Created by Diogo on 29/11/2016.
 */
public class Node {

    String[] state;
    int agentIndex;
    int depth;

    public Node(String[] state, int agentIndex) {
        this.state = state;
        this.agentIndex = agentIndex;
    }

    public Node(String[] state, int agentIndex, int depth) {
        this.state = state;
        this.agentIndex = agentIndex;
        this.depth = depth;
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

}
