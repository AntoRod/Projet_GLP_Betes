package core;

import data.Beast;
import data.Location;

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
			beast.setLocation(new Location(absciss-1, ordinate+1));
		}
		if(direction == 4) {
			beast.setLocation(new Location(absciss-1, ordinate-1));
		}
		System.out.println("NEW LOCATION: "+beast.getLocation());
	}
	
	
	
	
	

}
