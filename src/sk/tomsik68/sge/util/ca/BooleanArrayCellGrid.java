package sk.tomsik68.sge.util.ca;

public class BooleanArrayCellGrid implements ICellGrid {
    private boolean[][] cells;
    private final int width;
    private final int height;

    public BooleanArrayCellGrid(int w, int h) {
        cells = new boolean[w][h];
        width = w;
        height = h;
    }

    @Override
    public boolean isCellAlive(int x, int y) {
        return cells[x][y];
    }

    @Override
    public void die(int x, int y) {
        set(x, y, false);
    }

    @Override
    public void born(int x, int y) {
        set(x, y, true);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void set(int x, int y, boolean alive) {
        cells[x][y] = alive;
    }
}
