package sk.tomsik68.sge;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

public class GameLoader {
	public static void loadGameInWindow(Class<? extends Game> gameClass,Frame frame,Canvas canvas,int width,int height) {
		Dimension size = new Dimension(width, height);
		frame.setSize(size);
		frame.setMinimumSize(size);
		frame.setMaximumSize(size);
		frame.setPreferredSize(size);
		Game game = null;
		try{
			game = gameClass.getConstructor(Canvas.class).newInstance(canvas);
		}catch(Exception e){
			e.printStackTrace();
		}
		frame.setVisible(true);
		frame.createBufferStrategy(2);
		frame.setTitle(game.getName());
		if(game.getIcon() != null)
			frame.setIconImage(game.getIcon());
		game.start();
	}
	public static void loadGame(Class<? extends Game> gameClass,int width,int height) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new BorderLayout());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size = new Dimension(width, height);
		frame.setSize(size);
		frame.setMinimumSize(size);
		frame.setMaximumSize(size);
		frame.setPreferredSize(size);
		Canvas canvas = new Canvas();
		frame.add(canvas);
		Game game = null;
		try{
			game = gameClass.getConstructor(Canvas.class).newInstance(canvas);
		}catch(Exception e){
			e.printStackTrace();
		}
		frame.setVisible(true);
		frame.createBufferStrategy(2);
		frame.setTitle(game.getName());
		if(game.getIcon() != null)
			frame.setIconImage(game.getIcon());
		game.start();
	}
	public static void loadApplet(Class<? extends Game> gameClass,int width,int height){
		Canvas canvas = new Canvas();
		Game game = null;
		try{
			game = gameClass.getConstructor(Canvas.class).newInstance(canvas);
		}catch(Exception e){
			e.printStackTrace();
		}
		Applet applet = new GameApplet(game);
		applet.add(canvas);
		applet.start();
	}
}
