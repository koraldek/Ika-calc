package pl.krasnowski.greeks.model.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.omg.CORBA.INITIALIZE;
import org.springframework.stereotype.Component;

import pl.krasnowski.greeks.model.world.City;
import pl.krasnowski.greeks.model.world.Research;
import pl.krasnowski.greeks.model.world.World;

@Entity
@Table(name = "Players")
@Component
public class Player extends Account {

	@Column
	private int CapitalCityID, tradeShipsTotal, tradeShipsAvailable, ambrosia, diplomacyPointsTotal, diplomacyPointsAvailable;

	@Column // factors
	private double ShipsUpkeepFactor = 1, ShipsBuildingTimeFactor = 1, troopsBuildingTimeFactor = 1, troopsUpkeepFactor = 1, // units upkeep
			woodProductionFactor = 1, wineProductionFactor = 1, MarbleProductionFactor = 1, crystalProductionFactor = 1, sulphurProductionFactor = 1, // Production factors
			woodBuildingseRductionFactor = 1, WineBuildingsReductionFactor = 1, marbleBuildingsReductionFactor = 1, crystalBuildingsReductionFactor = 1, sulphurBuildingsReductionFactor = 1, // Reduction
			researchPointsFactor = 1, buildingConstructionTimeFactor = 1, spiesFactor = 1, loadingTimeinOwnPorts = 1, merchantShipsSpeed = 1, warShipsSpeed = 1,troopsSpeed=1, unskilledLabourersProductionFactor = 0.25,
			miracleCooldownFactor = 1;

	@Column // economy etc
	private int globalSatisfaction = 0, globalMaxPopulation = 0, globalCorruption = 0, globalBonusRangeofTradePost = 0, bonusMerchantShips = 0, bonusResearchPointsperHour = 0,
			bonusGoldProductionByPriest = 0, upkeepPerScientist = 6, additionalTradingPostRange = 0;

	@Column
	private long gold, researchPoints;

	@Column
	protected Date lastUpdate;

	@Column
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cities_fk", insertable = false, updatable = false)
	private List<City> cities;

	@Column
	private ArrayList<String> culturalGoodPartners;

	@Column
	private ArrayList<Research> researchesAchieved;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Player_fk_World", insertable = false, updatable = false)
	private World world;

	public Player() {
	};

	public Player(String nick, String email, String password) {
		super(nick, password, email);
		this.privileges = Privileges.PLAYER;
		this.registerDate = new Date();
		this.cities = new ArrayList<City>();
		this.culturalGoodPartners = new ArrayList<>();
		this.researchesAchieved = new ArrayList<>();
	}
	
