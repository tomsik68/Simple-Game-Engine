package sk.tomsik68.sge;

import java.awt.Point;


public class GuiSprite extends Sprite{
	public GuiSprite(){
		
	}
	public void onClick(){
		
	}
	@Override
	public void update(Game game) {
		//GUIs don't usually have velocity...
		if(game.getInput().isMousePressed(1) && contains(new Point(game.getInput().getMouseX(),game.getInput().getMouseY()))){
			onClick();
		}
		
	}
	public boolean contains(Point pt){
		return false;
	}
}
