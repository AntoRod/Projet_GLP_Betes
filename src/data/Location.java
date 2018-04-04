package data;

import gui.Map_Settings;

public class Location {

	private int absciss;
	private int ordinate;
	
	public Location(int x, int y) {
		this.absciss=x;
		this.ordinate=y;
	}
	
	public Location(int random) {
		absciss = random%Map_Settings.MAP_WIDTH;
		ordinate = random%Map_Settings.MAP_LENGTH;
		
	}
	
	public void setAbsciss(int x) {
		absciss = x;
	}

	public int getAbsciss() {
		return absciss;
	}
	public void setLocation(int x, int y) {
		setAbsciss(x);
		setOrdinate(y);
	}
	
	public void setOrdinate(int y) {
		ordinate = y;
	}

	public int getOrdinate() {
		return ordinate;
	}
	
	public String toString(){
		return "A: "+absciss+" O: "+ordinate+"\n";
	}

	public boolean isValideLoc() {
		if(absciss>=0 && absciss<Map_Settings.MAP_WIDTH) {
			if(ordinate>=0 && ordinate<Map_Settings.MAP_WIDTH) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	
}