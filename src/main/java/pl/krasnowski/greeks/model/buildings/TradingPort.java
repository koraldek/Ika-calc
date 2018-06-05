package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TradingPort extends ABuilding {
	@Column
	private int nMarble, loadingSpeed;

	public TradingPort() {
	}

	public TradingPort(int lvl, int nWood, long nTime, int nMarble, int loadingSpeed) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.loadingSpeed = loadingSpeed;
	}

	@Override
	public String toString() {
		return "TradingPort [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", loadingSpeed=" + loadingSpeed + "]";
	}

	public int getLoadingSpeed() {
		return loadingSpeed;
	}

	public int getnMarble() {
		return nMarble;
	}



}
