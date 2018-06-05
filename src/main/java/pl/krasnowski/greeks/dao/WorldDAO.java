package pl.krasnowski.greeks.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.krasnowski.greeks.model.world.World;

public interface WorldDAO extends CrudRepository<World, Integer> {

	List<World> findByCountryCodeAndWorldCode(String countryCode, String worldCode);

}
