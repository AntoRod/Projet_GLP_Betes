package core;

import data.Beast;
import data.Location;
import gui.*;

public class Moving {
	
	public Moving() {
	}
	
	
	public void Move(Beast beast, int direction) {
		int absciss = beast.getAbsciss();
		int ordinate = beast.getOrdinate();
		System.out.println("ANCIENT LOCATION: "+beast.getLocation());
		if(direction == 1) {
			beast.setLocation(new Location(absciss, ordinate+1));
		}
		if(direction == 2) {
			beast.setLocation(new Location(absciss+1, ordinate));
		}
		if(direction == 3) {
			beast.setLocation(new Location(absciss-1, ordinate));
		}
		if(direction == 4) {
			beast.setLocation(new Location(absciss, ordinate-1));
		}
		System.out.println("NEW LOCATION: "+beast.getLocation());
	}


	public void Move(TilePanel[][] tilesPanel, BeastPanel beastPanel) {
//		System.out.println("OLD LOCATION: "+beastPanel.getBeast().getLocation());
		int absciss = beastPanel.getBeast().getAbsciss();
		int ordinate = beastPanel.getBeast().getOrdinate();
		Location oldLoc = new Location(absciss, ordinate);
		Location newLoc = new Location(absciss, ordinate);
		int beastOrientation;
		//IMPORTANT: if the new location is not a valide one (out of border)
		//redo the analyse, if it's a valide one, but an obstacle, redo it too
		//it's important to analyse the validity first to not cause an ArrayBoundException
		do {
			beastOrientation = Map_Settings.generateRand(1,  4);
			newLoc = setNewLocation(oldLoc, beastOrientation);
		}while(!newLoc.isValideLoc() //DO THIS ANALYSE FIRST
				|| tilesPanel[newLoc.getAbsciss()][newLoc.getOrdinate()].getTile().isObstacle());
		beastPanel.getBeast().setLocation(newLoc);
		beastPanel.getBeast().setOrientation(beastOrientation);
	}
	
	public Location setNewLocation(Location loc, int direction) {
		if(direction == 1) {
			//Direction RIGTH
			loc = new Location(loc.getAbsciss(), loc.getOrdinate()+1);
		}
		if(direction == 2) {
			//Direction DOWN
			loc = new Location(loc.getAbsciss()+1, loc.getOrdinate());
		}
		if(direction == 3) {
			//Direction TOP
			loc = new Location(loc.getAbsciss()-1, loc.getOrdinate());
		}
		if(direction == 4) {
			//Direction LEFT
			loc = new Location(loc.getAbsciss(), loc.getOrdinate()-1);
		}
		return loc;
	}
	
	
	
}
