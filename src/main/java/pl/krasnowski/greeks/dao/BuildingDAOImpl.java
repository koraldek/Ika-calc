package pl.krasnowski.greeks.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.krasnowski.greeks.model.buildings.ABuilding;

@Transactional
@Repository
public class BuildingDAOImpl implements BuildingDAO {

	@PersistenceContext
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(BuildingDAOImpl.class);

	@Override
	public ABuilding getLvl(String buildingName, int lvl) {
		ABuilding building = null;

		Query q = em.createQuery("SELECT b FROM " + buildingName + " b " + "WHERE b.lvl = :lvl");
		q.setParameter("lvl", lvl);
		building = (ABuilding) q.getSingleResult();

		logger.info(building.toString() + " retrieved succesfully.");
		return building;
	}

	@Override
	public List<ABuilding> showBuilding(String buildingName) {
		TypedQuery<ABuilding> q = em.createQuery("SELECT b FROM " + buildingName + " b", ABuilding.class);
		List<ABuilding> result = q.getResultList();
		logger.info(buildingName + " retrieved successfully.");
		return result;
	}

	@Override
	public <S extends ABuilding> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Deprecated
	@Override
	public <S extends ABuilding> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	@Override
	public Optional<ABuilding> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Deprecated
	@Override
	public Iterable<ABuilding> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated

	@Override
	public Iterable<ABuilding> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Deprecated
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
	}

	@Deprecated

	@Override
	public void delete(ABuilding entity) {
		// TODO Auto-generated method stub

	}

	@Deprecated

	@Override
	public void deleteAll(Iterable<? extends ABuilding> entities) {
		// TODO Auto-generated method stub

	}

	@Deprecated
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
