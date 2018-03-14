package data;

import gui.MapParameters;

public class Map {
	
	private Tile[][] map = new Tile[MapParameters.MAP_WIDTH][MapParameters.MAP_WIDTH];

	
	
	public void setTiles (Tile[][] mapTile) {
		map = mapTile;
	}
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
				int testNumber = MapParameters.generateRand(1,4);
				map[i][j] = new Tile(testNumber);
				
			}
		}
	}
	
	public void setTile(int absciss, int ordinate) {
		int testNumber = MapParameters.generateRand(1,4);
		int testNumber2 = MapParameters.generateRand(1,2);
		map[absciss][ordinate] = new Tile(testNumber);
		if(testNumber2 == 1) map[absciss][ordinate].setObstacle(true);
	}
	
	
	public Tile[][] getMap() {
		return	map;
	}
	
	public Tile getTile(int x, int y) {
		return map[x][y];
	}
	
}