package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import data.Case;
import data.Location;
import data.Map;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1583215278207488654L;
	private Map map = new Map();
	
	

	
	public void paintComponent(Graphics g){
		map.setTestMap();
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				g.setColor(map.getCase(i, j).getBiome().getColor());
				g.fillRect(0, 0, MapParameters.CASE_WIDTH, MapParameters.CASE_WIDTH);	
			}
		}

	}  

}
