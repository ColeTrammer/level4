package shape.drawer;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle(int startX, int startY, Color c) {
		super(startX, startY, c);
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(startX, startY, mouseX - startX, mouseY - startY);
	}

}
