package data;

import java.awt.Dimension;
import java.awt.Color;

import gui.*;

public class Case {
	
	private boolean isObstacle;
	private Location location;
	private Biome biome;
	private Dimension dimension = MapParameters.CASE_DIMENSION;
	
	public Case() {
		biome = new Biome();
		isObstacle = false;
	}
	public Case(int biomeNumber) {
		if (biomeNumber == 1) biome = new Biome("Plains", Color.GREEN);
		else if (biomeNumber == 2) biome = new Biome("Forest", Color.BLUE);
		else if (biomeNumber == 3) biome = new Biome("Mountain", Color.WHITE);
		else if (biomeNumber == 4) biome = new Biome("Desert", Color.YELLOW);
	}

	public void setObstacle(boolean variable) {
		isObstacle = variable;
		
	}
	public boolean getObstacle() {
		return isObstacle;
	}
	public void setLocation(Location loc) {
		location = loc;
		
	}
	public void setBiome(String biomeName) {
		biome.setBiomeType(biomeName);
		if(biomeName == "Plains") biome.setColor(Color.GREEN);
		if(biomeName == "Forest") biome.setColor(Color.BLUE);
		if(biomeName == "Mountain") biome.setColor(Color.WHITE);
		if(biomeName == "Desert") biome.setColor(Color.YELLOW);
	}
	
	public Biome getBiome() {
		return biome;
	}
	public Location getLocation() {
		return location;
	}
	
	public Dimension getDimensions() {
		return dimension;
	}

}