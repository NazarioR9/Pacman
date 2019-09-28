package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Drawer extends JPanel{
	private Structure structure = new Structure();
	private Block block = new Block();
	private Point pacmanPoint = new Point();
	private List<Block> blocks = new ArrayList<>();
	//private Color[] colors = {Color.orange, Color.white, Color.green};
	private int width = 800;
	private int height = 350;
	private int s = block.getSize();
	private int nw = width/s;
	private int nh = height/s;
	
	public Drawer() {
		for(int i = 0; i < width; i+=s) {
			for(int j = 0; j < height; j+=s) {
				Color c = Color.white;
				if(i*j == 0 || i == (width-s) || j == (height-s)) {c = Color.orange;}
				blocks.add(new Block(new Point(i,j), c));
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(Block b: blocks) {
			g.setColor(b.getColor());
			g.fillRect(b.getPoint().x, b.getPoint().y, b.getSize(), b.getSize());
		}
		
		g.setColor(Color.black);
		
		for(int i = 1; i <= nw; i++) {
			g.drawLine(i*s, 0, i*s, height);
		}
		for(int i = 1; i <= nh; i++) {
			g.drawLine(0, i*s, width, i*s);
		}
		
		//Draw the structure
		structure.drawStrucure(g, s);
		//Draw the pacman
		g.setColor(Color.blue);
		g.fillOval(pacmanPoint.x, pacmanPoint.y, s, s);
		
	
	}
	
	public List<Block> getBlocks() {
		return blocks;
	}
	public int getBlockSize() {
		return s;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void setPacmanPoint(Point p) {
		pacmanPoint = p;
	}
	
}