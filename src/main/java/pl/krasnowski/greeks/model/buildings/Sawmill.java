package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Sawmill extends ABuilding {
	@Column
	int workers;

	public Sawmill() {
	}

	public Sawmill(int lvl, int nWood, long nTime, int workers) {
		super(lvl, nWood, nTime);
		this.workers = workers;
	}

	@Override
	public String toString() {
		return "Sawmill [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", workers=" + workers + "]";
	}

	public int getWorkers() {
		return workers;
	}

}
