package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Winery extends ABuilding {
	@Column
	private int nMarble, bProduction;

	public Winery() {
	}

	public Winery(int lvl, int nWood, long nTime, int nMarble, int bProduction) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.bProduction = bProduction;
	}

	@Override
	public String toString() {
		return "Winery [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", bProduction=" + bProduction + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getbProduction() {
		return bProduction;
	}

}
