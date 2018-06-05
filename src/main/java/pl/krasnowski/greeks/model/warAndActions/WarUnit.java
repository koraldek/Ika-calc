package pl.krasnowski.greeks.model.warAndActions;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import pl.krasnowski.greeks.model.buildings.ABuilding;
import pl.krasnowski.greeks.model.world.Research;

@Entity
public class WarUnit {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int warUnit_ID;

	String name;
	int nWood, nCrystal, nSulphur, nCitizens, upkeep, nLvl, buildingTime, hitPoints, armour, speed, size, count;

	@OneToOne
	ABuilding nBuilding;

	@OneToOne
	Research nResearch;

	@OneToOne
	Weapon meleeWeapon;

	@OneToOne
	Weapon rangedWeapon;

	@Enumerated(EnumType.STRING)
	BattleType bType;

	@Enumerated(EnumType.STRING)
	UnitType uType;

	@Enumerated(EnumType.STRING)
	Position position;

	public WarUnit() {
	}

	public WarUnit(String name, int nWood, int nCrystal, int nSulphur, int nCitizens, int upkeep, int nLvl, int buildingTime, int hitPoints, int armour, int speed, int size, int count,
			ABuilding nBuilding, Research nResearch, Weapon meleeWeapon, Weapon rangedWeapon, BattleType bType, UnitType uType, Position position) {
		this.name = name;
		this.nWood = nWood;
		this.nCrystal = nCrystal;
		this.nSulphur = nSulphur;
		this.nCitizens = nCitizens;
		this.upkeep = upkeep;
		this.nLvl = nLvl;
		this.buildingTime = buildingTime;
		this.hitPoints = hitPoints;
		this.armour = armour;
		this.speed = speed;
		this.size = size;
		this.count = count;
		this.nBuilding = nBuilding;
		this.nResearch = nResearch;
		this.meleeWeapon = meleeWeapon;
		this.rangedWeapon = rangedWeapon;
		this.bType = bType;
		this.uType = uType;
		this.position = position;
	}

	@Override
	public String toString() {
		return "WarUnit [warUnit_ID=" + warUnit_ID + ", name=" + name + ", nWood=" + nWood + ", nCrystal=" + nCrystal + ", nSulphur=" + nSulphur + ", nCitizens=" + nCitizens + ", upkeep=" + upkeep
				+ ", nLvl=" + nLvl + ", buildingTime=" + buildingTime + ", hitPoints=" + hitPoints + ", armour=" + armour + ", speed=" + speed + ", size=" + size + ", count=" + count + ", nBuilding="
				+ nBuilding + ", nResearch=" + nResearch + ", meleeWeapon=" + meleeWeapon + ", rangedWeapon=" + rangedWeapon + ", bType=" + bType + ", uType=" + uType + ", position=" + position + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + armour;
		result = prime * result + ((bType == null) ? 0 : bType.hashCode());
		result = prime * result + buildingTime;
		result = prime * result + count;
		result = prime * result + hitPoints;
		result = prime * result + ((meleeWeapon == null) ? 0 : meleeWeapon.hashCode());
		result = prime * result + ((nBuilding == null) ? 0 : nBuilding.hashCode());
		result = prime * result + nCitizens;
		result = prime * result + nCrystal;
		result = prime * result + nLvl;
		result = prime * result + ((nResearch == null) ? 0 : nResearch.hashCode());
		result = prime * result + nSulphur;
		result = prime * result + nWood;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((rangedWeapon == null) ? 0 : rangedWeapon.hashCode());
		result = prime * result + size;
		result = prime * result + speed;
		result = prime * result + ((uType == null) ? 0 : uType.hashCode());
		result = prime * result + upkeep;
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
		WarUnit other = (WarUnit) obj;
		if (armour != other.armour)
			return false;
		if (bType != other.bType)
			return false;
		if (buildingTime != other.buildingTime)
			return false;
		if (count != other.count)
			return false;
		if (hitPoints != other.hitPoints)
			return false;
		if (meleeWeapon == null) {
			if (other.meleeWeapon != null)
				return false;
		} else if (!meleeWeapon.equals(other.meleeWeapon))
			return false;
		if (nBuilding == null) {
			if (other.nBuilding != null)
				return false;
		} else if (!nBuilding.equals(other.nBuilding))
			return false;
		if (nCitizens != other.nCitizens)
			return false;
		if (nCrystal != other.nCrystal)
			return false;
		if (nLvl != other.nLvl)
			return false;
		if (nResearch == null) {
			if (other.nResearch != null)
				return false;
		} else if (!nResearch.equals(other.nResearch))
			return false;
		if (nSulphur != other.nSulphur)
			return false;
		if (nWood != other.nWood)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position != other.position)
			return false;
		if (rangedWeapon == null) {
			if (other.rangedWeapon != null)
				return false;
		} else if (!rangedWeapon.equals(other.rangedWeapon))
			return false;
		if (size != other.size)
			return false;
		if (speed != other.speed)
			return false;
		if (uType != other.uType)
			return false;
		if (upkeep != other.upkeep)
			return false;
		return true;
	}

	public int getWarUnit_ID() {
		return warUnit_ID;
	}

	public void setWarUnit_ID(int warUnit_ID) {
		this.warUnit_ID = warUnit_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getnWood() {
		return nWood;
	}

	public void setnWood(int nWood) {
		this.nWood = nWood;
	}

	public int getnCrystal() {
		return nCrystal;
	}

	public void setnCrystal(int nCrystal) {
		this.nCrystal = nCrystal;
	}

	public int getnSulphur() {
		return nSulphur;
	}

	public void setnSulphur(int nSulphur) {
		this.nSulphur = nSulphur;
	}

	public int getnCitizens() {
		return nCitizens;
	}

	public void setnCitizens(int nCitizens) {
		this.nCitizens = nCitizens;
	}

	public int getUpkeep() {
		return upkeep;
	}

	public void setUpkeep(int upkeep) {
		this.upkeep = upkeep;
	}

	public int getnLvl() {
		return nLvl;
	}

	public void setnLvl(int nLvl) {
		this.nLvl = nLvl;
	}

	public int getBuildingTime() {
		return buildingTime;
	}

	public void setBuildingTime(int buildingTime) {
		this.buildingTime = buildingTime;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getArmour() {
		return armour;
	}

	public void setArmour(int armour) {
		this.armour = armour;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ABuilding getnBuilding() {
		return nBuilding;
	}

	public void setnBuilding(ABuilding nBuilding) {
		this.nBuilding = nBuilding;
	}

	public Research getnResearch() {
		return nResearch;
	}

	public void setnResearch(Research nResearch) {
		this.nResearch = nResearch;
	}

	public BattleType getbType() {
		return bType;
	}

	public void setbType(BattleType bType) {
		this.bType = bType;
	}

	public UnitType getuType() {
		return uType;
	}

	public void setuType(UnitType uType) {
		this.uType = uType;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Weapon getMeleeWeapon() {
		return meleeWeapon;
	}

	public void setMeleeWeapon(Weapon meleeWeapon) {
		this.meleeWeapon = meleeWeapon;
	}

	public Weapon getRangedWeapon() {
		return rangedWeapon;
	}

	public void setRangedWeapon(Weapon rangedWeapon) {
		this.rangedWeapon = rangedWeapon;
	}

}
