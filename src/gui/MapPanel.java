package gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import data.Beast;
import data.Biome;
import data.Location;
import data.Tile;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1583215278207488654L;
	
	private TilePanel[][] mapPanel;
	private BeastPanel[] beastsPanel;
	
	public MapPanel() {
		mapPanel = new TilePanel[MapParameters.MAP_WIDTH][MapParameters.MAP_WIDTH];
		beastsPanel = new BeastPanel[MapParameters.nbBeasts];
		this.setDefaultMapPanel();
	}
	
	public void setDefaultMapPanel() {
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				mapPanel[i][j] = new TilePanel();
			}
		}
	}
	public void setRandomMapPanel() {
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				int biomeNumber = MapParameters.generateRand(1, 1);
				int obstacle = MapParameters.generateRand(1, 10);
				mapPanel[i][j] = new TilePanel(biomeNumber);
				if (obstacle == 1) mapPanel[i][j].getTile().setObstacle(true);
					//mapPanel[i][j] = new TilePanel(biomeNumber, true);
			}
		}
	}
	
	public void setMapImages() {
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				mapPanel[i][j].getTile().setLocation(new Location(i,j));
				mapPanel[i][j].setTileImage();
				//System.out.println("Map: "+mapPanel[i][j].getTile().getLocation());
				//System.out.println("Beast: "+beastsPanel[0].getBeast().getLocation());
			}
		}	
	}
	
	public void setRandomBeasts() {
		for(int i=0;i<MapParameters.nbBeasts;i++) {
			beastsPanel[i] = new BeastPanel();
			beastsPanel[i].getBeast().setDefaultBeast();
			beastsPanel[i].getBeast().setDefaultLocation(i);
			/*Location loc = beastsPanel[i].getBeast().getLocation();
			Biome biome = new Biome(MapParameters.generateRand(1,4));
			beastsPanel[i].setBeastImage(beastsPanel[i].getBeast(), biome);*/
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
	


	public TilePanel getTilePanel(int absciss, int ordinate) {
		return mapPanel[absciss][ordinate];
	}
	
	public Tile getTile(int absciss, int ordinate) {
		return mapPanel[absciss][ordinate].getTile();
	}
	
	public BeastPanel getBeastPanel(int beastNumber) {
		return beastsPanel[beastNumber];
	}
	
	public Beast getBeast(int beastNumber) {
		return beastsPanel[beastNumber].getBeast();
	}
	
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
