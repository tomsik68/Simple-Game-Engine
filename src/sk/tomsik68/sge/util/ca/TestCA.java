    package sk.tomsik68.sge.util.ca;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class TestCA {
    private final int CELL_SIZE = 1;
    private final int CELL_WIDTH = CELL_SIZE, CELL_HEIGHT = CELL_SIZE;
    private final int WIDTH = 1280 / CELL_WIDTH, HEIGHT = 1024 / CELL_HEIGHT;
    private final int GENERATIONS = 50;
    private Graphics gfx;
    private ICellGrid grid = new BooleanArrayCellGrid(WIDTH, HEIGHT);
    private final CellularAutomater ca;
    private final Thread t;
    private int generation = 0;

    public TestCA() {
        ca = new CellularAutomater(grid, new CellularAutoRules() {
            @Override
            public void changeCell(ICellGrid grid, int x, int y, int neighbours) {
                if (grid.isCellAlive(x, y)) {
                    if (neighbours < 3) {
                        grid.die(x, y);
                    }
                } else {
                    if (neighbours > 5) {
                        grid.born(x, y);
                    }
                }
            }
        });
        createRandomGrid();
        t = new Thread() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    draw();
                    generation++;
                    if (generation > GENERATIONS) {
                        generation = 0;
                        createRandomGrid();
                    }
                    try {
                        Thread.sleep(50l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    nextGen();
                }
            }
        };
    }

    private void createRandomGrid() {
        Random random = new Random();
        final int count = 30;
        for(int x = 0;x<WIDTH;++x){
            for(int y = 0;y<HEIGHT;++y){
                grid.set(x, y, random.nextInt(100) > 55);
            }
        }
        /*
        ca.setAll(true);
        for (int i = 0; i < count; ++i) {
            int x = WIDTH / 2 + random.nextInt(WIDTH / 2) - random.nextInt(WIDTH / 2);
            int y = HEIGHT / 2 + random.nextInt(HEIGHT / 2) - random.nextInt(HEIGHT / 2);
            int sx = 15 + random.nextInt(10);
            int sy = 15 + random.nextInt(10);
            for (int j = x; j < x + sx && j < WIDTH; ++j) {
                for (int k = y; k < y + sy && k < HEIGHT; ++k) {
                    grid.set(j, k, random.nextInt(100) < 45);
                }
            }
        }*/
    }

    protected void draw() {
        for (int x = 0; x < WIDTH; ++x) {
            for (int y = 0; y < HEIGHT; ++y) {
                gfx.setColor(Color.WHITE);
                if (grid.isCellAlive(x, y)) {
                    gfx.setColor(Color.black);
                }
                gfx.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
            }
        }
    }

    protected void nextGen() {
        ca.nextGeneration();
    }

    public void start() {
        JFrame frame = new JFrame();
        Canvas c = new Canvas();
        frame.setDefaultCloseOperation(3);
        frame.setSize(1280, 1024);
        frame.add(c);
        frame.setVisible(true);
        c.createBufferStrategy(2);
        gfx = c.getGraphics();
        t.start();
    }

    public static void main(String[] args) {
        new TestCA().start();
    }
}
