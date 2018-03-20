package data;

import gui.MapParameters;

public class Location {

	private int absciss;
	private int ordinate;
	
	public Location(int x, int y) {
		this.absciss=x;
		this.ordinate=y;
	}
	
	public Location(int random) {
		absciss = random%MapParameters.MAP_WIDTH;
		ordinate = random%MapParameters.MAP_WIDTH;
		
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
	
}