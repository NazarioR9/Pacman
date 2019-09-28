package Constantes;

import java.awt.Dimension;
import java.awt.Point;

public class Constante {
	private static Dimension DIMENSION = new Dimension(800,300);
	private static int BLOCK_SIZE = 10;
	private static Point DESIGN_START = new Point(6,5);
	private static Point VERSION_START = new Point(25,20);
	private static int NUMBER_OF_GHOST = 3;
	
	
	public static Dimension getDIMENSION() {
		return DIMENSION;
	}
	public  static Point getDESIGN_START() {
		return DESIGN_START;
	}
	public static Point getVERSION_START() {
		return VERSION_START;
	}
	public static int getNUMBER_OF_GHOST() {
		return NUMBER_OF_GHOST;
	}
	public static int getBLOCK_SIZE() {
		return BLOCK_SIZE;
	}
	

}
