package Gui;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Constantes.Constante;
import PacObject.PacGhost;
import PacObject.PacMan;


public class Labyrinthe {
	private JFrame frame = new JFrame();
	private Dimension dimension = new Dimension(768,534);
	private Drawer drawer;
	//private MouseListener mlistener = new MouseListener();
	/* JPanel and JFrame heights differs of 30 because JFrame uses a layout that 
	 * reduces/modify the size of JPanel so that it can fit in the JFrame.
	 *  Careful !!
	 */
	
	
	public Labyrinthe(int[][] b, int[][] g, KeyListener listener, PacMan pac, PacGhost[] ghosts) {
		drawer = new Drawer(b, g);
		
		frame.setTitle("Pacman");
		frame.setSize(dimension);
		frame.setLocation(300, 200);
		frame.setContentPane(drawer);
		frame.addKeyListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		setPacmanFeatures(pac);
		setGhostsPoint(ghosts);
	}
	
	public void setPacmanFeatures(PacMan pac) {
		drawer.setPacmanFeatures(pac);
	}
	
	public void show(PacMan pac) {
		setPacmanFeatures(pac);
		drawer.repaint();
	}
	
	public void updateMaps(int[][] b, int[][] g) {
		drawer.updateMaps(b, g);
	}
	
	public void setGhostsPoint(PacGhost[] ghosts) {
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			drawer.setPacghostPoint(i, ghosts[i].getPoint(), ghosts[i].getColor());
		}
	}

	public JFrame getFrame() {
		return frame;
	}
}
