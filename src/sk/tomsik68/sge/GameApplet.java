package sk.tomsik68.sge;

import java.applet.Applet;

public class GameApplet extends Applet {
	private static final long serialVersionUID = 6960665978815485492L;
	private final Game game;
	public GameApplet(Game game){
		super();
		this.game = game;
	}
	@Override
	public void init() {
		super.init();
		game.init();
	}
	@Override
	public void start() {
		super.start();
		game.start();
	}
	
}
