package pl.krasnowski.greeks.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.krasnowski.greeks.model.world.Isle;
import pl.krasnowski.greeks.model.world.World;

@Transactional
public interface IsleDAO extends CrudRepository<Isle, Integer> {

//	@Query("DELETE FROM Isle i WHERE i.isle_ID = world.world_ID")
//	void deleteWorldIsles(@Param("world") World world); //TODO: dokonczyc
}
