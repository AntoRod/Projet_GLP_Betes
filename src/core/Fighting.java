package core;

import gui.*;

import java.util.ArrayList;

import core.*;
import data.*;

public class Fighting {
	
	//the beast number of the beast that will fight
	private int firstBeast;
	private int secondBeast;
	
	public Fighting() {
	}
	

	
	public int analyseTile(TilePanel tilePanel, ArrayList<BeastPanel> beastPanel) {
		int beastPerTile = 0;
		int tileAbsciss = tilePanel.getTile().getAbsciss();
		int tileOrdinate = tilePanel.getTile().getOrdinate();
		int absciss = 0;
		int ordinate = 0;
		for(int i=0;i<Map_Settings.nbBeasts;i++) {
			absciss = beastPanel.get(i).getBeast().getAbsciss();
			ordinate = beastPanel.get(i).getBeast().getOrdinate();
			if(tileAbsciss==absciss && tileOrdinate==ordinate) {
//				System.out.println("Case : "+tile.getLocation()+" Beast: "+beastPanel.get(i).getBeast().getNumber()+"\n");
				if(beastPerTile==0) {
					tilePanel.setFirst(i);
					firstBeast = i;
				}
				else if(beastPerTile==1) {
					tilePanel.setSecond(i);
					secondBeast = i;
				}
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
			if(!tilePanel.getTile().isFighting()) tilePanel.getTile().setFight(true);
			//THIS METHOD DO A TURN OF FIGHT (beast, beast, tile)
			turnFight(beastPanel.get(firstBeast).getBeast(), beastPanel.get(secondBeast).getBeast(), tilePanel.getTile());
		}
		return beastPerTile;
	}
	
	public void turnFight(Beast beastOne, Beast beastTwo, Tile tile) {
		Biome tileBiome = new Biome(tile.getBiome().getBiomeType());
		Attack attackOne = beastOne.getStats().getAttack();
		Defense defenseOne =  beastOne.getStats().getDefense();
		Defense defenseTwo = beastTwo.getStats().getDefense();
		Attack attackTwo = beastTwo.getStats().getAttack();
		
		//ATTACK OF THE BEAST ONE
		if(Map_Settings.SIMULATION_TURNS%2==0) {
			if(tileBiome.equals(beastOne.getBiome())) {
				beastTwo.removeLive(attackOne, defenseTwo, true, false);
			}
			else {
				if(tileBiome.equals(beastTwo.getBiome())) {
					beastTwo.removeLive(attackOne, defenseTwo, false, true);
				}
				else {
					beastTwo.removeLive(attackOne,  defenseOne,  false,  false);
				}
				
			}
		}
		else if(Map_Settings.SIMULATION_TURNS%2==1) {
			//ATTACK OF THE BEAST TWO
			if(tileBiome.equals(beastTwo.getBiome())) {
				beastOne.removeLive(attackTwo, defenseOne, true, false);
			}
			else {
				if(tileBiome.equals(beastTwo.getBiome())) {
					beastOne.removeLive(attackTwo, defenseOne, false, true);
				}
				else {
					beastOne.removeLive(attackOne,  defenseOne,  false,  false);
				}
			}
		}
		
		if(beastOne.getStats().getlivePoints()<0) {
			beastOne.setDeath(true);
			beastTwo.setMove(true);
			tile.setFight(false);
		}
		if(beastTwo.getStats().getlivePoints()<0) {
			beastTwo.setDeath(true);
			beastOne.setMove(true);
			tile.setFight(false);
		}
	}


}
