package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Stonemason extends ABuilding {
	@Column
	private int nMarble;
	@Column
	private int bProduction;

	public Stonemason() {
	}

	public Stonemason(int lvl, int nWood, long nTime, int nMarble, int bProduction) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.bProduction = bProduction;
	}

	@Override
	public String toString() {
		return "Stonemason [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", bProduction=" + bProduction + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getbProduction() {
		return bProduction;
	}

}
