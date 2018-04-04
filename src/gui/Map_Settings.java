package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class Map_Settings {
	
	/* MAP LENGTH: LONGUEUR
	 * MAP WIDTH: LARGEUR
	 * CASE WIDTH: LONGUEUR/LARGEUR D'UNE CASE (LAISSER A 32)
	 * GUI LENGTH: LONGUEUR TOTAL GUI 
	 * GUI WIDTH: LARGEUR TOTAL GUI
	 * GUI DIMENSION: RACCOURCI "PREFERED SIZE" PARAMETER
	 * 
	 * */
	
	//ALL GUI PARAMETERS
	public static int MAP_WIDTH = 30;
	public static int MAP_LENGTH = 30;
	public static final int CASE_WIDTH = 32;
	public static int GUI_LENGTH = MAP_WIDTH*CASE_WIDTH;
	public static int GUI_WIDTH = MAP_LENGTH*CASE_WIDTH+500;
	public static Dimension GUI_DIMENSION = new Dimension(GUI_WIDTH, GUI_LENGTH);
	public static Dimension MAP_DIMENSION = new Dimension(CASE_WIDTH*MAP_WIDTH,CASE_WIDTH*MAP_LENGTH);
	
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
	
	//ALL BEASTS PARAMETERS
	public static final String maleGender = "male";
	public static final String femaleGender = "female";
	public static final int BEAST_PERCENT = 5;
	public static int nbBeasts = 1;//(BEAST_PERCENT*MAP_WIDTH*MAP_WIDTH)/100;

	public static final String  Down = "down";
	public static final String Up = "up";
	public static final String Left = "left";
	public static final String Right= "right";
	
	//ALL GENERAL FUNCTIONS
	
	//GENERATE A RANDOM NUMBER BEETWIN A MIN AND A MAX (CAN BE EQUALS)
	public static int generateRand(int min, int max) {
		Random rand = new Random();
		int number = rand.nextInt(max - min + 1) + min;
		return number;
	}
	
	public static void setNbBeasts(int number) {
		float defaultNumber = (MAP_WIDTH*MAP_LENGTH)/100*5;
		if(number<=defaultNumber) {
			nbBeasts = number;
		}
		else {nbBeasts = (int)defaultNumber;}
	}
	
	public static void setMapWidth(int number) {
		int defaultWidth = 30;
		if(number<=defaultWidth) {
			MAP_WIDTH = number;
		}
		else {MAP_WIDTH = defaultWidth;}
		resetParameters();
	}
	public static void setMapLength(int number) {
		int defaultLength = 30;
		if(number<=defaultLength) {
			MAP_LENGTH = number;
		}
		else {MAP_LENGTH = defaultLength;}
		resetParameters();
	}
	
	public static void resetParameters() {
		GUI_LENGTH = MAP_WIDTH*CASE_WIDTH;
		GUI_WIDTH = MAP_LENGTH*CASE_WIDTH+500;
		GUI_DIMENSION = new Dimension(GUI_WIDTH, GUI_LENGTH);
		MAP_DIMENSION = new Dimension(CASE_WIDTH*MAP_WIDTH,CASE_WIDTH*MAP_LENGTH);
	}
	
}
