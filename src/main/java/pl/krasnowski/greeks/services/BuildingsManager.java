package pl.krasnowski.greeks.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.krasnowski.greeks.dao.BuildingDAO;

public class BuildingsManager {

	@Autowired
	BuildingDAO buildingDAO;

	// public ABuilding getByLvl(Class<?> clazz,int lvl) {
	// return buildingDAO.getLvl(clazz, lvl);
	// }

}
