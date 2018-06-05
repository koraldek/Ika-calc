package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Townhall extends ABuilding {
	@Column
	private int nMarble, maxCitizen, maxActionPoints;

	public Townhall() {
	}

	public Townhall(int lvl, int nWood, long nTime, int nMarble, int maxCitizen, int maxActionPoints) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.maxCitizen = maxCitizen;
		this.maxActionPoints = maxActionPoints;
	}

	@Override
	public String toString() {
		return "Townhall [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", maxCitizen=" + maxCitizen + ", maxActionPoints=" + maxActionPoints + "]";
	}

	public int getMaxActionPoints() {
		return maxActionPoints;
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getMaxCitizen() {
		return maxCitizen;
	}

}
