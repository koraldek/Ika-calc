package pl.krasnowski.greeks.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.City;
import pl.krasnowski.greeks.model.world.Isle;

public interface CityDAO extends CrudRepository<City, Integer> {

	@Query("SELECT c FROM City c WHERE c.owner=:owner")
	List<City> getPlayerCities(@Param("owner") Player player);

	@Query("SELECT c FROM City c WHERE c.isle=:isle")
	List<City> getIsleCities(@Param("isle") Isle isle);

}
