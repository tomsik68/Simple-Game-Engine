package sk.tomsik68.sge;

import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

public class InputListener implements KeyListener,MouseListener,FocusListener,MouseMotionListener{
	private boolean[] keys = new boolean[65536];
	private boolean[] mouse = new boolean[4];
	private boolean focus = false;
	private Point mousePos = new Point(0,0);
	private boolean[] mousePressed = mouse;
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() < mouse.length)
			mouse[e.getButton()] = true;
		if(e.getButton() < mousePressed.length)
			mousePressed[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() < mouse.length)
			mouse[e.getButton()] = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < keys.length){
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < keys.length){
			keys[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public boolean isKeyDown(int key) {
		return keys[key];
	}

	@Override
	public void focusGained(FocusEvent e) {
		focus = true;
	}

	@Override
	public void focusLost(FocusEvent e) {
		focus = false;
	}

	/**
	 * @return the focus
	 */
	public boolean isFocused() {
		return focus;
	}

	public boolean isMouseDown(int btn) {
		return mouse[btn];
	}
	
	public int getMouseY() {
		return mousePos.y;
	}

	public int getMouseX() {
		return mousePos.x;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos = e.getPoint();
		Arrays.fill(mousePressed, false);
	}

	public boolean isMousePressed(int btn){
		return mousePressed[btn];
	}

}
