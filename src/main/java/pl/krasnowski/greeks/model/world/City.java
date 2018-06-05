package pl.krasnowski.greeks.model.world;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import pl.krasnowski.greeks.model.buildings.ABuilding;
import pl.krasnowski.greeks.model.users.Player;

/**
 * @author Korald
 *
 *
 */
@Entity(name = "City")
public class City {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int city_ID;

	@Column
	private boolean WoodCinetheatreActivated, luxCinetheatreActivated, cityOccupied, harbourOccupied;
	@Column
	private int actionPoints, goldBalance, corruption, landGarrison, seaGarrison, // overwiew
			storageSpace, currWood, currWine, currMarble, currCrystal, currSulphur, // storage
			population, happiness, sawmillWorkers, LuxWorkers, scientists, priests, idlers;// population structure and their attributes
	@Column
	private double popGrowth;
	@Column
	private String name;

	@Column
	@OneToMany(cascade = CascadeType.ALL)
	private List<ABuilding> buildings;

	@JoinColumn(name = "City_fk_player")
	@ManyToOne(cascade = CascadeType.ALL)
	private Player owner;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "City_fk_isle", insertable = false, updatable = true)
	private Isle isle;

	public City() {
	}

	public City(int actionPoints, int goldBalance, int corruption, int landGarrison, int seaGarrison, int storageSpace, int population, int happiness, int sawmillWorkers, int luxWorkers,
			int scientists, int priests, int idlers, double popGrowth, String name, List<ABuilding> buildings, Player owner, Isle isle) {

		this.actionPoints = actionPoints;
		this.goldBalance = goldBalance;
		this.corruption = corruption;
		this.landGarrison = landGarrison;
		this.seaGarrison = seaGarrison;
		this.storageSpace = storageSpace;
		this.population = population;
		this.happiness = happiness;
		this.sawmillWorkers = sawmillWorkers;
		this.LuxWorkers = luxWorkers;
		this.scientists = scientists;
		this.priests = priests;
		this.idlers = idlers;
		this.popGrowth = popGrowth;
		this.name = name;
		this.buildings = buildings;
		this.owner = owner;
		this.isle = isle;
	}

	@Override
	public String toString() {
		return "City [CityID=" + city_ID + ", actionPoints=" + actionPoints + ", goldBalance=" + goldBalance + ", corruption=" + corruption + ", landGarrison=" + landGarrison + ", seaGarrison="
				+ seaGarrison + ", storageSpace=" + storageSpace + ", population=" + population + ", happiness=" + happiness + ", sawmillWorkers=" + sawmillWorkers + ", LuxWorkers=" + LuxWorkers
				+ ", scientists=" + scientists + ", priests=" + priests + ", idlers=" + idlers + ", popGrowth=" + popGrowth + ", name=" + name + ", buildings=" + buildings + ", owner=" + owner
				+ ", isle=" + isle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + city_ID;
		result = prime * result + actionPoints;
		result = prime * result + ((isle == null) ? 0 : isle.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		City other = (City) obj;
		if (city_ID != other.city_ID)
			return false;
		if (actionPoints != other.actionPoints)
			return false;
		if (isle == null) {
			if (other.isle != null)
				return false;
		} else if (!isle.equals(other.isle))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	public boolean isWoodCinetheatreActivated() {
		return WoodCinetheatreActivated;
	}

	public void setWoodCinetheatreActivated(boolean woodCinetheatreActivated) {
		WoodCinetheatreActivated = woodCinetheatreActivated;
	}

	public boolean isLuxCinetheatreActivated() {
		return luxCinetheatreActivated;
	}

	public void setLuxCinetheatreActivated(boolean luxCinetheatreActivated) {
		this.luxCinetheatreActivated = luxCinetheatreActivated;
	}

	public boolean isCityOccupied() {
		return cityOccupied;
	}

	public void setCityOccupied(boolean cityOccupied) {
		this.cityOccupied = cityOccupied;
	}

	public boolean isHarbourOccupied() {
		return harbourOccupied;
	}

	public void setHarbourOccupied(boolean harbourOccupied) {
		this.harbourOccupied = harbourOccupied;
	}

	public int getActionPoints() {
		return actionPoints;
	}

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	public int getGoldBalance() {
		return goldBalance;
	}

	public void setGoldBalance(int goldBalance) {
		this.goldBalance = goldBalance;
	}

	public int getCorruption() {
		return corruption;
	}

	public void setCorruption(int corruption) {
		this.corruption = corruption;
	}

	public int getLandGarrison() {
		return landGarrison;
	}

	public void setLandGarrison(int landGarrison) {
		this.landGarrison = landGarrison;
	}

	public int getSeaGarrison() {
		return seaGarrison;
	}

	public void setSeaGarrison(int seaGarrison) {
		this.seaGarrison = seaGarrison;
	}

	public int getStorageSpace() {
		return storageSpace;
	}

	public void setStorageSpace(int storageSpace) {
		this.storageSpace = storageSpace;
	}

	public int getCurrWood() {
		return currWood;
	}

	public void setCurrWood(int currWood) {
		this.currWood = currWood;
	}

	public int getCurrWine() {
		return currWine;
	}

	public void setCurrWine(int currWine) {
		this.currWine = currWine;
	}

	public int getCurrMarble() {
		return currMarble;
	}

	public void setCurrMarble(int currMarble) {
		this.currMarble = currMarble;
	}

	public int getCurrCrystal() {
		return currCrystal;
	}

	public void setCurrCrystal(int currCrystal) {
		this.currCrystal = currCrystal;
	}

	public int getCurrSulphur() {
		return currSulphur;
	}

	public void setCurrSulphur(int currSulphur) {
		this.currSulphur = currSulphur;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getSawmillWorkers() {
		return sawmillWorkers;
	}

	public void setSawmillWorkers(int sawmillWorkers) {
		this.sawmillWorkers = sawmillWorkers;
	}

	public int getLuxWorkers() {
		return LuxWorkers;
	}

	public void setLuxWorkers(int luxWorkers) {
		LuxWorkers = luxWorkers;
	}

	public int getScientists() {
		return scientists;
	}

	public void setScientists(int scientists) {
		this.scientists = scientists;
	}

	public int getPriests() {
		return priests;
	}

	public void setPriests(int priests) {
		this.priests = priests;
	}

	public int getIdlers() {
		return idlers;
	}

	public void setIdlers(int idlers) {
		this.idlers = idlers;
	}

	public double getPopGrowth() {
		return popGrowth;
	}

	public void setPopGrowth(double popGrowth) {
		this.popGrowth = popGrowth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ABuilding> getBuildings() {
		return buildings;
	}

	public void addBuilding(ABuilding building) {
		buildings.add(building);
	}

	public boolean deleteBuilding(ABuilding building) {
		return buildings.remove(building);
	}

	public Player getOwner() {
		return owner;
	}

	public Isle getIsle() {
		return isle;
	}

	public void setIsle(Isle isle) {
		this.isle = isle;
	}

	public int getCity_ID() {
		return city_ID;
	}

}
