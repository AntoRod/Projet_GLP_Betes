package data;

public class Attack {
	
	private double minAttack;
	private double maxAttack;
	
	//MAXIMUM ATTACK STATS
	//minAttack: 10
	//maxAttack: 18
	
	public Attack() {
		minAttack = 10;
		maxAttack = 18;
	}
	
	public double getMinAttack() {
		return minAttack;
	}
	public double getMaxAttack() {
		return maxAttack;
	}
	
	public void setMinAttack(double attack) {
		minAttack = attack;
	}
	public void setMaxAttack(double attack) {
		maxAttack = attack;
	}
	
	public String toString() {
		return "MAX ATK: "+maxAttack+" MIN ATK "+minAttack+" ";
	}
	
}