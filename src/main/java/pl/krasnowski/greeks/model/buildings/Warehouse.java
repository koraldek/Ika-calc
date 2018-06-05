package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Warehouse extends ABuilding {
	@Column
	private int nMarble, Capacity;

	public Warehouse() {
	}

	public Warehouse(int lvl, int nWood, long nTime, int nMarble, int Capacity) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.Capacity = Capacity;
	}

	@Override
	public String toString() {
		return "Warehouse [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", Capacity=" + Capacity + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getCapacity() {
		return Capacity;
	}

}
