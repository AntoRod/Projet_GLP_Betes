package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import data.Case;
import data.Location;
import data.Map;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1583215278207488654L;
	private Map map = new Map();
	private int mapAbsciss;
	private int mapOrdinate;
	Image img = null;
	
	public MapPanel(int absciss, int ordinate) throws IOException{
		mapAbsciss = absciss;
		mapOrdinate=ordinate;
		map.setTile(absciss, ordinate);
	}

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(map.getCase(mapAbsciss, mapOrdinate).getBiome().getColor());
	//	g.fillRect(0, 0, MapParameters.CASE_WIDTH, MapParameters.CASE_WIDTH);
		img = Toolkit.getDefaultToolkit().getImage("assets/tiles/dead_1.jpg");
		g.drawImage(img, 0, 0, this);
	}

}
