package PacObject;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.List;

import PacObject.AbstractCharacter.Movement;

public class PacMan extends AbstractCharacter{
	private int life;
	private static Point START = new Point(700,330);
	

	public PacMan(List<Point> b) {
		point = START;
		movement = new Movement();
		state = State.NORMAL;
		velocity = 10;
		bounds = b;
		life = 3;
	}
	
	@Override
	public void move() {
		if(movement.getCurrent() == Direction.UP) point.y-=velocity;
		else if(movement.getCurrent() == Direction.DOWN) point.y+=velocity;
		else if(movement.getCurrent() == Direction.LEFT) point.x-=velocity;
		else if(movement.getCurrent() == Direction.RIGHT) point.x+=velocity;
		checkBounds();
	}
	
	public void addLife() {
		life++;
	}
	public void loseLife() {
		life--;
	}
	public void changeState(State s) {
		this.state = s;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public void getKey(int key) {
		if(key == KeyEvent.VK_UP) {this.movement.setNext(Direction.UP);}
		else if(key == KeyEvent.VK_DOWN) {this.movement.setNext(Direction.DOWN);}
		else if(key == KeyEvent.VK_LEFT) {this.movement.setNext(Direction.LEFT);}
		else if(key == KeyEvent.VK_RIGHT) {this.movement.setNext(Direction.RIGHT);}
		
		this.checkToChangeDirection();
		System.out.println(key);
	}
	
	public void checkBounds() {
		for(Point bound: this.bounds) {
			if(bound.equals(this.point)) {
				//this.setPoint(bound);
				this.movement.setCurrent(this.movement.getNext());
				this.movement.setNext(Direction.NONE);
				break;
			}
		}
	}

}
