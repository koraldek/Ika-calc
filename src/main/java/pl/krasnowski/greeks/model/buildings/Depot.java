package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Depot extends ABuilding {
	@Column
	private int nMarble, nCrystal, nSulphur, capacity;

	public Depot() {
	}

	public Depot(int lvl, int nWood, long nTime, int nMarble, int nCrystal, int nSulphur, int capacity) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.nCrystal = nCrystal;
		this.nSulphur = nSulphur;
		this.capacity = capacity;

	}

	@Override
	public String toString() {
		return "Depot [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", nCrystal=" + nCrystal + ", nSulphur=" + nSulphur + ", capacity=" + capacity + "]";
	}

	public int getCapacity() {
		return capacity;
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
