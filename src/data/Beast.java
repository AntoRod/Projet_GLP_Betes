package data;

import gui.Map_Settings;

public class Beast {

	private String sexe;
	private Stats stats;
	private Location location;
	private Biome biome;
	private String orientation;
	private int beastNumber;
	private Boolean movement;
	private Boolean deadStatut = false;
	
	
	public Beast () {
		this.setDefaultBeast();
	}

	public Beast (int biomeNumber) {
		this.setBiome(biomeNumber);
	}
	
	public Beast(Location loc) {
		this.setRandomBeast();
		location = loc;
	}
	public Beast(Location loc, Biome tileBiome) {
		this.setRandomBeast(tileBiome);
		location = loc;
		biome = tileBiome;
	}
	
	public void setDeath(Boolean death) {
		deadStatut = death;
	}
	
	public void setNumber(int number) {
		beastNumber = number;
	}
	
	public void setDefaultBeast() {
		sexe = Map_Settings.maleGender;
		stats = new Stats();
		biome = new Biome(Map_Settings.DesertName);
		orientation = "down";
		movement = true;
	}

	public void setRandomBeast() {
		int number;
		if((number = Map_Settings.generateRand(1, 2))==1) sexe = Map_Settings.femaleGender;
		else sexe = Map_Settings.maleGender;
		number = Map_Settings.generateRand(1, 4);
		this.setOrientation(number);
		number = Map_Settings.generateRand(1, 4);
		this.setBiome(number);
		movement = true;
		deadStatut = false;
		stats = new Stats();
	}
	
	public void setRandomBeast(Biome tileBiome) {
		this.setRandomBeast();
		stats = new Stats(tileBiome);
	}
	

	
	public void setOrientation(int beastOrientation){
		if (beastOrientation == 1) orientation = Map_Settings.RIGHT ;
		else if (beastOrientation == 2) orientation =  Map_Settings.DOWN;
		else if (beastOrientation == 3) orientation = Map_Settings.TOP;
		else if (beastOrientation == 4) orientation =  Map_Settings.LEFT;
	}
	public void setMove(Boolean move) {
		movement = move;
	}
	
	public void setLocation(Location loc) {
		location = loc;
	}
	public void setStats(Stats beastStats) {
		stats = beastStats;
	}
	public void setSexe(String beastGender) {
		beastGender = Map_Settings.maleGender;
		sexe = beastGender;
	}
	
	public void setBiome(int biomeNumber){
		if (biomeNumber == 1) biome = new Biome(Map_Settings.PlainsName);
		else if (biomeNumber == 2) biome = new Biome(Map_Settings.DeadName);
		else if (biomeNumber == 3) biome = new Biome(Map_Settings.SnowName);
		else if (biomeNumber == 4) biome = new Biome(Map_Settings.DesertName);
	} 
	
	public void setBiome(Biome newBiome){
		biome = newBiome;
	}
	public String getOrientation(){
		return orientation ;
		
	}
	
	public Boolean isDead() {
		return deadStatut;
	}
	
	public int getNumber() {
		return beastNumber;
	}
	public String getSexe() {
		return sexe;
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
	public Boolean canMove() {
		return movement;
	}
	public Biome getBiome() {
		return biome;
	}
	
	public void removeStamina(int number) {
		this.getStats().removeStamina(number);
	}
	public void removeLive(Attack attack, Defense defense, Boolean attackBiome, Boolean defenseBiome) {
		this.getStats().removeLive(attack, defense, attackBiome, defenseBiome);
	}
	
	public String toString() {
		return ""+this.getLocation().toString()+ "sexe: "+getSexe()+" number: "+beastNumber;
	}
	
	public void setDefaultLocation(int beastNumber) {
		int absciss = Map_Settings.generateRand(1, Map_Settings.MAP_WIDTH);
		int ordinate = Map_Settings.generateRand(1, Map_Settings.MAP_LENGTH);
		//System.out.println("Test: A: "+absciss+" B: "+ordinate);
		location = new Location(absciss, ordinate);
	}
	
}
	