package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LuxuryResource extends ABuilding {
	@Column
	int workers;

	public LuxuryResource() {
	}

	public LuxuryResource(int lvl, int nWood, long nTime, int workers) {
		super(lvl, nWood, nTime);
		this.workers = workers;
	}

	@Override
	public String toString() {
		return "LuxuryResource [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", workers=" + workers + "]";
	}

	public int getWorkers() {
		return workers;
	}

}
