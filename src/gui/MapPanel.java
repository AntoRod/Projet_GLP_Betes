package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import data.Case;
import data.Location;
import data.Map;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1583215278207488654L;
	private Map map = new Map();
	private int mapAbsciss;
	private int mapOrdinate;
	private Image image = null;
	private String imagePath = "images/test.png";
	
	public MapPanel(int absciss, int ordinate) {
		mapAbsciss = absciss;
		mapOrdinate=ordinate;
		map.setTestMap();
	}

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(map.getCase(mapAbsciss, mapOrdinate).getBiome().getColor());
		g.fillRect(0, 0, MapParameters.CASE_WIDTH, MapParameters.CASE_WIDTH);
	}

}
