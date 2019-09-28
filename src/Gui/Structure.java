package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Gui.Transformers.Mapper;
import Gui.Shapes;

public class Structure {
	private Point START = new Point(6,5);
	private Point VSTART = new Point(25,20);
	private List<String> design = new ArrayList<>(List.of("P", "A", "C", "M", "A", "N"));
	private Transformers transformer = new Transformers();
	List<Mapper> customMap = new ArrayList<>();
	
	public Structure() {
		updateDesign(design);
	}
	public Structure(List<String> d) {
		design = d;
		updateDesign(d);
	}
	
	public void updateDesign(List<String> d) {
		for(String l: d) {
			for(Mapper map: transformer.getMapping()) {
				if(l.equals(map.letter)) customMap.add(map);
			}
		}
	}
	
	public void drawDesigns(Graphics g, Point start, List<Mapper> maps, int size) {
		Point first = new Point(start.x, start.y);
		for(Mapper map: maps) {
			Point p = new Point(first.x, first.y);
			System.out.println("Drawing letter : '"+map.letter+"'");
			for(Shapes sh: map.getShapes()) {
				p = new Point(p.x+sh.getXplus(), p.y+sh.getYplus());
				drawLines( g,  sh,  p, size);
			}
			first = new Point(p.x+map.getAdd(), first.y);
		}
	}
	
	public void drawLines(Graphics g, Shapes sh, Point p, int size) {
		if(sh.getLines() == Lines.VERTICAL) {
			drawBlocks(g, p, sh.getNbMin(), sh.getNbMax(), size);
		}else if(sh.getLines() == Lines.HORIZONTAL) {
			drawBlocks(g, p, sh.getNbMax(), sh.getNbMin(), size);
		}else if(sh.getLines() == Lines.TWO_VERTICAL) {
			drawBlocks(g, p, sh.getNbMin(), sh.getNbMax(), size);
			Point x = new Point(p.x+sh.getNbMin()+sh.getInBetween(), p.y);
			drawBlocks(g, x, sh.getNbMin(), sh.getNbMax(), size);
		}else if(sh.getLines() == Lines.TWO_HORIZONTAL) {
			drawBlocks(g, p, sh.getNbMax(), sh.getNbMin(), size);
			Point x  = new Point(p.x, p.y+sh.getNbMin()+sh.getInBetween());
			drawBlocks(g, x, sh.getNbMax(), sh.getNbMin(), size);
		}
	}
	
	public void drawBlocks(Graphics g, Point p, int w, int h, int size) {
		g.fillRect(p.x*size, p.y*size, w*size, h*size);
	}
	
	
	public void drawStrucure(Graphics g, int size) {
		g.setColor(Color.black);
		drawDesigns(g, START, customMap, size);
		drawDesigns(g, VSTART, transformer.getVersion(), size);
	}
	
	public void generateMatrix() {
		int[][] matrix = new int[2][2];
	}
	
}

