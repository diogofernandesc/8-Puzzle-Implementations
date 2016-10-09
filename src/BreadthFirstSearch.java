import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    int tile;
    int startTitle;
    int goalTile;
    ArrayList<Integer> visitedTiles;
    Queue<Tile> tileQueue;

    public BreadthFirstSearch(int startTitle, int goalTile) {
        this.startTitle = startTitle;
        this.goalTile = goalTile;
        visitedTiles = new ArrayList<Integer>();
        tileQueue = new LinkedList<Tile>();


    }

}
