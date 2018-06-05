package pl.krasnowski.greeks.model.world;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "IsleTemplates")
public class IsleTemplate {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int isleTemplate_ID;

	@Column
	protected String name, coords;
	@Column
	protected Stock luxuryGood;
	@Column
	protected Wonder wonder;

	public IsleTemplate() {
	}

	public IsleTemplate(String name, String coords, Stock luxuryGood, Wonder wonder) {
		super();
		this.name = name;
		this.coords = coords;
		this.luxuryGood = luxuryGood;
		this.wonder = wonder;
	}

	@Override
	public String toString() {
		return "IsleTemplate [IsleTemplate_ID=" + isleTemplate_ID + ", name=" + name + ", coords=" + coords + ", luxuryGood=" + luxuryGood + ", wonder=" + wonder + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coords == null) ? 0 : coords.hashCode());
		result = prime * result + ((luxuryGood == null) ? 0 : luxuryGood.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((wonder == null) ? 0 : wonder.hashCode());
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
		IsleTemplate other = (IsleTemplate) obj;
		if (coords == null) {
			if (other.coords != null)
				return false;
		} else if (!coords.equals(other.coords))
			return false;
		if (luxuryGood != other.luxuryGood)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (wonder != other.wonder)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public String getCoords() {
		return coords;
	}

	public Stock getLuxuryGood() {
		return luxuryGood;
	}

	public Wonder getWonder() {
		return wonder;
	}

}
