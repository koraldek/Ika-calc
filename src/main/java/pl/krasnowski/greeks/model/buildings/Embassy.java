package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Embassy extends ABuilding {
	@Column
	private int nMarble, diplomacyPoints;

	public Embassy() {
	}

	public Embassy(int lvl, int nWood, long nTime, int nMarble, int diplomacyPoints) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.diplomacyPoints = diplomacyPoints;
	}

	@Override
	public String toString() {
		return "Embassy [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", diplomacyPoints=" + diplomacyPoints + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getDiplomacyPoints() {
		return diplomacyPoints;
	}
}
