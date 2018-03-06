package gui;

import java.awt.Dimension;

public class MapParameters {
	
	public static final int GUI_SIZE = 960;
	
	public static final int MAP_WIDTH = 30;
	
	public static final int CASE_WIDTH = GUI_SIZE/MAP_WIDTH;
	
	public static final Dimension CASE_DIMENSION = new Dimension(CASE_WIDTH*MAP_WIDTH,CASE_WIDTH*MAP_WIDTH);

}
