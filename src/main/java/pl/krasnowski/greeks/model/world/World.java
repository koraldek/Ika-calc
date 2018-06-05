package pl.krasnowski.greeks.model.world;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import pl.krasnowski.greeks.model.users.Player;

@Entity(name = "Worlds")
public class World {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	protected int world_ID;

	@Column
	protected String countryCode, name, worldCode;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "world_fk_Map")
	protected Map<String, Isle> worldMap;

	@JoinColumn(name = "world_fk_Players")
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	protected List<Player> players;

	@Column
	protected Date startTime;

	@Enumerated(EnumType.STRING)
	WorldType worldType;

	public World() {
	}

	public World(String countryCode, String worldCode, String name, WorldType worldType) {
		this.name = name;
		this.worldCode = worldCode;
		this.countryCode = countryCode;
		this.worldType = worldType;
		worldMap = new HashMap<String, Isle>();
		players = new ArrayList<Player>();
		startTime = new Date();
	}



	@Override
	public String toString() {
		return "World [world_ID=" + world_ID + ", countryCode=" + countryCode + ", name=" + name + ", worldCode=" + worldCode + ", worldMap=" + worldMap + ", players=" + players + ", startTime="
				+ startTime + ", worldType=" + worldType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + world_ID;
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
		World other = (World) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (world_ID != other.world_ID)
			return false;
		return true;
	}

	public Map<String, Isle> getMap() {
		return worldMap;
	}

	public Isle getIsle(String coords) {
		return worldMap.get(coords);
	}

	public void addIsle(Isle isle) {
		this.worldMap.put(isle.getCoords(), isle);
	}

	public void addIsles(List<Isle> isles) {
		Map<String, Isle> mIsles = new HashMap<String, Isle>();
		for (Isle isle : isles) {
			mIsles.put(isle.getCoords(), isle);
		}
		this.worldMap.putAll(mIsles);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getPlayer(String nick) {
		for (Player pl : players)
			if (pl.getNick().equals(nick))
				return pl;
		return null;
	}

	public Player addPlayer(Player player) {
		this.players.add(player);
		return player;
	}

	public int getWorld_ID() {
		return world_ID;
	}

	public void setWorld_ID(int world_ID) {
		this.world_ID = world_ID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorldCode() {
		return worldCode;
	}

	public void setWorldCode(String worldCode) {
		this.worldCode = worldCode;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setWorldType(WorldType worldType) {
		this.worldType = worldType;
	}

	public WorldType getWorldType() {
		return worldType;
	}

}
