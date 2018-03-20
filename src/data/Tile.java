package data;

import java.awt.Dimension;
import java.awt.Color;

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
		if (biomeNumber == 1) biome = new Biome(MapParameters.PlainsName);
		else if (biomeNumber == 2) biome = new Biome(MapParameters.DeadName);
		else if (biomeNumber == 3) biome = new Biome(MapParameters.MountainName);
		else if (biomeNumber == 4) biome = new Biome(MapParameters.DesertName);
	}
	public Tile(int biomeNumber, Boolean obstacle) {
		this(biomeNumber);
		obstacleType = true;
		}
	public void setObstacle(boolean variable) {
		obstacleType = variable;
	}
	public boolean isObstacle() {
		return obstacleType;
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
	

}