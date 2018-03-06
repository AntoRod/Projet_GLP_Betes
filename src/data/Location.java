package data;

public class Location {

	private int absciss;
	private int ordinate;
	
	public Location(int x, int y) {
		this.absciss=x;
		this.ordinate=y;
	}
	
	
	public void setLocation(int x, int y) {
		setAbsciss(x);
		setOrdinate(y);
	}
	
	
	public void setAbsciss(int x) {
		absciss = x;
	}

	public int getAbsciss() {
		return absciss;
	}
	
	
	public void setOrdinate(int y) {
		ordinate = y;
	}

	public int getOrdinate() {
		return ordinate;
	}
	
}