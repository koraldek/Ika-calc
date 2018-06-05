package pl.krasnowski.greeks.services;

import java.util.List;

import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.City;
import pl.krasnowski.greeks.model.world.World;

public interface WorldService {
	// World createWorld(String countryCode, String worldCode, String name, WorldType worldType);
	World createWorld(World world);

	World loadWorld(String countryCode, String worldCode);
	
	World loadWorldByID(int id);

	World updateWorld(World world);

	void deleteWorld(World world);

	Player addPlayerToWorld(Player player, World world);

	List<City> getWorldsCities(World world);

	List<World> getWorlds();
	
	
}
