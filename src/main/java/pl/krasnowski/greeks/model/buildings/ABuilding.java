package pl.krasnowski.greeks.model.buildings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ABuilding {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	protected int ABuilding_id;

	@Column(name = "lvl")
	protected int lvl;

	@Column(name = "nWood")
	protected int nWood;

	@Column(name = "nTime")
	protected long nTime;

	public ABuilding() {
	}

	public ABuilding(int lvl, int nWood, long nTime) {
		this.lvl = lvl;
		this.nWood = nWood;
		this.nTime = nTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ABuilding_id;
		result = prime * result + lvl;
		result = prime * result + (int) (nTime ^ (nTime >>> 32));
		result = prime * result + nWood;
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
		ABuilding other = (ABuilding) obj;
		if (ABuilding_id != other.ABuilding_id)
			return false;
		if (lvl != other.lvl)
			return false;
		if (nTime != other.nTime)
			return false;
		if (nWood != other.nWood)
			return false;
		return true;
	}

	public int getABuilding_id() {
		return ABuilding_id;
	}

	public void setABuilding_id(int aBuilding_id) {
		ABuilding_id = aBuilding_id;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getnWood() {
		return nWood;
	}

	public void setnWood(int nWood) {
		this.nWood = nWood;
	}

	public long getnTime() {
		return nTime;
	}

	public void setnTime(long nTime) {
		this.nTime = nTime;
	}

}
