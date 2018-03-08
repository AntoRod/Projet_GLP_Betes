package data;

import java.awt.Color;

import gui.MapParameters;

public class Biome {
	
	private String biomeType;
	private Color biomeColor;
	
	public Biome() {
		biomeType = "Plains";
		biomeColor = Color.GREEN;
	}
	public Biome(String biomeType) {
		this.biomeType = biomeType;
		if(biomeType == "Plains") biomeColor=MapParameters.PlainsColor;
		if(biomeType == "DeadNature") biomeColor = MapParameters.DeadColor;
		if(biomeType == "Mountain") biomeColor = MapParameters.MountainColor;
		if(biomeType == "Desert") biomeColor = MapParameters.DesertColor;
	}
	
	public void setBiomeType( String biomeName) {
		biomeType = biomeName;
	}
	public void setColor(Color colorname) {
		biomeColor = colorname;
	}
	
	public Color getColor() {
		return biomeColor;
	}
	public String getBiomeType() {
		return biomeType;
	}
}
