package data;

import java.awt.Color;

public class Biome {
	
	private String biomeType;
	private Color biomeColor;
	
	public Biome() {
		biomeType = "Plains";
		biomeColor = Color.GREEN;
	}
	public Biome(String biomeType, Color biomeColor) {
		this.biomeType = biomeType;
		this.biomeColor = biomeColor;
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
