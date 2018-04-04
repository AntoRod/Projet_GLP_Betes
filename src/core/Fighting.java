package core;

import gui.*;

import java.util.ArrayList;

import core.*;
import data.*;

public class Fighting {
	
	//the beast number of the beast that will fight
	private int beastNumberOne;
	private int beastNumberTwo;
	
	public Fighting() {
		
	}
	
	public int analyseTile(Tile tile, ArrayList<BeastPanel> beastPanel) {
		int beastPerTile = 0;
		int tileAbsciss = tile.getAbsciss();
		int tileOrdinate = tile.getOrdinate();
		int absciss = 0;
		int ordinate = 0;
		for(int i=0;i<Map_Settings.nbBeasts;i++) {
			absciss = beastPanel.get(i).getBeast().getAbsciss();
			ordinate = beastPanel.get(i).getBeast().getOrdinate();
			if(tileAbsciss==absciss && tileOrdinate==ordinate) {
//				System.out.println("Case : "+tile.getLocation()+" Beast: "+beastPanel.get(i).getBeast().getNumber()+"\n");
				beastPerTile++;
			}
		}
		if(beastPerTile>=2) {
			
			for(int i=0;i<Map_Settings.nbBeasts;i++) {
				absciss = beastPanel.get(i).getBeast().getAbsciss();
				ordinate = beastPanel.get(i).getBeast().getOrdinate();
				if(tileAbsciss==absciss && tileOrdinate==ordinate) {
					beastPanel.get(i).getBeast().setMove(false);
				}
			}
			tile.setFight(true);
		}
		return beastPerTile;
	}
	
	
	

}
