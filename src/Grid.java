
public class Grid {

    int length;
    int width;
    String[] gridArray;

    public Grid(int length, int width) {
        this.length = length;
        this.width = width;
        int size = length * width;
        gridArray = new String[size];
        for(int i = 0; i < gridArray.length ; i++ ) {
            gridArray[i] = "□";
        }
    }

    public Grid(String[] startingState, int dimension) {
        gridArray = startingState;
        length = dimension;
        width = dimension;
    }


    protected void updateGrid(String[] newState) {
        gridArray = newState;
    }

    protected void printGrid() {
        int gridTile = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                System.out.print(" " + gridArray[gridTile] + " ");
                gridTile++;
            }
            System.out.println("\n");
        }
    }

//    protected void printGrid() {
//        for (int i = 0; i < gridArray.length ; i++) {
//
//        }
//    }
}
