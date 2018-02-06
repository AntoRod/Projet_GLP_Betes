package data;

public class Beast {

	private int age;
	private String sexe;
	private Stats stats;
	
	public void setAge(int beastAge) {
		
		age = beastAge;
	}
	
	public int getAge() {
		
		return age ; 
		
	}

	public void setSexe(String beastGender) {
		sexe = beastGender;
		
}
	public String getSexe() {
		return sexe;
	}

	public void setStatistics(Stats beastStats) {
		stats = beastStats;
		
	}
	public Stats getStats() {
		
		return stats;
		
	}
}
	