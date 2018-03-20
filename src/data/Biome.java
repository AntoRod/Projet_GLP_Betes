package data;

import java.awt.Color;

import gui.MapParameters;

public class Biome {
	
	private String biomeType;
	private Color biomeColor;
	
	public Biome() {
		biomeType = MapParameters.PlainsName;
		biomeColor = Color.GREEN;
	}
	public Biome(String biomeType) {
		this.biomeType = biomeType;
		if(biomeType.equals(MapParameters.PlainsName)) biomeColor = MapParameters.PlainsColor;
		else if(biomeType.equals(MapParameters.DeadName)) biomeColor = MapParameters.DeadColor;
		else if(biomeType.equals(MapParameters.MountainName)) biomeColor = MapParameters.MountainColor;
		else if(biomeType.equals(MapParameters.DesertName)) biomeColor = MapParameters.DesertColor;
	}
	public Biome(int biomeNumber) {
		if (biomeNumber == 1) this.setBiomeType(MapParameters.PlainsName);
		else if (biomeNumber == 2) this.setBiomeType(MapParameters.DeadName);
		else if (biomeNumber == 3) this.setBiomeType(MapParameters.MountainName);
		else if (biomeNumber == 4) this.setBiomeType(MapParameters.DesertName);
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
