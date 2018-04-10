package data;

public class Food {
	
	private int maxFoodValue;
	private int foodValue;
	private Location location;
	
	
	//maxFoodValue = 250
	//foodValue = maxFoodValue FOR STARTING
	
	
	public Food(int i, int j) {
		maxFoodValue = 20;
		foodValue = maxFoodValue;
		location = new Location(i, j);
	}
	
	public int getFoodValue() {
		return foodValue;
	}
	public int getMaxFoodValue() {
		return maxFoodValue;
	}
	
	public void setFoodValue(int FoodValue) {
		foodValue = FoodValue;
	}
	public void setMaxFoodValue(int FoodValue) {
		maxFoodValue = FoodValue;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void removeFoodValue(int number) {
		foodValue-=number;
		if(foodValue<0) location = new Location(-1,-1);
	}
	
	

}