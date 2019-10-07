package Constantes;
import java.awt.Dimension;
import java.awt.Point;

import Utilities.Utils;

public class Constante {
	public static final Dimension DIMENSION = new Dimension(768,504);
	public static final int BLOCK_SIZE = 24;
	public static final int UNIT = 30; //duration of a special state
	public static final int JAIL_TIME_UNIT = UNIT/3;
	public static final int STD_VELOCITY = 24;
	public static final int SLOW_VELOCITY = STD_VELOCITY; // have to divide by 2
	public static Point[] STATIC_WRAPAROUND = {
			new Point(-BLOCK_SIZE,10*BLOCK_SIZE),
			new Point(31*BLOCK_SIZE + BLOCK_SIZE, 10*BLOCK_SIZE)};
	public static Point[] DYNAMIC_WRAPAROUND = {
			new Point(0, 10*BLOCK_SIZE),
			new Point(31*BLOCK_SIZE, 10*BLOCK_SIZE)};
	public static Point PAC_START = new Point(26*BLOCK_SIZE, 19*BLOCK_SIZE);
	public static Point[] GHOSTS_START = new Point[]{
			new Point(15*BLOCK_SIZE, 9*BLOCK_SIZE),
			new Point(16*BLOCK_SIZE, 9*BLOCK_SIZE),
			new Point(15*BLOCK_SIZE, 10*BLOCK_SIZE),
			new Point(16*BLOCK_SIZE, 10*BLOCK_SIZE)};
	//public static final Point DESIGN_START = new Point(6,5);
	//public static final Point VERSION_START = new Point(25,20);
	public static final int NUMBER_OF_GHOST = 4;
	public static final int PAC_START_LIFE = 3;
	public static int[][] blocksMap =  {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,1,-1,-1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,-1,-1,1,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		    {0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,3,3,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
			{1,1,0,0,0,1,1,0,0,0,1,0,0,1,-1,-1,-1,-1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1,0,0,0,0,0,0,1,-1,-1,-1,-1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,1,0,0,1,0,0,0,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0,0,0,0,1,-1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,1,0,0,0,0,0,0,1,-1,-1,1,0,1,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
	public static int[][] gomeMap = buildGomeMap();
	
	@SuppressWarnings("finally")
	public static int[][] buildGomeMap() {
		int[][] map = Utils.clone2DMatrix(blocksMap);
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = (map[i][j] + 1) % 2;
			}
		}
		//Add specials gomes
		int[] x = new int[] {0, 1, 3, 12, 15, 17, 23, 31};
		int[] y = new int[] {0, 20, 20, 4, 20, 4, 12, 0};
		int[] v = new int[] {3, 4,  3,  3, 2,  3, 2, 3};
		
		for(int i = 0; i < v.length; i++) {
			map[y[i]][x[i]] = v[i];
		}
		
		return map;
	}
	
}
