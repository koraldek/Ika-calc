package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class GovernorsResidence extends ABuilding {
	@Column
	private int nWine, nMarble, nCrystal, nSulphur;

	public GovernorsResidence() {
	}

	public GovernorsResidence(int lvl, int nWood, long nTime, int nWine, int nMarble, int nCrystal, int nSulphur) {
		super(lvl, nWood, nTime);
		this.nWine = nWine;
		this.nMarble = nMarble;
		this.nCrystal = nCrystal;
		this.nSulphur = nSulphur;
	}

	@Override
	public String toString() {
		return "GovernorsResidence [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nWine=" + nWine + ", nMarble=" + nMarble + ", nCrystal=" + nCrystal + ", nSulphur=" + nSulphur + "]";
	}

	public int getnWine() {
		return nWine;
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getnCrystal() {
		return nCrystal;
	}

	public int getnSulphur() {
		return nSulphur;
	}

}
