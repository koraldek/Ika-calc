package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TradingPost extends ABuilding {
	@Column
	private int nMarble, capacity, range;

	public TradingPost() {
	}

	public TradingPost(int lvl, int nWood, long nTime, int nMarble, int capacity, int range) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.capacity = capacity;
		this.range = range;
	}

	@Override
	public String toString() {
		return "TradingPost [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", capacity=" + capacity + ", range=" + range + "]";
	}

	public int getRange() {
		return range;
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getCapacity() {
		return capacity;
	}
}
