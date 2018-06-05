package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PirateFortress extends ABuilding {

	@Column
	private int nMarble;

	public PirateFortress() {
	}

	public PirateFortress(int lvl, int nWood, long nTime, int nMarble) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
	}

	public int getnMarble() {
		return nMarble;
	}

	@Override
	public String toString() {
		return "PirateFortress [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + "]";
	}

}
