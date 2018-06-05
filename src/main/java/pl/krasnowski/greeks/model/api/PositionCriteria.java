package pl.krasnowski.greeks.model.api;

public class PositionCriteria {
	double posX,posY;

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	@Override
	public String toString() {
		return "PositionCriteria [posX=" + posX + ", posY=" + posY + "]";
	}
	

}
