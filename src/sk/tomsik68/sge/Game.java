package sk.tomsik68.sge;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;



public abstract class Game implements Runnable {
	private ListenerAttachable canvas;
	protected final InputListener input;
	protected Graphics2D gfx;
	private BufferedImage backBuffer;
    private GraphicsAdapter graphics;

	public Game(ListenerAttachable canvas, GraphicsAdapter graphics){
		this.canvas = canvas;
		this.graphics = graphics;
		input = new InputListener();
	}
	protected int getMaxFPS() {
		return 80;
	}
	protected void init(){
		backBuffer = new BufferedImage(graphics.getWidth(), graphics.getHeight(), BufferedImage.TYPE_INT_RGB);
		gfx = backBuffer.createGraphics();
		canvas.addListener(input);
	}
	protected void render() {
	    graphics.getGraphics().drawImage(backBuffer,0,0,null);
		gfx.clearRect(0, 0, graphics.getWidth(), graphics.getHeight());
	}
	protected void update(){
	}
	public void start() {
		Thread gameThread = new Thread(this);
		gameThread.start();
	}
	public void tick(){
		render();
		update();
	}

	@Override
	public void run() {
		init();
		while (true) {
			long time = System.currentTimeMillis();
			tick();
			long now = System.currentTimeMillis();
			long elapsed = (now - time);
			long sleepTime = 1000 / getMaxFPS() - elapsed;
			try {
				if (sleepTime > 0){
					Thread.sleep(sleepTime);
					System.out.println("FPS: "+getMaxFPS());
				}else
				    System.out.println("FPS: "+1000/elapsed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public String getName() {
		return "SGE Game";
	}
	public Image getIcon(){
		return null;
	}
	public InputListener getInput(){
		return input;
	}

}
