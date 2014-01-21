package sk.tomsik68.sge.util.ca;

public class CellularAutomater {
    private static final boolean CELL_ITSELF_COUNTS = true;
    private final ICellGrid cells;
    private final CellularAutoRules rulz;

    public CellularAutomater(ICellGrid grid, CellularAutoRules r) {
        cells = grid;
        rulz = r;
    }

    public void setAll(boolean alive) {
        for (int x = 0; x < cells.getWidth(); ++x) {
            for (int y = 0; y < cells.getHeight(); ++y) {
                cells.set(x, y, alive);
            }
        }
    }

    public void nextGeneration() {
        for (int x = 0; x < cells.getWidth(); ++x) {
            for (int y = 0; y < cells.getHeight(); ++y) {
                int neighbours = getAliveNeighbourCount(x, y);
                rulz.changeCell(cells, x, y, neighbours);
            }
        }
    }

    private int getAliveNeighbourCount(int x, int y) {
        int aliveNeighbours = 0;
        if (x > 0 && y > 0 && cells.isCellAlive(x - 1, y - 1))
            aliveNeighbours++;
        if (y > 0 && cells.isCellAlive(x, y - 1))
            aliveNeighbours++;
        if (x < cells.getWidth() - 1 && y > 0 && cells.isCellAlive(x + 1, y - 1))
            aliveNeighbours++;
        if (x > 0 && cells.isCellAlive(x - 1, y))
            aliveNeighbours++;
        if (x < cells.getWidth() - 1 && cells.isCellAlive(x + 1, y))
            aliveNeighbours++;
        if (x > 0 && y < cells.getHeight() - 1 && cells.isCellAlive(x - 1, y + 1))
            aliveNeighbours++;
        if (y < cells.getHeight() - 1 && cells.isCellAlive(x, y + 1))
            aliveNeighbours++;
        if (x < cells.getWidth() - 1 && y < cells.getHeight() - 1 && cells.isCellAlive(x + 1, y + 1))
            aliveNeighbours++;
        if (cells.isCellAlive(x, y) && CELL_ITSELF_COUNTS)
            aliveNeighbours++;
        return aliveNeighbours;
    }
}
