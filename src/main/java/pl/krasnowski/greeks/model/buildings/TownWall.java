package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TownWall extends ABuilding {
	@Column
	private int nMarble, hitPoints, armour, damage, accuracy;

	public TownWall() {
	}

	public TownWall(int lvl, int nWood, long nTime, int nMarble, int hitPoints, int armour, int damage, int accuracy) {
		super(lvl, nWood, nTime);
		this.nMarble = nMarble;
		this.hitPoints = hitPoints;
		this.armour = armour;
		this.damage = damage;
		this.accuracy = accuracy;
	}

	@Override
	public String toString() {
		return "TownWall [lvl=" + lvl + ", nWood=" + nWood + ", nTime=" + nTime + ", nMarble=" + nMarble + ", hitPoints=" + hitPoints + ", armour=" + armour + ", damage=" + damage + ", accuracy="
				+ accuracy + "]";
	}

	public int getnMarble() {
		return nMarble;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getArmour() {
		return armour;
	}

	public int getDamage() {
		return damage;
	}

	public int getAccuracy() {
		return accuracy;
	}


}