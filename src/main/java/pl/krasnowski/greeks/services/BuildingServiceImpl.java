package pl.krasnowski.greeks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.krasnowski.greeks.dao.BuildingDAO;
import pl.krasnowski.greeks.model.buildings.ABuilding;
import pl.krasnowski.greeks.model.world.City;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingDAO buildingDAO;


	@Transactional
	@Override
	public ABuilding getLvl(String entityName, int lvl) {
		return buildingDAO.getLvl(entityName, lvl);
	}

	@Transactional
	@Override
	public ABuilding getLvl(Class<?> building, int lvl) {
		return buildingDAO.getLvl(building.getSimpleName(), lvl);
	}

	@Transactional
	@Override
	public List<ABuilding> listBuildings(String buildingName) {
		return buildingDAO.showBuilding(buildingName);
	}

	@Transactional
	@Override
	public List<ABuilding> listBuildings(Class<?> building) {
		return buildingDAO.showBuilding(building.getSimpleName());
	}

	

	public void setDefaultValues(List<City> cities) { // move to services
	//	Townhall th;
		// dodanie ratusza 1lvl

//		actionPoints = 3;
//		goldBalance = 120;
//		corruption = (cities.size()) / (cities.size() + 1); // -1+1 and +1 because city was not added to list yet
//		population = 40;
//		happiness = (int) (156 * (1 - corruption));
//		sawmillWorkers = LuxWorkers = scientists = priests = 0;
//		idlers = 40;
	}
	
	
	// @SuppressWarnings("unlikely-arg-type")
	// public void addBuilding(ABuilding building) { 
	//
	// if (building.equals(TownWall.class))
	// if (lbuildings.get(wallID).getLvl() < wallmaxLvL)
	// lbuildings.set(wallID, bDao.getLvl("Wall", 1));
	// else {
	// System.out.println("Reached maximum lvl of wall!");
	// }
	// else if (building.equals(PirateFortress.class))
	//
	// if (lbuildings.get(pFID).getLvl() < pFmaxLvl)
	// lbuildings.set(pFID, bDao.getLvl("PirateFortress", 1));
	// else {
	// System.out.println("Reached maximum lvl of Pirate Fortress!");
	// }
	// else if (building.equals(TradingPort.class) || building.equals(Shipyard.class))
	// if (sbuildings.size() < sBuildingsPlaces)
	// sbuildings.add(building);
	// else
	// System.out.println("Shore have only 2 places for buildings!");
	//
	// else if (building.equals(Townhall.class)) {
	// if (lbuildings.get(townHID).getLvl() < townMaxLvl)
	// lbuildings.set(townHID, bDao.getLvl("Townhall", 1));
	// else {
	// System.out.println("Reached maximum lvl of Pirate Fortress!");
	// }
	// } else if (sbuildings.size() < lBuildingsPlaces)
	// lbuildings.add(building);
	// else
	// System.out.println("City have all fields reserved!");
	// }
}
