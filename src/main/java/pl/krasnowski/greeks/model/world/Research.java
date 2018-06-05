package pl.krasnowski.greeks.model.world;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import pl.krasnowski.greeks.model.buildings.ABuilding;

/*
 * gracz posiada listę odkrytych badan  z preinicjalizowanej listy na swiecie(listy dostepnych badan) zrobic z niej singletona, z ktorego beda korzystac wszystkie budynki do listy z badaniami
 * 
 * - informacje czy mozna budowac jednostke bojowa bdzie pytac na podstawie zawartosci listy badan i poziomu budynku w miastach - inne informacje, jak: piractwo, prawa garnizonowe, formy rzadu beda w
 * poszczegolnych obiektach wnioskowane na podstawie badan
 */

@Entity
public class Research {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int research_ID;

	String name;

	long cost;
	// @Enumerated(EnumType.STRING)
	ResearchParent parent;

	@OneToOne
	ABuilding unlocksBuilding;

	ArrayList<Research> requirements;

	public Research() {
	}

	public Research(String name, int cost, ResearchParent parent, ArrayList<Research> requirements) {
		this.cost = cost;
		this.name = name;
		this.parent = parent;
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		return "Research [research_ID=" + research_ID + ", name=" + name + ", cost=" + cost + ", parent=" + parent + ", unlocksBuilding=" + unlocksBuilding + ", requirements=" + requirements + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cost ^ (cost >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result + ((unlocksBuilding == null) ? 0 : unlocksBuilding.hashCode());
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
		Research other = (Research) obj;
		if (cost != other.cost)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent != other.parent)
			return false;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (unlocksBuilding == null) {
			if (other.unlocksBuilding != null)
				return false;
		} else if (!unlocksBuilding.equals(other.unlocksBuilding))
			return false;
		return true;
	}

	long getCost() {
		return this.cost;
	}

	ArrayList<Research> getRequirements() {
		return this.requirements;
	}

	ResearchParent getParent() {
		return this.parent;
	}

	public int getResearch_ID() {
		return research_ID;
	}

	public void setResearch_ID(int research_ID) {
		this.research_ID = research_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ABuilding getUnlocksBuilding() {
		return unlocksBuilding;
	}

	public void setUnlocksBuilding(ABuilding unlocksBuilding) {
		this.unlocksBuilding = unlocksBuilding;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public void setParent(ResearchParent parent) {
		this.parent = parent;
	}

	public void setRequirements(ArrayList<Research> requirements) {
		this.requirements = requirements;
	}

}
