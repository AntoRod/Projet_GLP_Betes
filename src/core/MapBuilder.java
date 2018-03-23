package core;

import data.Beast;
import data.Biome;
import data.Location;
import data.Tile;
import gui.BeastPanel;
import gui.MapPanel;
import gui.Map_Settings;
import gui.TilePanel;

public class MapBuilder {
	
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
				int biomeNumber = Map_Settings.generateRand(1, 4);
				//obstacle (100/max) percent DEFAULT: 8
				int obstacle = Map_Settings.generateRand(1, 8);
				mapPanel.setTilePanel(i, j, biomeNumber);
				mapPanel.getTile(i, j).setLocation(new Location(i, j));
				//mapPanel.setTilePanel(i, j, biomeNumber, true);
				if (obstacle == 1) mapPanel.getTile(i, j).setObstacle(true);
				//System.out.println(mapPanel.getTile(i, j));
			}
		}
		return mapPanel;
	}
	
	
	public MapPanel setRandomBeasts(MapPanel mapPanel) {
		if(mapPanel.equals(null)) {
			this.setRandomMap(mapPanel);
		}	
		for(int i=0;i<Map_Settings.nbBeasts;i++) {
			int A = i*100/5;
			int absciss = Map_Settings.generateRand(1,30);
			int ordinate = Map_Settings.generateRand(1,30);
			Location loc = new Location(absciss, ordinate);
			BeastPanel beastPanel = new BeastPanel(new Beast(loc));
			mapPanel.getBeastPanel().add(beastPanel);
			//System.out.println(mapPanel.getBeast(i));
			//System.out.println(A+" ABSCISS: "+absciss+" ORDINATE: "+ordinate+"\n");
		}
		return mapPanel;
	}

	/*for(int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for(int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				for(int h=0;h<Map_Settings.nbBeasts;h++) {
					if(mapPanel.getTile(i, j).getAbsciss()==mapPanel.getBeast(h).getAbsciss()) {
						if(mapPanel.getTile(i, j).getOrdinate()==mapPanel.getBeast(h).getOrdinate()) {
							Location loc = new Location(10,10);
							
							System.out.println("test numéro "+h+"\n");
							
						}
					}
				}
			}*/
}
