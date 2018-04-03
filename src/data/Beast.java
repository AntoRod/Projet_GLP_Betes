package data;

import java.awt.Image;
import java.awt.Toolkit;

import gui.Map_Settings;

public class Beast {

	private int age;
	private String sexe;
	private Stats stats;
	private Location location;
	
	public Beast () {
		this.setDefaultBeast();
	}
	public Beast(Location loc) {
		this.setDefaultBeast();
		location = loc;
	}
	
	public void setDefaultBeast() {
		age = 18;
		/*int number = MapParameters.generateRand(1,2);
		if(number ==2) sexe = MapParameters.femaleGender;
		else */sexe = Map_Settings.maleGender;
		stats = new Stats();
	}
	

	
	

	public void setLocation(Location loc) {
		location = loc;
	}
	public void setAge(int beastAge) {
		age = beastAge;
	}
	public void setStats(Stats beastStats) {
		stats = beastStats;
	}
	public void setSexe(String beastGender) {
		sexe = beastGender;
	}
	
	public String getSexe() {
		return sexe;
	}
	public int getAge() {
		return age ; 
	}
	public Stats getStats() {
		return stats;
	}
	public Location getLocation() {
		return location;
	}
	
	public int getAbsciss() {
		return location.getAbsciss();
	}
	public int getOrdinate() {
		return location.getOrdinate();
	}
	
	
	public String toString() {
		return ""+this.getLocation().toString()+"Sexe: "+getSexe()+"\n";
	}
	
	public void setDefaultLocation(int beastNumber) {
		int absciss = Map_Settings.generateRand(1, Map_Settings.MAP_WIDTH);
		int ordinate = Map_Settings.generateRand(1, Map_Settings.MAP_LENGTH);
		//System.out.println("Test: A: "+absciss+" B: "+ordinate);
		location = new Location(absciss, ordinate);
	}
	
}
	