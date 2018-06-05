package pl.krasnowski.greeks.model.world;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 * coordinates: xCoord:yCoord - format value: for eg. 03:50
 */
@Entity(name = "Isle")
public class Isle {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int isle_ID;

	@Column
	private boolean isHeliosTower, HeliosTowerDonated;
	@Column
	private int luxLvl, sawmillLvl, wonderlvl, barbarianLvl;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "isleTemplate_ID")
	private IsleTemplate iTmpl;

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<City> cities;

	public Isle() {
	}

	public Isle(boolean isHeliosTower, boolean heliosTowerDonated, int luxLvl, int sawmillLvl, int wonderlvl, int barbarianLvl, IsleTemplate iTmpl, ArrayList<City> cities) {
		this.isHeliosTower = isHeliosTower;
		HeliosTowerDonated = heliosTowerDonated;
		this.luxLvl = luxLvl;
		this.sawmillLvl = sawmillLvl;
		this.wonderlvl = wonderlvl;
		this.barbarianLvl = barbarianLvl;
		this.iTmpl = iTmpl;
		this.cities = cities;
	}

	public Isle(IsleTemplate iTmpl) {
		this.isHeliosTower = false;
		HeliosTowerDonated = false;
		this.luxLvl = 1;
		this.sawmillLvl = 1;
		this.wonderlvl = 1;
		this.barbarianLvl = 1;
		this.iTmpl = iTmpl;
		this.cities = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Isle [isle_ID=" + isle_ID + ", isHeliosTower=" + isHeliosTower + ", HeliosTowerDonated=" + HeliosTowerDonated + ", luxLvl=" + luxLvl + ", sawmillLvl=" + sawmillLvl + ", wonderlvl="
				+ wonderlvl + ", barbarianLvl=" + barbarianLvl + ", iTmpl=" + iTmpl + ", cities=" + cities + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iTmpl == null) ? 0 : iTmpl.hashCode());
		result = prime * result + isle_ID;
		result = prime * result + luxLvl;
		result = prime * result + sawmillLvl;
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
		Isle other = (Isle) obj;
		if (iTmpl == null) {
			if (other.iTmpl != null)
				return false;
		} else if (!iTmpl.equals(other.iTmpl))
			return false;
		if (isle_ID != other.isle_ID)
			return false;
		if (luxLvl != other.luxLvl)
			return false;
		if (sawmillLvl != other.sawmillLvl)
			return false;
		return true;
	}

	public int getIsleID() {
		return isle_ID;
	}

	public boolean isHeliosTower() {
		return isHeliosTower;
	}

	public void setHeliosTower(boolean isHeliosTower) {
		this.isHeliosTower = isHeliosTower;
	}

	public boolean isHeliosTowerDonated() {
		return HeliosTowerDonated;
	}

	public void setHeliosTowerDonated(boolean heliosTowerDonated) {
		if (isHeliosTower())
			HeliosTowerDonated = heliosTowerDonated;
	}

	public int getLuxLvl() {
		return luxLvl;
	}

	public void setLuxLvl(int luxLvl) {
		this.luxLvl = luxLvl;
	}

	public int getSawmillLvl() {
		return sawmillLvl;
	}

	public void setSawmillLvl(int sawmillLvl) {
		this.sawmillLvl = sawmillLvl;
	}

	public int getWonderlvl() {
		return wonderlvl;
	}

	public void setWonderlvl(int wonderlvl) {
		this.wonderlvl = wonderlvl;
	}

	public int getBarbarianLvl() {
		return barbarianLvl;
	}

	public void setBarbarianLvl(int barbarianLvl) {
		this.barbarianLvl = barbarianLvl;
	}

	public List<City> getCities() {
		return cities;
	}

	public void addCity(City city) {
		this.cities.add(city);
	}

	public void deleteCity(City city) {
		this.cities.remove(city);
	}

	public String getIsleName() {
		return iTmpl.name;
	}

	public String getCoords() {
		return iTmpl.coords;
	}

	public Stock getLuxuryGood() {
		return iTmpl.luxuryGood;
	}

	public Wonder getWonder() {
		return iTmpl.wonder;
	}

}
