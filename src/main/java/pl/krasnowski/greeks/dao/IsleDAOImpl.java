package pl.krasnowski.greeks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.krasnowski.greeks.model.world.Isle;
import pl.krasnowski.greeks.model.world.IsleTemplate;
import pl.krasnowski.greeks.model.world.World;

public class IsleDAOImpl implements IsleDAO {

	private static final Logger logger = LoggerFactory.getLogger(IsleDAOImpl.class);
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addIsleTemplate(IsleTemplate isleTemplate) {
		em.persist(isleTemplate);
		logger.info("Isle template saved successfully, Isle template details=" + isleTemplate.toString());
	}

	@Override
	public List<IsleTemplate> getIsleTemplates() {
		TypedQuery<IsleTemplate> q = em.createQuery("SELECT it FROM IsleTemplate it" , IsleTemplate.class);
		return q.getResultList();
	}

	@Override
	public IsleTemplate getIsleTemplate(String coords) {
		return (IsleTemplate) em.createQuery("SELECT it FROM IsleTemplate it WHERE coords=" + coords).getSingleResult();
	}

	@Override
	public void updateIsleTemplate(IsleTemplate isleTemplate) {
		em.merge(isleTemplate);
	}

	@Override
	public void addIsle(Isle isle) {
		em.persist(isle);
		logger.info("Isle saved successfully, Isle details=" + isle.toString());
	}

	@Override
	public void updateIsle(Isle isle) {
		em.merge(isle);
	}

	@Override
	public void deleteIsle(Isle isle) {
		em.remove(isle);
		logger.info("Isle deleted successfully, isle details=" + isle);
	}


	@Override
	public Isle getIsle(World world,String coords) {
		TypedQuery<Isle> q = em.createNamedQuery("SELECT i FROM Isle i WHERE i.world_fk_map= :worldID AND i.coords= :coords", Isle.class);
		q.setParameter("worldID", world.getWorld_ID());
		q.setParameter("coords", coords);
		return q.getSingleResult();
	}

	@Override
	public List<Isle> getIsles(World world) {
		TypedQuery<Isle> q = em.createQuery("Select i FROM Isle i WHERE i.world_fk_map= :worldID", Isle.class);
		q.setParameter("worldID", world.getWorld_ID());
		return q.getResultList();
	}

}
