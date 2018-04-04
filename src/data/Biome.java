package data;

import java.awt.Color;

import gui.Map_Settings;

public class Biome {
	
	private String biomeType;
	private Color biomeColor;
	
	public Biome() {
		biomeType = Map_Settings.PlainsName;
		biomeColor = Color.GREEN;
	}
	public Biome(String biomeType) {
		this.biomeType = biomeType;
		if(biomeType.equals(Map_Settings.PlainsName)) biomeColor = Map_Settings.PlainsColor;
		else if(biomeType.equals(Map_Settings.DeadName)) biomeColor = Map_Settings.DeadColor;
		else if(biomeType.equals(Map_Settings.MountainName)) biomeColor = Map_Settings.MountainColor;
		else if(biomeType.equals(Map_Settings.DesertName)) biomeColor = Map_Settings.DesertColor;
	
	}
	
	public Biome(int biomeNumber) {
		if (biomeNumber == 1) this.setBiomeType(Map_Settings.PlainsName);
		else if (biomeNumber == 2) this.setBiomeType(Map_Settings.DeadName);
		else if (biomeNumber == 3) this.setBiomeType(Map_Settings.MountainName);
		else if (biomeNumber == 4) this.setBiomeType(Map_Settings.DesertName);
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
