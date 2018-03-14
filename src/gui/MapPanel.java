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

import data.Tile;
import data.Location;
import data.Map;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1583215278207488654L;
	private Map map = new Map();
	private int mapAbsciss;
	private int mapOrdinate;
	Image image = null;
	
	public MapPanel(int absciss, int ordinate) throws IOException{
		mapAbsciss = absciss;
		mapOrdinate = ordinate;
		map.setTile(absciss, ordinate);
	}

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	//	g.setColor(map.getTile(mapAbsciss, mapOrdinate).getBiome().getColor());
	//	g.fillRect(0, 0, MapParameters.CASE_WIDTH, MapParameters.CASE_WIDTH);
		image = this.analyzeTile(map.getTile(mapAbsciss, mapOrdinate));
		g.drawImage(image, 0, 0, this);
	}
	
	
	
	public Image analyzeTile(Tile tile) {
		Image tileImage = null;
		String imagePath = "assets/tiles/";
		int imageNumber = MapParameters.generateRand(1, 8);
		imagePath+=tile.getBiome().getBiomeType();
		if(tile.isObstacle()) imagePath+="_Obstacle";
		imagePath+="_"+imageNumber+".jpg";
		System.out.println(imagePath);
		tileImage = Toolkit.getDefaultToolkit().getImage(imagePath);
		
		return tileImage;		
			
	/*		
			else if(tile.getBiome().getBiomeType().equals(MapParameters.DeadName)) {
				tileImage = Toolkit.getDefaultToolkit().getImage("assets/tiles/dead_3.jpg");
			}
			else if(tile.getBiome().getBiomeType().equals(MapParameters.MountainName)) {
				tileImage = Toolkit.getDefaultToolkit().getImage("assets/tiles/snow_obstacle_1.jpg");
			}
			else if(tile.getBiome().getBiomeType().equals(MapParameters.DesertName)) {
				tileImage = Toolkit.getDefaultToolkit().getImage("assets/tiles/sand_obstacle_1.jpg");
			}
			else return null;
		}
		
		else {
			if(tile.getBiome().getBiomeType().equals(MapParameters.PlainsName)) {
				tileImage = Toolkit.getDefaultToolkit().getImage("assets/tiles/grass_1.jpg");
			}
			else if(tile.getBiome().getBiomeType().equals(MapParameters.DeadName)) {
				tileImage = Toolkit.getDefaultToolkit().getImage("assets/tiles/dead_1.jpg");
			}
			else if(tile.getBiome().getBiomeType().equals(MapParameters.MountainName)) {
				tileImage = Toolkit.getDefaultToolkit().getImage("assets/tiles/snow_1.jpg");
			}
			else if(tile.getBiome().getBiomeType().equals(MapParameters.DesertName)) {
				tileImage = Toolkit.getDefaultToolkit().getImage("assets/tiles/sand_1.jpg");
			}
			else return null;
		}
		
		
		*/

	}

}
