package sk.tomsik68.sge;

import java.awt.Canvas;
import java.awt.Graphics;

public class CanvasAdapter implements ListenerAttachable, GraphicsAdapter{
    private final Canvas canvas;
    public CanvasAdapter(Canvas canvas){
        this.canvas = canvas;
    }
    @Override
    public void addListener(InputListener listener) {
        canvas.addKeyListener(listener);
        canvas.addMouseListener(listener);
        canvas.addFocusListener(listener);
        canvas.addMouseMotionListener(listener);
    }
    @Override
    public Graphics getGraphics() {
        return canvas.getGraphics();
    }
    @Override
    public int getWidth() {
        return canvas.getWidth();
    }
    @Override
    public int getHeight() {
        return canvas.getHeight();
    }

}
