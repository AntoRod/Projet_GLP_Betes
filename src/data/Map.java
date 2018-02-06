package data;

public class Map {
	
	private Case[] map;
	private Biome biomes;

	
	
	public void setBoxes( Case[] mapCase) {
		map = mapCase;
	}
	
	
	public Case[] getCase() {
		return	map;
	}
	public void setBiome( Biome mapBiomes) {
		biomes = mapBiomes;
	}

	public Biome getBiome() {
		return biomes;
	}
}