import java.util.Comparator;

/**
 * Created by Diogo on 30/11/2016.
 */
public class CostComparator implements Comparator<Node> {

    public int compare(Node node1, Node node2) {

        if (node1.getEstimatedCostToGoal() < node2.getEstimatedCostToGoal()) {
            return -1;
        }

        if (node1.getEstimatedCostToGoal() > node2.getEstimatedCostToGoal()) {
            return 1;
        }

        return 0;
    }


}

