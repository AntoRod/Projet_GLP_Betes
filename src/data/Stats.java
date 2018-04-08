package data;

import gui.Map_Settings;

public class Stats {
	
	private double maxLivePoints;
	private double livePoints;
	private int maxStamina;
	private int stamina;
	private Attack attack;
	private Defense defense;
	
	//MAX STATS:
	//maxLivePoints: 120
	//livePoints: 120
	//maxStamina: 250
	//stamina: 250
	
	//Attack: 10-18
	//Defense: 5-12
	
	public Stats() {
		//first generated beasts: ALL MAX STATS
		defense = new Defense();
		attack = new Attack();
		maxLivePoints = 120;
		livePoints = maxLivePoints;
		maxStamina = 250;
		stamina = maxStamina;
		
	}
	
	public Stats(Biome tileBiome) {
		this();
		if(tileBiome.getBiomeType().equals(Map_Settings.PlainsName)) {
			maxLivePoints +=(20/100)*maxLivePoints;
			livePoints = maxLivePoints;
			attack.setMinAttack(8);
			attack.setMaxAttack(16);
			maxStamina+=(10/100)*maxStamina;
			stamina = maxStamina;
		}
		if(tileBiome.getBiomeType().equals(Map_Settings.DeadName)) {
			maxLivePoints-=(20/100)*maxLivePoints;
			livePoints = maxLivePoints;
			attack.setMinAttack(14);
			attack.setMaxAttack(22);
			maxStamina-=(10/100)*maxStamina;
			stamina = maxStamina;
		}
		if(tileBiome.getBiomeType().equals(Map_Settings.SnowName)) {
			defense.setMinDefense(8);
			defense.setMaxDefense(15);
			maxStamina+=(25/100)*maxStamina;
			stamina = maxStamina;
		}
		if(tileBiome.getBiomeType().equals(Map_Settings.DesertName)) {
			attack.setMinAttack(7);
			attack.setMaxAttack(15);
			defense.setMinDefense(9);
			defense.setMaxDefense(16);
			maxStamina+=(30/100)*maxStamina;
			stamina = maxStamina;
		}
	}
 	
	public double getMaxLife() {
		return maxLivePoints;
	}
	public double getlivePoints() {
		return livePoints;
	}
	public int getMaxStamina() {
		return maxStamina;
	}
	public int getStamina() {
		return stamina;
	}
	public Attack getAttack() {
		return attack;
	}
	public Defense getDefense() {
		return defense;
	}
	
	public void setMaxlivePoints(double Life) {
		maxLivePoints = Life;
	}
	public void setlivePoints(double Life) {
		livePoints = Life;
	}
	public void setMaxStamina(int stamina) {
		maxStamina = stamina;
	}
	public void setStamina(int stam) {
		stamina = stam;
	}
	public void setAttack(Attack atk) {
		attack = atk;
	}
	public void setDefense(Defense dfs) {
		defense = dfs;
	}
	
	
	public void removeStamina(int number) {
		stamina-=number;
	}
	
	public void removeLive(Attack attack, Defense defense, Boolean attackBiome, Boolean defenseBiome) {
		livePoints-= 10;
		double minAttack = attack.getMinAttack();
		double maxAttack = attack.getMaxAttack();
		double minDefense = defense.getMinDefense();
		double maxDefense = defense.getMaxDefense();
		double rangedMin;
		double rangedMax;
		if(attackBiome) {
			rangedMin = Map_Settings.generateRand(minAttack, minAttack+(30/100)*minAttack)-Map_Settings.generateRand(minDefense, maxDefense);
			rangedMax = Map_Settings.generateRand(maxAttack, maxAttack+(30/100)*maxAttack)-Map_Settings.generateRand(minDefense, maxDefense);
		}
		else {
			if(defenseBiome) {
				rangedMin = Map_Settings.generateRand(minAttack, maxAttack)-Map_Settings.generateRand(minDefense, minDefense+(30/100)*minDefense);
				rangedMax = Map_Settings.generateRand(minAttack, maxAttack)-Map_Settings.generateRand(maxDefense, maxDefense+(30/100)*maxDefense);
			}
			else {
				rangedMin = minAttack-minDefense;
				rangedMax = maxAttack-maxDefense;
			}
		}
		livePoints-= Map_Settings.generateRand(rangedMin, rangedMax);
		
	}
	
	
	public String toString() {
		return attack+"\n"+defense+"\nPV MAX: "+maxLivePoints+" PV: "+livePoints+"\nSTA MAX: "+maxStamina+" STA: "+stamina;
	}
	
	public String stringStamina() {
		return "STA MAX: "+maxStamina+" STA: "+stamina;
	}
	public String stringLivePoints() {
		String liveString = ""+livePoints;
		return "PV MAX: "+maxLivePoints+" PV: "+liveString.substring(0, 3);
	}
	
}
