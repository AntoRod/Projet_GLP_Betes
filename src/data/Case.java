package data;

public class Case {
	
	private boolean isObstacle;
	private Location location;
	
	public void setObstacle(boolean variable) {
		isObstacle = variable;
		
	}
	public boolean getObstacle() {
		return isObstacle;
	}
	public void setLocation(Location loc) {
		location = loc;
		
	}
	public Location getLocation() {
		return location;
	}

}