package sk.tomsik68.sge;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Sprite {
	protected Point2D position,velocity;
	public Sprite(){
		position = new Point2D.Float(0,0);
		velocity = new Point2D.Float(0,0);
	}
	public void render(Graphics2D gfx){
		
	}
	public void update(Game game){
		position.setLocation(position.getX() + velocity.getX(), position.getY() + velocity.getY());
	}
	/**
	 * @return the position
	 */
	public Point2D getPosition() {
		return position;
	}
	/**
	 * @return the velocity
	 */
	public Point2D getVelocity() {
		return velocity;
	}
	public int getWidth(){
		return 0;
		
	}
	public int getHeight(){
		return 0;
		
	}
}
