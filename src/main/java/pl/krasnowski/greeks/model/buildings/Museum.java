package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Museum extends ABuilding {
	@Column
	private int nMarble, basic_s, bonus_s;

	public Museum() {
	}

	public Museum(int lvl, int nWood, int nMarble, long nTime, int basic_s, int bonus_s) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.basic_s = basic_s;
		this.bonus_s = bonus_s;
	}

	@Override
	public String toString() {
		return "Museum [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", basic_s=" + basic_s + ", bonus_s=" + bonus_s + "]";
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

}
