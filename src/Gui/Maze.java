package Gui;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Constantes.Constante;
import PacObject.PacGhost;
import PacObject.PacMan;
import Utilities.Utils;


public class Maze {
	private JFrame frame = new JFrame();
	private Dimension dimension = Utils.cloneDimension(Constante.DIMENSION, 0, 30);
	private Drawer drawer;
	
	
	public Maze(int[][] b, int[][] g, KeyListener listener, PacMan pac, PacGhost[] ghosts) {
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
		sleep(150);
		drawer.repaint();
	}
	
	public void close() {
		frame.dispose();
	}
	
	public void updateMaps(int[][] b, int[][] g) {
		drawer.updateMaps(b, g);
	}
	
	public void setGhostsPoint(PacGhost[] ghosts) {
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			drawer.setPacghostPoint(i, ghosts[i].getPoint(), ghosts[i].getColor());
		}
	}
	
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
