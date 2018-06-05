package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Tavern extends ABuilding {
	@Column
	private int nMarble;
	@Column
	private int basic_s;
	@Column
	private int bonus_s;
	@Column
	private int vine_served;

	public Tavern() {
	}

	public Tavern(int lvl, int nWood, long nTime, int nMarble, int vine_served, int basic_s, int bonus_s) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.vine_served = vine_served;
		this.basic_s = basic_s;
		this.bonus_s = bonus_s;

	}

	@Override
	public String toString() {
		return "Tavern [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", basic_s=" + basic_s + ", bonus_s=" + bonus_s + ", vine_served=" + vine_served + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getBasic_s() {
		return basic_s;
	}

	public int getBonus_s() {
		return bonus_s;
	}

	public int getVine_served() {
		return vine_served;
	}
}
