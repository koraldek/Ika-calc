package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Barracks extends ABuilding {
	@Column
	private int nMarble;

	public Barracks() {
	}

	public Barracks(int lvl, int nWood, long nTime, int nMarble) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
	}

	@Override
	public String toString() {
		return "Barracks [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + "]";
	}

	public int getnMarble() {
		return nMarble;
	}
}
