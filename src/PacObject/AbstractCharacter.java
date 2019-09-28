package PacObject;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;

enum State{
	NORMAL,
	SUPER,
	WEAK;
}

enum Direction{
	NONE,
	UP,
	DOWN,
	LEFT,
	RIGHT;
}

public abstract class AbstractCharacter {
	protected Point point; //position on the map
	protected static List<Point> bounds = new ArrayList<>();
	protected Movement movement; //contains current and next position
	protected State state; //state of the object (normal, super, weak)
	protected int velocity;
	
	
	public abstract void move();
	
	public void checkToChangeDirection() {
		if(movement.getNext() != Direction.NONE) {
			movement.setCurrent(movement.getNext());
			movement.setNext(Direction.NONE);
		}
	}
	public void askToChangeDirection(Direction d) {
		movement.setNext(d);
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
	
	public Point getPoint() {
		return point;
	}
	public Movement getMovement() {
		return movement;
	}
	public State getState() {
		return state;
	}
	
	
	class Movement{
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
