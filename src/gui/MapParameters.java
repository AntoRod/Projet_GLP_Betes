package gui;

import java.awt.Color;
import java.awt.Dimension;

public class MapParameters {
	
	//ALL GUI PARAMETERS
	public static final int MAP_WIDTH = 30;
	public static final int CASE_WIDTH = 32;
	public static final int GUI_SIZE = MAP_WIDTH*CASE_WIDTH;
	public static final Dimension CASE_DIMENSION = new Dimension(CASE_WIDTH*MAP_WIDTH,CASE_WIDTH*MAP_WIDTH);
	
	
	
	//ALL BIOME PARAMETERS
	
	//BIOME COLOR PARAMETERS
	public static final Color PlainsColor = new Color(64,139,80);
	public static final Color DeadColor = new Color(192,138,45);
	public static final Color MountainColor = new Color(224,226,253);
	public static final Color DesertColor = new Color(205,189,68);
	//BIOME TYPE PARAMETERS
	public static final String PlainsName = "Plains";
	public static final String DeadName = "DeadNature";
	public static final String MountainName = "Mountain";
	public static final String DesertName = "Desert";
	
	public static int generateRand(int minimum, int maximum) {
		int number = minimum + (int)(Math.random() * ((maximum - minimum) + minimum));
		return number;
	}
	
	
}
