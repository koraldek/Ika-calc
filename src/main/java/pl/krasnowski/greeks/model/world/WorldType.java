package pl.krasnowski.greeks.model.world;

public enum WorldType {
	NORMAL(1),SPEED(2),WAR(3);
	
	private int type;
	
	WorldType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

}
