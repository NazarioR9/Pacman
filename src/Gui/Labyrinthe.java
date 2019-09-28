package Gui;
import PacObject.PacMan;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;


public class Labyrinthe {
	private JFrame frame = new JFrame();
	private Dimension dimension = new Dimension(800,380);
	protected static List<Point> bounds = new ArrayList<>();
	private Drawer drawer = new Drawer();
	private PacMan pacman = new PacMan(bounds);
	//private MouseListener mlistener = new MouseListener();
	/* JPanel and JFrame heights differs of 30 because JFrame uses a layout that 
	 * reduces/modify the size of JPanel so that it can fit in the JFrame.
	 *  Careful !!
	 */
	public KeyListener listener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			int key = e.getKeyCode();
			pacman.getKey(key);
		}
	};
	/*
	class MouseListener extends MouseInputAdapter{
		public void mouseClicked(MouseEvent e) {
			blocks.add(normalize(e.getPoint()));
			try {
				save("labyrintheDesigns");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		
		public Point normalize(Point p) {
			int x = -1; int y = -1;
			System.out.println("NORMALIZE");
			System.out.println(p.toString());
			int s = 10;
			for(int i=s; i < dimension.width; i+=s) {
				if(p.x <= i) {
					System.out.println(i);
					x = i;
					break;
				}
			}
			for(int j=s; j < dimension.height; j+=s) {
				if(p.y <= j) {
					System.out.println(j);
					y = j;
					break;
				}
			}
			return new Point(x,y);
		}
		
		public void save(String fileName) throws FileNotFoundException {
		    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
		    for (Point p : blocks)
		        pw.println(p.toString());
		    pw.close();
		}
	}*/
	
	public Labyrinthe() {
		frame.setTitle("Pacman");
		frame.setSize(dimension);
		frame.setLocation(300, 200);
		frame.setContentPane(drawer);
		frame.addKeyListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		drawer.setPacmanPoint(pacman.getPoint());
		
		for(int i = 0; i < drawer.getWidth(); i+=drawer.getBlockSize()) {
			bounds.add(new Point(i,0));
			bounds.add(new Point(i,drawer.getHeight()));
		}
		for(int i = 0; i < drawer.getHeight(); i+=drawer.getBlockSize()) {
			bounds.add(new Point(0,i));
			bounds.add(new Point(drawer.getWidth(),i));
		}
	}
	
	public void start() {
		pacman.move();
		drawer.setPacmanPoint(pacman.getPoint());
		drawer.repaint();
		//System.out.println(pacman.getPoint().toString());
	}

}
