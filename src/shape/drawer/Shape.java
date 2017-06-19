package shape.drawer;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	protected int startX;
	protected int startY;
	protected int mouseX;
	protected int mouseY;
	
	protected Color c;
	
	public Shape(int startX, int startY, Color c) {
		this.startX = startX;
		this.startY = startY;
		this.c = c;
	}
	
	public void setMouseX(int x) {
		mouseX = x;
	}
	
	public void setMouseY(int y) {
		mouseY = y;
	}
	
	public Color getColor() {
		return c;
	}
	
	public abstract void draw(Graphics g);
}
