package pl.krasnowski.greeks.model.warAndActions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.City;
import pl.krasnowski.greeks.model.world.Stock;

@Entity
public class ActionOnCity {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int actionOnCity_ID;

	@ManyToOne
	City originCity, targetCity;

	@Enumerated(EnumType.STRING)
	ActionType actionType;

	@ManyToOne
	Player initiator;

	// 5 elementow z typami int
	@ElementCollection
	Map<Stock, Integer> cargo;

	@OneToMany
	List<WarUnit> troops;

	Date arrivalTime;

	long goldC;

	public ActionOnCity() {
	}

	public ActionOnCity(City originCity, City targetCity, ActionType actionType, Player initiator, List<WarUnit> troops, int woodC, int wineC, int marbleC, int crystalC, int sulphurC, long goldC,
			Date arrivalTime) {
		super();
		this.originCity = originCity;
		this.targetCity = targetCity;
		this.actionType = actionType;
		this.initiator = initiator;
		this.cargo = new HashMap<>(5);
		cargo.put(Stock.WOOD, woodC);
		cargo.put(Stock.WINE, wineC);
		cargo.put(Stock.MARBLE, marbleC);
		cargo.put(Stock.CRYSTAL, crystalC);
		cargo.put(Stock.SULPHUR, sulphurC);
		this.goldC = goldC;
		this.troops = troops;
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "ActionOnCity [originCity=" + originCity + ", targetCity=" + targetCity + ", actionType=" + actionType + ", initiator=" + initiator + ", cargo=" + cargo + ", troops=" + troops
				+ ", goldC=" + goldC + "]";
	}

	public City getOriginCity() {
		return originCity;
	}

	public void setOriginCity(City originCity) {
		this.originCity = originCity;
	}

	public City getTargetCity() {
		return targetCity;
	}

	public void setTargetCity(City targetCity) {
		this.targetCity = targetCity;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public Player getInitiator() {
		return initiator;
	}

	public void setInitiator(Player initiator) {
		this.initiator = initiator;
	}

	public Map<Stock, Integer> getCargo() {
		return cargo;
	}

	public void setCargo(Map<Stock, Integer> cargo) {
		this.cargo = cargo;
	}

	public List<WarUnit> getTroops() {
		return troops;
	}

	public void setTroops(List<WarUnit> troops) {
		this.troops = troops;
	}

	public long getGoldC() {
		return goldC;
	}

	public void setGoldC(long goldC) {
		this.goldC = goldC;
	}

	public int getActionOnCity_ID() {
		return actionOnCity_ID;
	}

	public void setActionOnCity_ID(int actionOnCity_ID) {
		this.actionOnCity_ID = actionOnCity_ID;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
