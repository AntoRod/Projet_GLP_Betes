package gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.Beast;
import data.Biome;
import data.Location;
import data.Tile;

public class MapPanel {
	
	private TilePanel[][] tilesPanel;
	private ArrayList<BeastPanel> beastPanel;
	
	//default map width/length
	public MapPanel() {
		tilesPanel = new TilePanel[Map_Settings.MAP_WIDTH][Map_Settings.MAP_LENGTH];
		beastPanel = new ArrayList<BeastPanel>();
	}
	
	//choose the map width/length
	public MapPanel(int width, int length) {
		tilesPanel = new TilePanel[width][length];
		beastPanel = new ArrayList<BeastPanel>();
		
	}
	
	public void setTilePanel(int absciss, int ordinate, int biomeNumber) {
		tilesPanel[absciss][ordinate] = new TilePanel(biomeNumber);
	}
	public void setTilePanel(int absciss, int ordinate, int biomeNumber, boolean obstacle) {
		tilesPanel[absciss][ordinate] = new TilePanel(biomeNumber, obstacle);
	}
	
	public TilePanel getTilePanel(int absciss, int ordinate) {
		return tilesPanel[absciss][ordinate];
	}
	public Tile getTile(int absciss, int ordinate) {
		return tilesPanel[absciss][ordinate].getTile();
	}
	public ArrayList<BeastPanel> getBeastPanel() {
		return beastPanel;
	}
	public BeastPanel getBeastPanel(int beastNumber) {
		return beastPanel.get(beastNumber);
	}
	public Beast getBeast(int beastNumber) {
		return beastPanel.get(beastNumber).getBeast();
	}
	
	

}
