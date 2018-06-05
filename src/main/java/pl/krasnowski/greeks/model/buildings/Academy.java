package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Academy extends ABuilding {

	@Column(name = "nCrystal")
	private int nCrystal;
	@Column(name = "MaxScientists")
	private int MaxScientists;

	public Academy() {
	}

	public Academy(int lvl, int nWood, long nTime, int nCrystal, int MaxScientists) {
		super(lvl, nWood, nTime);
		this.nCrystal = nCrystal;
		this.MaxScientists = MaxScientists;
	}

	@Override
	public String toString() {
		return "Academy [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nCrystal=" + nCrystal + ", MaxScientists=" + MaxScientists + "]";
	}

	public int getnCrystal() {
		return nCrystal;
	}

	public int getMaxScientists() {
		return MaxScientists;
	}
}
