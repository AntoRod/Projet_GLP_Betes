package core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

import data.Beast;
import data.Biome;
import data.Location;
import data.Tile;
import gui.BeastPanel;
import gui.MapPanel;
import gui.Map_Settings;
import gui.TilePanel;

public class MapBuilder{
	
	MapPanel panel;
	Image tile = null;
	int biomeNumber = Map_Settings.generateRand(1,1);
	public MapBuilder(MapPanel mapPanel) {
		panel = mapPanel;
	}
	public MapBuilder() {
		
	}
	
	//SET A MAP PANEL WITH RANDOM BIOMES
	public MapPanel setRandomMap(MapPanel mapPanel) {
		if(mapPanel.equals(null)) {
			mapPanel = new MapPanel();	
		}
		for(int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for(int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				//terrain variant number (1->4)
				if(i<(Map_Settings.MAP_WIDTH)/2 && j<(Map_Settings.MAP_WIDTH)/2) {
					biomeNumber = 2;
				}
				else  if(i<(Map_Settings.MAP_WIDTH)/2 && j>(Map_Settings.MAP_WIDTH)/2){
					biomeNumber = 1;
				}
				else  if(i>(Map_Settings.MAP_WIDTH)/2 && j>(Map_Settings.MAP_WIDTH)/2){
					biomeNumber = 3;
				}
				else  if(i>(Map_Settings.MAP_WIDTH)/2 && j<(Map_Settings.MAP_WIDTH)/2){
					biomeNumber = 4;
				}
				//obstacle (100/max) percent DEFAULT: 8
				int obstacle = Map_Settings.generateRand(1, 100);
				mapPanel.setTilePanel(i, j, biomeNumber);
				mapPanel.getTile(i, j).setLocation(new Location(i, j));
				//mapPanel.setTilePanel(i, j, biomeNumber, true);
				if (obstacle == 1) mapPanel.getTile(i, j).setObstacle(true);
				//System.out.println(mapPanel.getTile(i, j));
			}
		}
		return mapPanel;
	}
	
	
	public MapPanel setTileImages (MapPanel mapPanel) {
		for(int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for(int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				mapPanel.getTilePanel(i, j).setTileImage();
			}
		}
		
		
		
		return mapPanel;
	}
	
	
	public MapPanel setRandomBeasts(MapPanel mapPanel) {
		if(mapPanel.equals(null)) {
			this.setRandomMap(mapPanel);
		}	
		for(int i=0;i<Map_Settings.nbBeasts;i++) {
			int A = i*100/Map_Settings.BEAST_PERCENT;
			int tile = Map_Settings.generateRand(A,  A+(100/Map_Settings.BEAST_PERCENT));
			int absciss = tile/Map_Settings.MAP_WIDTH;
			int ordinate = tile%Map_Settings.MAP_LENGTH;
			Location loc = new Location(absciss, ordinate);
			Biome tileBiome = mapPanel.getTile(absciss, ordinate).getBiome();
			BeastPanel beastPanel = new BeastPanel(new Beast(loc, tileBiome));
			beastPanel.getBeast().setNumber(i);
			mapPanel.getBeastPanel().add(beastPanel);
			//System.out.println(mapPanel.getBeast(i));
//			System.out.println(tile+" ABSCISS: "+absciss+" ORDINATE: "+ordinate+"\n");
		}
		return mapPanel;
	}
	
	public MapPanel setBeastImages(MapPanel mapPanel) {
		if(mapPanel.equals(null)) {
			this.setRandomBeasts(mapPanel);
		}
		for(int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for(int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				for(int h=0;h<Map_Settings.nbBeasts;h++) {
					int absciss = mapPanel.getBeast(h).getAbsciss();
					int ordinate = mapPanel.getBeast(h).getOrdinate();
					if(absciss==mapPanel.getTile(i, j).getAbsciss() && ordinate==mapPanel.getTile(i, j).getOrdinate()) {
						Image beastImage = mapPanel.getBeastPanel().get(h).getBeastImage();
						mapPanel.getTilePanel(i, j).setBeastImage(beastImage);
					}
				}
			}
		}
		return mapPanel;
	}
}
