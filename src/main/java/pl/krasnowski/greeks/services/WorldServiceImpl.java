package pl.krasnowski.greeks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pl.krasnowski.greeks.dao.IsleDAO;
import pl.krasnowski.greeks.dao.WorldDAO;
import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.City;
import pl.krasnowski.greeks.model.world.Isle;
import pl.krasnowski.greeks.model.world.IsleTemplate;
import pl.krasnowski.greeks.model.world.World;
import pl.krasnowski.greeks.model.world.WorldType;
import pl.krasnowski.greeks.dao.*;

@Service
public class WorldServiceImpl implements WorldService {
	final static Logger debugLog = LoggerFactory.getLogger("debugLogger");
	final static Logger resultLog = LoggerFactory.getLogger("resultsLogger");
	@Autowired
	WorldDAO wDAO;

	@Autowired
	IsleDAO iDAO;

	@Autowired
	IsleTemplateDAO iTemplateDAO;

	@Autowired
	CityDAO cDAO;

	@Override
	public World createWorld(World world) {
		World newWorld = null;

		try {
			newWorld = wDAO.findByCountryCodeAndWorldCode(world.getCountryCode(), world.getWorldCode()).get(0);
			resultLog.warn(newWorld.toString() + " already exist!");
			return newWorld;
		} catch (IndexOutOfBoundsException e) {
			newWorld = new World(world.getCountryCode(), world.getWorldCode(), world.getName(), world.getWorldType());
			List<Isle> newIsles = new ArrayList<>();
			if (world.getWorldType() == null) // TODO usunac w przyszlosci
				world.setWorldType(WorldType.NORMAL);

			for (IsleTemplate isleTemplate : iTemplateDAO.findAll()) {
				Isle newIsle = new Isle(isleTemplate);
				if (newWorld.getWorldType().equals(WorldType.SPEED)) {
					newIsle.setLuxLvl(5);
					newIsle.setSawmillLvl(5);
				}
				newIsles.add(newIsle);
			}
			iDAO.saveAll(newIsles);
			newWorld.addIsles(newIsles);
			return wDAO.save(newWorld);
		}
	}

	@Override
	public World loadWorld(String countryCode, String worldCode) {
		return wDAO.findByCountryCodeAndWorldCode(countryCode, worldCode).get(0);
	}

	@Override
	public World updateWorld(World world) {
		return wDAO.save(world);
	}

	@Override
	public void deleteWorld(World world) {
		// iDAO.deleteWorldIsles(world);
		wDAO.delete(world);
	}

	@Override
	public List<City> getWorldsCities(World world) {
		Map<String, Isle> map = world.getMap();
		List<City> cities = new ArrayList<>();
		for (Entry<String, Isle> entry : map.entrySet()) {
			Isle isle = entry.getValue();
			cities.addAll(isle.getCities());
		}
		return cities;
	}

	/**
	 * Add player to World and set default values of {@link Player} depend of choosed world for eg. Speed server sets faster movement of units/building speed.
	 * 
	 * @param player
	 *            - Member of world
	 * @param world
	 * @since 1.0
	 */
	@Override
	public Player addPlayerToWorld(Player player, World world) {
		player.setWorld(world);
		List<Player> lPlayers = world.getPlayers();
		if (lPlayers.contains(player))
			resultLog.warn("Player " + player.getNick() + " already exist in this world!");
		else {
			switch (world.getWorldType()) {
			case SPEED: {
				player.setMerchantShipsSpeed(1.25);
				player.setShipsBuildingTimeFactor(1.1);
				player.setTroopsBuildingTimeFactor(1.1);
			}
			case NORMAL: {
				break;// default values are set in class Player
			}
			case WAR: {
				player.setTroopsBuildingTimeFactor(1.3);
				player.setShipsBuildingTimeFactor(1.3);
				player.setBuildingConstructionTimeFactor(1.3);

				player.setTroopsSpeed(1.3);
				player.setWarShipsSpeed(1.3);
				player.setMerchantShipsSpeed(1.3);

				player.setResearchPointsFactor(1.3);
				player.setWoodProductionFactor(1.3);
				player.setWineProductionFactor(1.3);
				player.setMarbleProductionFactor(1.3);
				player.setCrystalProductionFactor(1.3);
				player.setSulphurProductionFactor(1.3);
			}
				break;
			default:
				break;
			}
		}
		return player;
	}

	@Override
	public List<World> getWorlds() {
		return Lists.newArrayList(wDAO.findAll());
	}

	@Override
	public World loadWorldByID(int id) {
		return wDAO.findById(id).orElse(null);
	}

}
