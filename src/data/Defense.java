package data;

public class Defense {
	
	private double minDefense;
	private double maxDefense;
	
	//MAXIMUM DEFENSE STATS:
	//minDefense: 5
	//maxDefense: 12
	
	public Defense() {
		minDefense = 5;
		maxDefense = 12;
	}
	
	public double getMinDefense() {
		return minDefense;
	}
	public double getMaxDefense() {
		return maxDefense;
	}
	
	public void setMinDefense(double defense) {
		minDefense = defense;
	}
	public void setMaxDefense(double defense) {
		maxDefense = defense;
	}
	
	public String toString() {
		return "MAX DEF: "+maxDefense+" MIN DEF "+minDefense+" ";
	}

}
