package shape.drawer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main implements MouseListener, MouseMotionListener {

	private JFrame frame;
	private JPanel panel;
	private JPanel controls;
	private JPanel screen;
	
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton rectB = new JRadioButton("rectangle");
	private JRadioButton ellipseB = new JRadioButton("ellipse");
	
	private JLabel redL = new JLabel("red: ");
	private JLabel greenL = new JLabel("green: ");
	private JLabel blueL = new JLabel("blue: ");
	
	private JTextField redI = new JTextField(2);
	private JTextField greenI = new JTextField(2);
	private JTextField blueI = new JTextField(2);
	
	private Color c = new Color(0, 0, 0);
	
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Shape current;
	private static final Dimension dimension = new Dimension(800, 800);
	
	public Main() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(dimension);
		
		panel = new JPanel();
		frame.add(panel);
		
		controls = new JPanel();
		controls.setPreferredSize(new Dimension(800, 200));
		panel.add(controls);
		
		controls.add(ellipseB);
		controls.add(rectB);
		bg.add(ellipseB);
		bg.add(rectB);
		bg.setSelected(ellipseB.getModel(), true);
		
		redI.setText("0");
		greenI.setText("0");
		blueI.setText("0");
		
		controls.add(redL);
		controls.add(redI);
		
		controls.add(greenL);
		controls.add(greenI);
		
		controls.add(blueL);
		controls.add(blueI);
		
		screen = new JPanel() {
			private static final long serialVersionUID = 4231276137713103083L;

			@Override
			public void paintComponent(Graphics g) {
				g.setColor(c);
				for (Shape s : shapes) {
					g.setColor(s.getColor());
					s.draw(g);
				}
				System.out.println("drawn");
			}
		};
		screen.addMouseListener(this);
		screen.addMouseMotionListener(this);
		screen.setPreferredSize(new Dimension(800, 600));
		panel.add(screen);
		
		frame.pack();
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		current.setMouseX(e.getX());
		current.setMouseY(e.getY());
		screen.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			int r = Integer.parseInt(redI.getText());
			int g = Integer.parseInt(greenI.getText());
			int b = Integer.parseInt(blueI.getText());
			
			c = new Color(r, g, b);
			
		} catch (Exception e_) {
			
		}
		
		if (ellipseB.isSelected()) {
			current = new Ellipse(e.getX(), e.getY(), c);
			shapes.add(current);
		} else if (rectB.isSelected()) {
			current = new Rectangle(e.getX(), e.getY(), c);
			shapes.add(current);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
