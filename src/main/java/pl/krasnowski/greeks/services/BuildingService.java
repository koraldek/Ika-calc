package pl.krasnowski.greeks.services;

import java.util.List;

import pl.krasnowski.greeks.model.buildings.ABuilding;

public interface BuildingService {

	ABuilding getLvl(String building, int lvl);

	ABuilding getLvl(Class<?> building, int lvl);

	List<ABuilding> listBuildings(String buildingName);

	List<ABuilding> listBuildings(Class<?> building);
}
