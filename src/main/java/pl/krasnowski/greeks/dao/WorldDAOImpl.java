package pl.krasnowski.greeks.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import pl.krasnowski.greeks.model.world.World;

@Repository
public class WorldDAOImpl implements WorldDAO {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public World createWorld(String countryCode, String worldCode, String name) {
		World world;// = new World(countryCode, worldCode, name);
		em.persist(world);
		return world;
	}

	@Transactional
	@Override
	public void updateWorld(World world) {
		em.merge(world);
	}

	@Transactional
	@Override
	public World loadWorld(String countryCode, String worldCode) {
		World world;
		TypedQuery<World> q = em.createNamedQuery("SELECT w FROM World w WHERE w.countryCode= :cc AND w.worldCode = :wc", World.class);
		q.setParameter("cc", countryCode);
		q.setParameter("wc", worldCode);
		try {
			world = q.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}

		return world;
	}

	@Transactional
	@Override
	public void deleteWorld(String countryCode, String worldCode) {
		Query q = em.createQuery("DELETE FROM World w WHERE w.countryCode= :cc AND w.worldCode = :wc");
		q.setParameter("cc", countryCode);
		q.setParameter("wc", worldCode);
		q.executeUpdate();
	}

	@Override
	public <S extends World> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends World> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<World> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<World> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<World> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(World entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends World> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
