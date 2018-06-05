package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ArchitectsOffice extends ABuilding {
	@Column
	private int nMarble, bReduction;

	public ArchitectsOffice() {
	}

	public ArchitectsOffice(int lvl, int nWood, long nTime, int nMarble, int bReduction) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.bReduction = bReduction;
	}

	@Override
	public String toString() {
		return "ArchitectsOffice [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", bReduction=" + bReduction + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getBReduction() {
		return bReduction;
	}
}
