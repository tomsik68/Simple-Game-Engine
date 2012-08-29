package sk.tomsik68.sge;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletAdapter implements GraphicsAdapter,ListenerAttachable{
    private Applet app;
    public AppletAdapter(Applet app){
        this.app = app;
    }
    @Override
    public void addListener(InputListener listener) {
        app.addKeyListener(listener);
        app.addMouseListener(listener);
        app.addMouseMotionListener(listener);
        app.addFocusListener(listener);
    }

    @Override
    public Graphics getGraphics() {
        return app.getGraphics();
    }

    @Override
    public int getWidth() {
        return app.getWidth();
    }

    @Override
    public int getHeight() {
        return app.getHeight();
    }

}