	public void initializeFactors() {
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CapitalCityID;
		long temp;
		temp = Double.doubleToLongBits(WineBuildingsReductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + additionalTradingPostRange;
		result = prime * result + ambrosia;
		result = prime * result + bonusGoldProductionByPriest;
		result = prime * result + bonusMerchantShips;
		result = prime * result + bonusResearchPointsperHour;
		temp = Double.doubleToLongBits(buildingConstructionTimeFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		temp = Double.doubleToLongBits(crystalBuildingsReductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(crystalProductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((culturalGoodPartners == null) ? 0 : culturalGoodPartners.hashCode());
		result = prime * result + diplomacyPointsAvailable;
		result = prime * result + diplomacyPointsTotal;
		result = prime * result + globalBonusRangeofTradePost;
		result = prime * result + globalCorruption;
		result = prime * result + globalMaxPopulation;
		result = prime * result + globalSatisfaction;
		temp = Double.doubleToLongBits(loadingTimeinOwnPorts);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(marbleBuildingsReductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(merchantShipsSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(miracleCooldownFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(researchPointsFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((researchesAchieved == null) ? 0 : researchesAchieved.hashCode());
		temp = Double.doubleToLongBits(spiesFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sulphurBuildingsReductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sulphurProductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + tradeShipsAvailable;
		result = prime * result + tradeShipsTotal;
		temp = Double.doubleToLongBits(troopsBuildingTimeFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(troopsUpkeepFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(unskilledLabourersProductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + upkeepPerScientist;
		temp = Double.doubleToLongBits(warShipsSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wineProductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(woodBuildingseRductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(woodProductionFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((world == null) ? 0 : world.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (CapitalCityID != other.CapitalCityID)
			return false;
		if (Double.doubleToLongBits(WineBuildingsReductionFactor) != Double.doubleToLongBits(other.WineBuildingsReductionFactor))
			return false;
		if (additionalTradingPostRange != other.additionalTradingPostRange)
			return false;
		if (ambrosia != other.ambrosia)
			return false;
		if (bonusGoldProductionByPriest != other.bonusGoldProductionByPriest)
			return false;
		if (bonusMerchantShips != other.bonusMerchantShips)
			return false;
		if (bonusResearchPointsperHour != other.bonusResearchPointsperHour)
			return false;
		if (Double.doubleToLongBits(buildingConstructionTimeFactor) != Double.doubleToLongBits(other.buildingConstructionTimeFactor))
			return false;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (Double.doubleToLongBits(crystalBuildingsReductionFactor) != Double.doubleToLongBits(other.crystalBuildingsReductionFactor))
			return false;
		if (Double.doubleToLongBits(crystalProductionFactor) != Double.doubleToLongBits(other.crystalProductionFactor))
			return false;
		if (culturalGoodPartners == null) {
			if (other.culturalGoodPartners != null)
				return false;
		} else if (!culturalGoodPartners.equals(other.culturalGoodPartners))
			return false;
		if (diplomacyPointsAvailable != other.diplomacyPointsAvailable)
			return false;
		if (diplomacyPointsTotal != other.diplomacyPointsTotal)
			return false;
		if (globalBonusRangeofTradePost != other.globalBonusRangeofTradePost)
			return false;
		if (globalCorruption != other.globalCorruption)
			return false;
		if (globalMaxPopulation != other.globalMaxPopulation)
			return false;
		if (globalSatisfaction != other.globalSatisfaction)
			return false;
		if (Double.doubleToLongBits(loadingTimeinOwnPorts) != Double.doubleToLongBits(other.loadingTimeinOwnPorts))
			return false;
		if (Double.doubleToLongBits(marbleBuildingsReductionFactor) != Double.doubleToLongBits(other.marbleBuildingsReductionFactor))
			return false;
		if (Double.doubleToLongBits(merchantShipsSpeed) != Double.doubleToLongBits(other.merchantShipsSpeed))
			return false;
		if (Double.doubleToLongBits(miracleCooldownFactor) != Double.doubleToLongBits(other.miracleCooldownFactor))
			return false;
		if (Double.doubleToLongBits(researchPointsFactor) != Double.doubleToLongBits(other.researchPointsFactor))
			return false;
		if (researchesAchieved == null) {
			if (other.researchesAchieved != null)
				return false;
		} else if (!researchesAchieved.equals(other.researchesAchieved))
			return false;
		if (Double.doubleToLongBits(spiesFactor) != Double.doubleToLongBits(other.spiesFactor))
			return false;
		if (Double.doubleToLongBits(sulphurBuildingsReductionFactor) != Double.doubleToLongBits(other.sulphurBuildingsReductionFactor))
			return false;
		if (Double.doubleToLongBits(sulphurProductionFactor) != Double.doubleToLongBits(other.sulphurProductionFactor))
			return false;
		if (tradeShipsAvailable != other.tradeShipsAvailable)
			return false;
		if (tradeShipsTotal != other.tradeShipsTotal)
			return false;
		if (Double.doubleToLongBits(troopsBuildingTimeFactor) != Double.doubleToLongBits(other.troopsBuildingTimeFactor))
			return false;
		if (Double.doubleToLongBits(troopsUpkeepFactor) != Double.doubleToLongBits(other.troopsUpkeepFactor))
			return false;
		if (Double.doubleToLongBits(unskilledLabourersProductionFactor) != Double.doubleToLongBits(other.unskilledLabourersProductionFactor))
			return false;
		if (upkeepPerScientist != other.upkeepPerScientist)
			return false;
		if (Double.doubleToLongBits(warShipsSpeed) != Double.doubleToLongBits(other.warShipsSpeed))
			return false;
		if (Double.doubleToLongBits(wineProductionFactor) != Double.doubleToLongBits(other.wineProductionFactor))
			return false;
		if (Double.doubleToLongBits(woodBuildingseRductionFactor) != Double.doubleToLongBits(other.woodBuildingseRductionFactor))
			return false;
		if (Double.doubleToLongBits(woodProductionFactor) != Double.doubleToLongBits(other.woodProductionFactor))
			return false;
		if (world == null) {
			if (other.world != null)
				return false;
		} else if (!world.equals(other.world))
			return false;
		return true;
	}

	public int getCapitalCityID() {
		return CapitalCityID;
	}

	public void setCapitalCityID(int capitalCityID) {
		CapitalCityID = capitalCityID;
	}

	public int getTradeShipsTotal() {
		return tradeShipsTotal;
	}

	public void setTradeShipsTotal(int tradeShipsTotal) {
		this.tradeShipsTotal = tradeShipsTotal;
	}

	public int getTradeShipsAvailable() {
		return tradeShipsAvailable;
	}

	public void setTradeShipsAvailable(int tradeShipsAvailable) {
		this.tradeShipsAvailable = tradeShipsAvailable;
	}

	public int getAmbrosia() {
		return ambrosia;
	}

	public void setAmbrosia(int ambrosia) {
		this.ambrosia = ambrosia;
	}

	public int getDiplomacyPointsTotal() {
		return diplomacyPointsTotal;
	}

	public void setDiplomacyPointsTotal(int diplomacyPointsTotal) {
		this.diplomacyPointsTotal = diplomacyPointsTotal;
	}

	public int getDiplomacyPointsAvailable() {
		return diplomacyPointsAvailable;
	}

	public void setDiplomacyPointsAvailable(int diplomacyPointsAvailable) {
		this.diplomacyPointsAvailable = diplomacyPointsAvailable;
	}

	public double getShipsUpkeepFactor() {
		return ShipsUpkeepFactor;
	}

	public void setShipsUpkeepFactor(double shipsUpkeepFactor) {
		ShipsUpkeepFactor = shipsUpkeepFactor;
	}

	public double getShipsBuildingTimeFactor() {
		return ShipsBuildingTimeFactor;
	}

	public void setShipsBuildingTimeFactor(double shipsBuildingTimeFactor) {
		ShipsBuildingTimeFactor = shipsBuildingTimeFactor;
	}

	public double getTroopsBuildingTimeFactor() {
		return troopsBuildingTimeFactor;
	}

	public void setTroopsBuildingTimeFactor(double troopsBuildingTimeFactor) {
		this.troopsBuildingTimeFactor = troopsBuildingTimeFactor;
	}

	public double getTroopsUpkeepFactor() {
		return troopsUpkeepFactor;
	}

	public void setTroopsUpkeepFactor(double troopsUpkeepFactor) {
		this.troopsUpkeepFactor = troopsUpkeepFactor;
	}

	public double getWoodProductionFactor() {
		return woodProductionFactor;
	}

	public void setWoodProductionFactor(double woodProductionFactor) {
		this.woodProductionFactor = woodProductionFactor;
	}

	public double getWineProductionFactor() {
		return wineProductionFactor;
	}

	public void setWineProductionFactor(double wineProductionFactor) {
		this.wineProductionFactor = wineProductionFactor;
	}

	public double getMarbleProductionFactor() {
		return MarbleProductionFactor;
	}

	public void setMarbleProductionFactor(double marbleProductionFactor) {
		MarbleProductionFactor = marbleProductionFactor;
	}

	public double getCrystalProductionFactor() {
		return crystalProductionFactor;
	}

	public void setCrystalProductionFactor(double crystalProductionFactor) {
		this.crystalProductionFactor = crystalProductionFactor;
	}

	public double getSulphurProductionFactor() {
		return sulphurProductionFactor;
	}

	public void setSulphurProductionFactor(double sulphurProductionFactor) {
		this.sulphurProductionFactor = sulphurProductionFactor;
	}

	public double getWoodBuildingseRductionFactor() {
		return woodBuildingseRductionFactor;
	}

	public void setWoodBuildingseRductionFactor(double woodBuildingseRductionFactor) {
		this.woodBuildingseRductionFactor = woodBuildingseRductionFactor;
	}

	public double getWineBuildingsReductionFactor() {
		return WineBuildingsReductionFactor;
	}

	public void setWineBuildingsReductionFactor(double wineBuildingsReductionFactor) {
		WineBuildingsReductionFactor = wineBuildingsReductionFactor;
	}

	public double getMarbleBuildingsReductionFactor() {
		return marbleBuildingsReductionFactor;
	}

	public void setMarbleBuildingsReductionFactor(double marbleBuildingsReductionFactor) {
		this.marbleBuildingsReductionFactor = marbleBuildingsReductionFactor;
	}

	public double getCrystalBuildingsReductionFactor() {
		return crystalBuildingsReductionFactor;
	}

	public void setCrystalBuildingsReductionFactor(double crystalBuildingsReductionFactor) {
		this.crystalBuildingsReductionFactor = crystalBuildingsReductionFactor;
	}

	public double getSulphurBuildingsReductionFactor() {
		return sulphurBuildingsReductionFactor;
	}

	public void setSulphurBuildingsReductionFactor(double sulphurBuildingsReductionFactor) {
		this.sulphurBuildingsReductionFactor = sulphurBuildingsReductionFactor;
	}

	public double getResearchPointsFactor() {
		return researchPointsFactor;
	}

	public void setResearchPointsFactor(double researchPointsFactor) {
		this.researchPointsFactor = researchPointsFactor;
	}

	public double getBuildingConstructionTimeFactor() {
		return buildingConstructionTimeFactor;
	}

	public void setBuildingConstructionTimeFactor(double buildingConstructionTimeFactor) {
		this.buildingConstructionTimeFactor = buildingConstructionTimeFactor;
	}

	public double getSpiesFactor() {
		return spiesFactor;
	}

	public void setSpiesFactor(double spiesFactor) {
		this.spiesFactor = spiesFactor;
	}

	public double getLoadingTimeinOwnPorts() {
		return loadingTimeinOwnPorts;
	}

	public void setLoadingTimeinOwnPorts(double loadingTimeinOwnPorts) {
		this.loadingTimeinOwnPorts = loadingTimeinOwnPorts;
	}

	public double getMerchantShipsSpeed() {
		return merchantShipsSpeed;
	}

	public void setMerchantShipsSpeed(double merchantShipsSpeed) {
		this.merchantShipsSpeed = merchantShipsSpeed;
	}

	public double getWarShipsSpeed() {
		return warShipsSpeed;
	}

	public void setWarShipsSpeed(double warShipsSpeed) {
		this.warShipsSpeed = warShipsSpeed;
	}

	public double getMiracleCooldownFactor() {
		return miracleCooldownFactor;
	}

	public void setMiracleCooldownFactor(double miracleCooldownFactor) {
		this.miracleCooldownFactor = miracleCooldownFactor;
	}

	public int getGlobalSatisfaction() {
		return globalSatisfaction;
	}

	public void setGlobalSatisfaction(int globalSatisfaction) {
		this.globalSatisfaction = globalSatisfaction;
	}

	public int getGlobalMaxPopulation() {
		return globalMaxPopulation;
	}

	public void setGlobalMaxPopulation(int globalMaxPopulation) {
		this.globalMaxPopulation = globalMaxPopulation;
	}

	public int getGlobalCorruption() {
		return globalCorruption;
	}

	public void setGlobalCorruption(int globalCorruption) {
		this.globalCorruption = globalCorruption;
	}

	public int getGlobalBonusRangeofTradePost() {
		return globalBonusRangeofTradePost;
	}

	public void setGlobalBonusRangeofTradePost(int globalBonusRangeofTradePost) {
		this.globalBonusRangeofTradePost = globalBonusRangeofTradePost;
	}

	public int getBonusMerchantShips() {
		return bonusMerchantShips;
	}

	public void setBonusMerchantShips(int bonusMerchantShips) {
		this.bonusMerchantShips = bonusMerchantShips;
	}

	public int getBonusResearchPointsperHour() {
		return bonusResearchPointsperHour;
	}

	public void setBonusResearchPointsperHour(int bonusResearchPointsperHour) {
		this.bonusResearchPointsperHour = bonusResearchPointsperHour;
	}

	public int getBonusGoldProductionByPriest() {
		return bonusGoldProductionByPriest;
	}

	public void setBonusGoldProductionByPriest(int bonusGoldProductionByPriest) {
		this.bonusGoldProductionByPriest = bonusGoldProductionByPriest;
	}

	public int getUpkeepPerScientist() {
		return upkeepPerScientist;
	}

	public void setUpkeepPerScientist(int upkeepPerScientist) {
		this.upkeepPerScientist = upkeepPerScientist;
	}

	public int getAdditionalTradingPostRange() {
		return additionalTradingPostRange;
	}

	public void setAdditionalTradingPostRange(int additionalTradingPostRange) {
		this.additionalTradingPostRange = additionalTradingPostRange;
	}

	public long getGold() {
		return gold;
	}

	public void setGold(long gold) {
		this.gold = gold;
	}

	public long getResearchPoints() {
		return researchPoints;
	}

	public void setResearchPoints(long researchPoints) {
		this.researchPoints = researchPoints;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public ArrayList<String> getCulturalGoodPartners() {
		return culturalGoodPartners;
	}

	public void setCulturalGoodPartners(ArrayList<String> culturalGoodPartners) {
		this.culturalGoodPartners = culturalGoodPartners;
	}

	public ArrayList<Research> getResearchesAchieved() {
		return researchesAchieved;
	}

	public void setResearchesAchieved(ArrayList<Research> researchesAchieved) {
		this.researchesAchieved = researchesAchieved;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public double getTroopsSpeed() {
		return troopsSpeed;
	}

	public void setTroopsSpeed(double troopsSpeed) {
		this.troopsSpeed = troopsSpeed;
	}

	public double getUnskilledLabourersProductionFactor() {
		return unskilledLabourersProductionFactor;
	}

	public void setUnskilledLabourersProductionFactor(double unskilledLabourersProductionFactor) {
		this.unskilledLabourersProductionFactor = unskilledLabourersProductionFactor;
	}
	
	

}
