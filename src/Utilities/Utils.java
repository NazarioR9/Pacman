package Utilities;

import java.awt.Dimension;
import java.awt.Point;

public class Utils {
	public static int[][] clone2DMatrix(int[][] mat){
		int x = mat.length;
		int y = mat[0].length;
		int[][] clone = new int[x][y];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				clone[i][j] = mat[i][j];
			}
		}
		return clone;
	}
	
	public static Point clonePoint(Point p){
		return new Point(p.x, p.y);
	}
	
	public static Dimension cloneDimension(Dimension d, int w, int h){
		return new Dimension(d.width+w, d.height+h);
	}
	
	
	
}
