package data;

import java.util.ArrayList;

import gui.MapParameters;

public class Map {
	
	private Tile[][] map = new Tile[MapParameters.MAP_WIDTH][MapParameters.MAP_WIDTH];
	private Beast[] beasts = new Beast[MapParameters.nbBeasts];
	
	
	public void setTiles (Tile[][] mapTile) {
		map = mapTile;
	}
	/*public void setBeasts () {
		for(int i=0;i<MapParameters.nbBeasts;i++) {
			int random = MapParameters.generateRand(i*100/MapParameters.BEAST_PERCENT,i*100/MapParameters.BEAST_PERCENT+20);
			beasts[i] = new Beast(new Location(random));
		}
		
	}*/
	
	public void setDefaultTiles() {
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				map[i][j] = new Tile();
			}
		}
	}
	public void setTestMap() {
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				int testNumber = 1;
				map[i][j] = new Tile(testNumber);
				
			}
		}
	}
	
	public void setTile(int absciss, int ordinate) {
		int testNumber = MapParameters.generateRand(1,1);
		int testNumber2 = MapParameters.generateRand(1,10);
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