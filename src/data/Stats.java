package data;

public class Stats {
	
	private double maxlivePoints;
	private double livePoints;
	private int maxStamina;
	private int stamina;
	private Attack attack;
	private Defense defense;
	
	
	public Stats() {
		
	}
	
	public double getMaxLife() {
		return maxlivePoints;
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
		maxlivePoints = Life;
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
}
