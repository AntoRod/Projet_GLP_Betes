package data;

import java.awt.Color;

public class Biome {
	
	private String biomeType;
	private Color biomeColor;
	
	public Biome() {
		biomeType = "Plains";
		biomeColor = Color.GREEN;
	}
	public Biome(String biomeType) {
		this.biomeType = biomeType;
		if(biomeType == "Plains") biomeColor = new Color(64,139,80);
		if(biomeType == "DeadNature") biomeColor = new Color(192,138,45);
		if(biomeType == "Mountain") biomeColor = new Color(224,226,253);
		if(biomeType == "Desert") biomeColor = new Color(205,189,68);
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
