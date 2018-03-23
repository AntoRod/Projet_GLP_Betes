package gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.Beast;
import data.Biome;
import data.Location;
import data.Tile;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1583215278207488654L;
	
	private TilePanel[][] tilesPanel;
	private ArrayList<BeastPanel> beastPanel;
	
	//default map width/length
	public MapPanel() {
		tilesPanel = new TilePanel[Map_Settings.MAP_WIDTH][Map_Settings.MAP_LENGTH];
		beastPanel = new ArrayList<BeastPanel>();
		
	}
	
	//choose the map width/length
	public MapPanel(int width, int length) {
		tilesPanel = new TilePanel[width][length];
		beastPanel = new ArrayList<BeastPanel>();
		
	}
	
	public void setTilePanel(int absciss, int ordinate, int biomeNumber) {
		tilesPanel[absciss][ordinate] = new TilePanel(biomeNumber);
	}
	public void setTilePanel(int absciss, int ordinate, int biomeNumber, boolean obstacle) {
		tilesPanel[absciss][ordinate] = new TilePanel(biomeNumber, obstacle);
	}
	
	public TilePanel getTilePanel(int absciss, int ordinate) {
		return tilesPanel[absciss][ordinate];
	}
	public Tile getTile(int absciss, int ordinate) {
		return tilesPanel[absciss][ordinate].getTile();
	}
	public ArrayList<BeastPanel> getBeastPanel() {
		return beastPanel;
	}
	public BeastPanel getBeastPanel(int beastNumber) {
		return beastPanel.get(beastNumber);
	}
	public Beast getBeast(int beastNumber) {
		return beastPanel.get(beastNumber).getBeast();
	}
	

	
	
	/*
	public void setDefaultMapPanel() {
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				mapPanel[i][j] = new TilePanel();
			}
		}
	}

	public void setRandomBeasts() {
		for(int i=0;i<MapParameters.nbBeasts;i++) {
			beastsPanel[i] = new BeastPanel();
			beastsPanel[i].getBeast().setDefaultBeast();
			beastsPanel[i].getBeast().setDefaultLocation(i);
			//Location loc = beastsPanel[i].getBeast().getLocation();
			//Biome biome = new Biome(MapParameters.generateRand(1,4));
			//beastsPanel[i].setBeastImage(beastsPanel[i].getBeast(), biome);
		}
	}
	
	public void setBeastsImages() {
		for(int h=0;h<MapParameters.nbBeasts;h++) {
			for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
				for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
					if(this.getTile(i, j).getLocation().getAbsciss()==this.getBeast(h).getLocation().getAbsciss()) {
						if(this.getTile(i, j).getLocation().getOrdinate()==this.getBeast(h).getLocation().getOrdinate()) {
							Location loc = beastsPanel[h].getBeast().getLocation();
							Biome biome = new Biome(mapPanel[i][j].getTile().getBiome().getBiomeType());
							
							this.getBeastPanel(h).setBeastImage(beastsPanel[i].getBeast(), biome);
							this.getTilePanel(i, j).addBeastImage(this.getBeastPanel(h).getBeastImage());
						
						}
					}
				}
			}
		}
	}
	*/



	
	
	
	
	
	
	/*
	public MapPanel(int absciss, int ordinate) throws IOException{
		mapAbsciss = absciss;
		mapOrdinate = ordinate;
		map.setTile(absciss, ordinate);

		if(absciss ==0 && ordinate ==0) {
			map.setBeasts();
		}

	}*/

	
	/*public void paintComponent(Graphics g){

		super.paintComponent(g);
		//mapTravel = new Location(mapAbsciss, mapOrdinate);
		tileImage = this.analyzeTile(map.getTile(mapAbsciss, mapOrdinate));
		g.drawImage(tileImage, 0, 0, this);
		//System.out.println("A: "+mapAbsciss+" B: "+mapOrdinate+"\n");
		Beast[] test = map.getBeasts();
		//if(map.getBeastNumber(beastNumber).getLocation().equals(new Location(mapAbsciss, mapOrdinate))) {
			//beastNumber++;
			//beastImage = Toolkit.getDefaultToolkit().getImage("assets/beasts/female_grass_down.png");
			//g.drawImage(beastImage,0,0,this);
			//System.out.println(beastNumber+"\n");
		//}

		
		
	}*/
	
	
	
/*	public Image analyzeTile(Tile tile) {
		Image tileImage = null;
		String imagePath = "assets/tiles/";
		int imageNumber = MapParameters.generateRand(1, 1);
		imagePath+=tile.getBiome().getBiomeType();
		if(tile.isObstacle()) imagePath+="_Obstacle";
		imagePath+="_"+imageNumber+".jpg";
		//System.out.println(imagePath);
		tileImage = Toolkit.getDefaultToolkit().getImage(imagePath);
		return tileImage;
	}*/

}
