package pl.krasnowski.greeks.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.World;
import pl.krasnowski.greeks.services.WorldService;

@Configuration
public class Config {

	@Autowired(required = false)
	List<World> worldsList = new ArrayList<>();

	@Autowired
	WorldService worldService;

	@Bean
	@Scope(value = "session")
	public Player getPlayer() {
		Player player = null;
		return player;
	}

	@Bean
	@Scope(value = "singleton")
	public List<World> getWorldsList() {
//		List<World> testWorldList = new ArrayList<World>() {
//			{
//				add(new World("pl", "s31", "imie1", WorldType.NORMAL));
//				add(new World("en", "s01", "imie2", WorldType.NORMAL));
//				add(new World("pl", "s03", "imie3", WorldType.SPEED));
//			}
//		};
//		worldsList = testWorldList;
		if (worldsList.isEmpty())
			worldsList = worldService.getWorlds();
		return worldsList;
	}

}
