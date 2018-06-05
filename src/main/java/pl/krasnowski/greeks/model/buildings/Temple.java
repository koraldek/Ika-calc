package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Temple extends ABuilding {
	@Column
	private int nCrystal, priests;

	public Temple() {
	}

	public Temple(int lvl, int nWood, long nTime, int nCrystal, int priests) {
		super(lvl, nWood, nTime);
		this.nCrystal = nCrystal;
		this.priests = priests;
	}

	@Override
	public String toString() {
		return "Temple [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nCrystal=" + nCrystal + ", priests=" + priests + "]";
	}

	public int getnCrystal() {
		return nCrystal;
	}

	public int getPriests() {
		return priests;
	}

}
