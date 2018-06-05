package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Workshop extends ABuilding {
	@Column
	private int nMarble;

	public Workshop() {
	}

	public Workshop(int lvl, int nWood, long nTime, int nMarble) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
	}

	@Override
	public String toString() {
		return "Workshop [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

}
