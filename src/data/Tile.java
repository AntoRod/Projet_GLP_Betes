package data;

import gui.*;

public class Tile {
	
	private boolean obstacleType;
	private Location location;
	private Biome biome;
	
	public Tile() {
		biome = new Biome();
		obstacleType = false;
	}
	public Tile(int biomeNumber) {
		if (biomeNumber == 1) biome = new Biome(Map_Settings.PlainsName);
		else if (biomeNumber == 2) biome = new Biome(Map_Settings.DeadName);
		else if (biomeNumber == 3) biome = new Biome(Map_Settings.MountainName);
		else if (biomeNumber == 4) biome = new Biome(Map_Settings.DesertName);
	}
	public Tile(int biomeNumber, Boolean obstacle) {
		this(biomeNumber);
		obstacleType = true;
		}
	public void setObstacle(boolean variable) {
		obstacleType = variable;
	}
	public void setLocation(Location loc) {
		location = loc;
	}
	public void setBiome(String biomeName) {
		biome.setBiomeType(biomeName);
	}
	
	public Biome getBiome() {
		return biome;
	}
	public Location getLocation() {
		return location;
	}
	public boolean isObstacle() {
		return obstacleType;
	}
	
	public int getAbsciss() {
		return location.getAbsciss();
	}
	public int getOrdinate() {
		return location.getOrdinate();
	}
	
	public String toString() {
		return "Location: ["+location.getAbsciss()+"]"+"["+location.getOrdinate()+"], Obstacle: "+obstacleType+", Biome: "+biome.getBiomeType()+"\n";
	}

}