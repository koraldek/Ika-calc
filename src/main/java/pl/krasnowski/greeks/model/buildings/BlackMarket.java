package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BlackMarket extends ABuilding {
	@Column
	private int nMarble, taxBreak;

	public BlackMarket() {
	}

	public BlackMarket(int lvl, int nWood, long nTime, int nMarble,int taxBreak) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.taxBreak=taxBreak;
	}

	@Override
	public String toString() {
		return "BlackMarket [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", taxBreak=" + taxBreak + "]";
	}

	public int getTaxBreak() {
		return taxBreak;
	}

	public int getnMarble() {
		return nMarble;
	}
}
