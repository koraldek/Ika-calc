package pl.krasnowski.greeks.model.warAndActions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
class Weapon {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int weapon_ID;

	int damage, ammo, accuracy;

	public Weapon() {
	}

	public Weapon(int damage, int ammo, int accuracy) {
		super();
		this.damage = damage;
		this.ammo = ammo;
		this.accuracy = accuracy;
	}

	@Override
	public String toString() {
		return "Weapon [weapon_ID=" + weapon_ID + ", damage=" + damage + ", ammo=" + ammo + ", accuracy=" + accuracy + "]";
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getWeapon_ID() {
		return weapon_ID;
	}

	public void setWeapon_ID(int weapon_ID) {
		this.weapon_ID = weapon_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accuracy;
		result = prime * result + ammo;
		result = prime * result + damage;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (accuracy != other.accuracy)
			return false;
		if (ammo != other.ammo)
			return false;
		if (damage != other.damage)
			return false;
		return true;
	}

}
