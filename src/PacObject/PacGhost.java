package PacObject;

import java.awt.Point;
import java.util.List;

public class PacGhost extends AbstractCharacter{
	private final Point JAIL_POINT = new Point();
	private final Point OUT_JAIL_POINT = new Point();
	private static Point START = new Point();
	
	public PacGhost(List<Point> b){
		bounds = b;
		point = START;
	}
	
	public void goToJail() {
		this.point = JAIL_POINT;
	}
	public void goOutJail() {
		this.point = OUT_JAIL_POINT;
	}
	public void startJailTimeContDown() {
		//TODO
	}
	public void SendSignalToReleaseFromJail() {
		//TODO
	}
	

	@Override
	public void move() {
		//TODO
	}
	
	
}
