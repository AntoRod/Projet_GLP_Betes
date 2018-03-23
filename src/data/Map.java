package data;

import java.util.ArrayList;

import gui.Map_Settings;

public class Map {
	
	private Tile[][] map = new Tile[Map_Settings.MAP_WIDTH][Map_Settings.MAP_LENGTH];
	private Beast[] beasts = new Beast[Map_Settings.nbBeasts];
	
	
	public void setTiles (Tile[][] mapTile) {
		map = mapTile;
	}
	/*public void setBeasts () {
		for(int i=0;i<Map_Settings.nbBeasts;i++) {
			int random = Map_Settings.generateRand(i*100/Map_Settings.BEAST_PERCENT,i*100/Map_Settings.BEAST_PERCENT+20);
			beasts[i] = new Beast(new Location(random));
		}
		
	}*/
	
	public void setDefaultTiles() {
		for(int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for(int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				map[i][j] = new Tile();
			}
		}
	}
	public void setTestMap() {
		for(int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for(int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				int testNumber = 1;
				map[i][j] = new Tile(testNumber);
				
			}
		}
	}
	
	public void setTile(int absciss, int ordinate) {
		int testNumber = Map_Settings.generateRand(1,1);
		int testNumber2 = Map_Settings.generateRand(1,10);
		map[absciss][ordinate] = new Tile(testNumber);
		if(testNumber2 == 1) map[absciss][ordinate].setObstacle(true);
	}
	
	public Tile[][] getMap() {
		return	map;
	}
	public Tile getTile(int x, int y) {
		return map[x][y];
	}
	public Beast[] getBeasts() {
		return beasts;
	}
	public Beast getBeastNumber(int beastNumber) {
		return beasts[beastNumber];
	}
	
	
}