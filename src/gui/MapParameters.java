package gui;

import java.awt.Color;
import java.awt.Dimension;

public class MapParameters {
	
	public static final int GUI_SIZE = 960;
	
	public static final int MAP_WIDTH = 30;
	
	public static final int CASE_WIDTH = GUI_SIZE/MAP_WIDTH;
	
	public static final Dimension CASE_DIMENSION = new Dimension(CASE_WIDTH*MAP_WIDTH,CASE_WIDTH*MAP_WIDTH);
	
	public static final Color PlainsColor = new Color(64,139,80);
	
	public static final Color DeadColor = new Color(192,138,45);
	
	public static final Color MountainColor = new Color(224,226,253);
	
	public static final Color DesertColor = new Color(205,189,68);

}
