package PacObject;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Constantes.Constante;
import Utilities.Direction;
import Utilities.State;
import Utilities.Utils;


public abstract class AbstractCharacter {
	protected Point point; //position on the map
	protected static List<Point> bounds = new ArrayList<>();
	protected Movement movement  = new Movement(); //contains current and next position
	protected State state; //state of the object (normal, super, weak)
	protected int velocity = Constante.STD_VELOCITY;
	protected Point START;
	protected Color color;
	protected Color baseColor;
	int unit = 0;
	
	
	public abstract void move();
	public abstract void manage();
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void checkToChangeDirection() {
		if(movement.getNext() != Direction.NONE) {
			movement.setCurrent(movement.getNext());
			movement.setNext(Direction.NONE);
		}
	}
	
	public void askToChangeDirection(Direction d) {
		movement.setNext(d);
	}
	
	public boolean checkBounds(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < Constante.DIMENSION.width) && (y < Constante.DIMENSION.height);
	}
	
	public boolean collision(int x, int y) {
		int i = x/Constante.BLOCK_SIZE;
		int j = y/Constante.BLOCK_SIZE;
		
		if(!checkBounds(x,y)) return true;
		
		if(Constante.blocksMap[j][i] == 0 || (Constante.blocksMap[j][i] != 1 && movement.getCurrent() == Direction.UP)) {
			return false;
		}
		
		return true;
	}
	
	public boolean wraparound(int x, int y) {
		for(int i = 0; i < 2; i++) {
			if(x == Constante.STATIC_WRAPAROUND[i].x && y == Constante.STATIC_WRAPAROUND[i].y) {
				point = Utils.clonePoint(Constante.DYNAMIC_WRAPAROUND[(i+1) % 2]);
				return true;
			}
		}
		return false;
	}
	
	public int[] getMatrixPosition() {
		return new int[]{point.x/Constante.BLOCK_SIZE, point.y/Constante.BLOCK_SIZE};
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void back2Start() {
		point = Utils.clonePoint(START);
	}
	public Movement getMovement() {
		return movement;
	}
	public State getState() {
		return state;
	}
	
	
	public void setPoint(Point p) {
		this.point = p;
	}
	public void setMovement(Movement m) {
		this.movement = m;
	}
	public void setState(State s) {
		this.state = s;
	}
	
	
	
	public class Movement{
		private Direction current;
		private Direction next;
		
		public Movement() {
			current = Direction.NONE;
			next = Direction.NONE;
		}
		
		public Direction getCurrent() {
			return current;
		}
		public Direction getNext() {
			return next;
		}
		
		public void setCurrent(Direction c) {
			this.current = c;
		}
		public void setNext(Direction n) {
			this.next = n;
		}
	}

}
