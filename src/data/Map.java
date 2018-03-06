package data;

import gui.MapParameters;

public class Map {
	
	private Case[][] map = new Case[MapParameters.MAP_WIDTH][MapParameters.MAP_WIDTH];

	
	
	public void setCases (Case[][] mapCase) {
		map = mapCase;
	}
	public void setDefaultCases() {
		for(int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for(int j=0;j<MapParameters.MAP_WIDTH;j++) {
				map[i][j] = new Case();
			}
		}
	}
	
	
	public Case[][] getMap() {
		return	map;
	}
	
	public Case getCase(int x, int y) {
		return map[x][y];
	}
	
}