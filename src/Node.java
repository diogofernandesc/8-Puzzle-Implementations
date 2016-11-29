/**
 * Created by Diogo on 29/11/2016.
 */
public class Node {

    String[] state;
    int agentIndex;

    public Node(String[] state, int agentIndex) {
        this.state = state;
        this.agentIndex = agentIndex;
    }

    public String[] getState() {
        return state;
    }

    public int getAgentIndex() {
        return agentIndex;
    }

}
