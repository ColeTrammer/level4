package shape.drawer;

import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Shape {
	
	public Ellipse(int startX, int startY, Color c) {
		super(startX, startY, c);
	}

	@Override
	public void draw(Graphics g) {
		g.fillOval(startX, startY, mouseX - startX, mouseY - startY);
	}

}
