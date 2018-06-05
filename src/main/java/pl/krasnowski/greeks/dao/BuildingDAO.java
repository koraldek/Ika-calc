package pl.krasnowski.greeks.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.krasnowski.greeks.model.buildings.ABuilding;

@Transactional
public interface BuildingDAO extends CrudRepository<ABuilding, Integer> { // TODO: zamienic implementacje na interfejs crud

//	@Query("SELECT b FROM :entityName b WHERE b.lvl=:lvl")
	ABuilding getLvl(@Param("entityName") String entityName, @Param("lvl") int lvl);

//	@Query("SELECT b FROM :entityName")
	List<ABuilding> showBuilding(@Param("entityName") String buildingName);
}
