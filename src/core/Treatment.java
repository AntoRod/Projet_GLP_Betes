package core;

import gui.*;

import java.util.ArrayList;

import data.*;

public class Treatment {
	
	//the beast number of the beast that will fight/copulate
	private int firstBeast;
	private int secondBeast;
	private ArrayList<BeastPanel> beastsPanel;
	private int copulationTurn;
	
	public Treatment() {
		copulationTurn = 0;
	}
	

	
	public int analyseTile(TilePanel tilePanel, ArrayList<BeastPanel> beastPanel) {
		//save the panel temporarly
		beastsPanel = beastPanel;
		int beastPerTile = 0;
		int tileAbsciss = tilePanel.getTile().getAbsciss();
		int tileOrdinate = tilePanel.getTile().getOrdinate();
		int absciss = 0;
		int ordinate = 0;
		for(int i=0;i<Map_Settings.nbBeasts;i++) {
			if(beastPanel.get(i).getBeast().getStats().getStamina()<=0) {
				beastPanel.get(i).getBeast().setDeath(true);
			}
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
			if(!tilePanel.getTile().isFighting() && !tilePanel.getTile().isCopulating()) {
				//CHANCES IN PERCENT TO START A FIGHT (ELSE, START REPRODUCTION)
				int fightChances = 0;
				if(beastPanel.get(firstBeast).getBeast().getSexe().equals(beastPanel.get(secondBeast).getBeast().getSexe())) {
					fightChances = 100;
				}
				else {
					if(beastPanel.get(firstBeast).getBeast().getBiome().equals(beastPanel.get(secondBeast).getBeast().getBiome())) {
						fightChances = 40;
					}
					else {fightChances = 60;}
				}
				//THE REAL CHANCE VARIABLE
				int chances = Map_Settings.generateRand(1,100);
				if(chances<=fightChances) {
					tilePanel.getTile().setFight(true);
					beastPanel.get(firstBeast).getBeast().setFight(true);
					beastPanel.get(secondBeast).getBeast().setFight(true);
				}
				else {
					tilePanel.getTile().setCopulation(true);
					beastPanel.get(firstBeast).getBeast().setCopulation(true);
					beastPanel.get(secondBeast).getBeast().setCopulation(true);
				}
			}
			else {
				//THIS METHOD DO A TURN OF FIGHT (beast, beast, tile)
				if(tilePanel.getTile().isFighting()) turnFight(beastPanel.get(firstBeast).getBeast(), beastPanel.get(secondBeast).getBeast(), tilePanel.getTile());
				//THIS METHOD INITIALIZE THE COPULATION
				else if(tilePanel.getTile().isCopulating()) {
					launchCopulation(beastPanel.get(firstBeast).getBeast(), beastPanel.get(secondBeast).getBeast(), tilePanel.getTile());
				}
			}
			
			
		}
		//recover the updated panel
		beastPanel = beastsPanel;
		return beastPerTile;
	}
	
	//THIS LAST ONLY ONE TURN
	public void launchCopulation(Beast beastOne, Beast beastTwo, Tile tile) {
		
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//WHEN TWO BEASTS ARE COPULATING, PARENTS DIES
		beastOne.removeStamina(5);
		beastTwo.removeStamina(5);
		Boolean mutating = Map_Settings.randomBoolean();
		Beast babyBeast = null;;
		if(copulationTurn == 0) {

			if(mutating) babyBeast = new Beast(beastOne, beastTwo);
			else babyBeast = new Beast(beastOne.getLocation(), tile.getBiome());
			babyBeast.setNumber(Map_Settings.nbBeasts);
			BeastPanel babyBeastPanel = new BeastPanel(babyBeast);
			babyBeastPanel.setBeastImage();
			beastsPanel.add(Map_Settings.nbBeasts, babyBeastPanel);
			Map_Settings.incrementNbBeasts();
			copulationTurn++;
		}
		else {
			copulationTurn = 0;
			tile.setCopulation(false);
			beastOne.setDeath(true);
			beastTwo.setDeath(true);
//			System.out.println("Copulation Ended\n");
		}


	}
	
	public void turnFight(Beast beastOne, Beast beastTwo, Tile tile) {
		Biome tileBiome = new Biome(tile.getBiome().getBiomeType());
		Attack attackOne = beastOne.getStats().getAttack();
		Defense defenseOne =  beastOne.getStats().getDefense();
		Defense defenseTwo = beastTwo.getStats().getDefense();
		Attack attackTwo = beastTwo.getStats().getAttack();
		
		//ATTACK OF THE BEAST ONE
		if(Map_Settings.SIMULATION_TURNS%2==0) {
			beastOne.removeStamina(5);
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
			beastTwo.removeStamina(5);
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
			beastTwo.setFight(false);
			beastTwo.setMove(true);
			tile.setFight(false);
//			System.out.println("Fight ended\n");
		}
		if(beastTwo.getStats().getlivePoints()<0) {
			beastTwo.setDeath(true);
			beastOne.setFight(false);
			beastOne.setMove(true);
			tile.setFight(false);
//			System.out.println("Fight ended\n");
		}
	}
	
	public void eatFood(Beast beast, Food food, Tile tile) {
		Stats beastStats = beast.getStats();
		int foodRemove = 0;
		if(beastStats.getlivePoints()<beastStats.getMaxLife()) {
			foodRemove = (int) (beastStats.getMaxLife()-beastStats.getlivePoints());
			food.removeFoodValue(foodRemove);
			beast.getStats().setlivePoints(beastStats.getMaxLife());
			beast.getStats().setStamina(beastStats.getMaxStamina());
		}
		else {
			if(beastStats.getStamina()<beastStats.getMaxStamina()) {
				foodRemove = (int) (beastStats.getMaxStamina()-beastStats.getStamina());
				food.removeFoodValue(foodRemove);
				beast.getStats().setStamina(beastStats.getMaxStamina());
			}
		}
		if(food.getFoodValue()<0) tile.setFood(false);
	}
	
	
	
	
	
	
	
	
	


}
