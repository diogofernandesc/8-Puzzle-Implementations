
public class Starter {

    public static void main(String [] args) {
        Grid grid = new Grid(3, 3);
        grid.updateGrid(6, "A");
        grid.updateGrid(7, "B");
        grid.updateGrid(8, "☺");
        grid.printGrid();
    }
}
