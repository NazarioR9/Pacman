import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Constantes.Constante;
import Gui.Labyrinthe;
import PacObject.PacGhost;
import PacObject.PacMan;
import Utilities.State;
import Utilities.Utils;


public class PacmanGame {
	int score = 0;
	private PacMan pacman = new PacMan();
	private PacGhost[] ghosts = new PacGhost[Constante.NUMBER_OF_GHOST];
	private Color[] ghostColors = {Color.cyan, Color.darkGray, Color.pink, Color.red};
	private int[][] blocksMatrix;
	private int[][] gomesMatrix;
	Labyrinthe laby;
	public KeyListener listener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			int key = e.getKeyCode();
			pacman.getKey(key);
		}
	};
	
	public PacmanGame(){
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			ghosts[i] = new PacGhost( Utils.clonePoint(Constante.GHOSTS_START[i]), ghostColors[i]);
		}
		totalReset();
		laby = new Labyrinthe(Utils.clone2DMatrix(blocksMatrix), Utils.clone2DMatrix(gomesMatrix), listener,
				pacman, ghosts);
	}
	
	public void play() {
		while(!noMoreGomes() && !noMoreLife()) {
			pacman.manage();
			pacman.move();
			moveGhosts();
			manageGhosts();
			laby.setGhostsPoint(ghosts);
			laby.updateMaps(Utils.clone2DMatrix(blocksMatrix), Utils.clone2DMatrix(gomesMatrix));
			laby.show(pacman);
			updateAll();
			//printScore();
			sleep(250);
		}
		ask2Play("");
	}
	
	public void ask2Play(String msg) {
		String response = JOptionPane.showInputDialog(null, msg+"Play again ?\n y: yes  n: no");
		System.out.println("Response : " + response);
		if(response.equals("y")) {
			totalReset();
			play();
		}else if(response.equals("n")) {
			totalReset();
			//close window
		}else {
			ask2Play("Didn't get ypur response.\n");
		}
	}
	
	public void totalReset() {
		pacman.back2Start();
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			ghosts[i].back2Start();
		}
		blocksMatrix = Utils.clone2DMatrix(Constante.blocksMap);
		gomesMatrix = Utils.clone2DMatrix(Constante.gomeMap);
		pacman.setLife(Constante.PAC_START_LIFE);
	}
	
	public void partialReset() {
		pacman.back2Start();
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			ghosts[i].back2Start();
		}
		
	}
	
	public boolean noMoreGomes() {
		for(int i = 0; i < gomesMatrix.length; i++) {
			for(int j = 0; j < gomesMatrix[0].length; j++) {
				if(gomesMatrix[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	public boolean noMoreLife() {
		return pacman.getLife() <= 0;
	}
	
	public void updateGoneMatrix(int i, int j) {
		setGoneMatrixCell(i, j, 0);
	}
	
	public void updateAll() {
		int i = pacman.getMatrixPosition()[0], j = pacman.getMatrixPosition()[1];
		int v = getGoneMatrixCell(i,j);
		if(v != 0) {
			computeScore(v);
			updateGoneMatrix(i, j);
		}
		applyRules(i, j);
		
	}
	
	public void applyRules(int i, int j) {
		if(pacman.getState() == State.INVISIBLE) return;
		
		for(int n = 0; n < Constante.NUMBER_OF_GHOST; n++) {
			int k = ghosts[n].getMatrixPosition()[0], m = ghosts[n].getMatrixPosition()[1];
			if(i==k && j==m) {
				if(pacman.getState() == State.SUPER) {
					ghosts[n].startJailTimeContDown();
					System.out.println("Ghost " + n +" is in Jail");
				}else if(pacman.getState() == State.NORMAL) {
					System.out.println("Ghost " + n + "caught Pacman");
					pacman.loseLife();
					sleep(250);
					partialReset();
				}
			}
		}
	}
	
	public void computeScore(int v) {
		if(v == 1) {
			score += 100;
		}else if(v == 2) {
			score += 300;
			pacman.specialState(State.INVISIBLE);
			System.out.println("Invisible Pacman");
		}else if(v == 3) {
			score += 500;
			pacman.specialState(State.SUPER);
			slowdownGhosts();
			System.out.println("Super Pacman");
		}else if(v == 4) {
			score += 1000;
			//laby.changeLaby();
		}
		
		if(score >= 5000) pacman.addLife();
	}
	
	private int getGoneMatrixCell(int i, int j) {
		return gomesMatrix[j][i];
	}
	private void setGoneMatrixCell(int i, int j, int v) {
		gomesMatrix[j][i] = v;
	}
	
	public void moveGhosts() {
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			ghosts[i].move();
		}
	}
	
	public void slowdownGhosts() {
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			ghosts[i].slowdown();
		}
	}
	
	public void manageGhosts() {
		for(int i = 0; i < Constante.NUMBER_OF_GHOST; i++) {
			ghosts[i].manage();
		}
	}
	
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void printScore() {
		System.out.println("Your score : "+ score);
	}
}
