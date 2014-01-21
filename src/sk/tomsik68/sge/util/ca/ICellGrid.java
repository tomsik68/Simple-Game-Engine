package sk.tomsik68.sge.util.ca;

public interface ICellGrid {
    public boolean isCellAlive(int x, int y);

    public void die(int x, int y);

    public void born(int x, int y);

    public int getWidth();

    public int getHeight();

    public void set(int x, int y, boolean alive);
}
