package pl.krasnowski.greeks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.City;
import pl.krasnowski.greeks.model.world.Isle;

public class CityDAOImpl implements CityDAO {
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public void addCity(City city) {
		em.persist(city);
	}

	@Override
	public List<City> getPlayerCities(Player player) { //TODO: przetestować
		TypedQuery<City> q = em.createQuery("SELECT c FROM City c WHERE c.City_fk_player = :playerID" , City.class);
		q.setParameter("playerID", player.getAccount_id());
		return q.getResultList();
	}
	
	public List<City> getIsleCities(Isle isle) {
		TypedQuery<City> q = em.createQuery("SELECT c FROM City c WHERE c.City_fk_isle = :isleID" , City.class);
		q.setParameter("isleID", isle.getIsleID());
		return q.getResultList();
	}

	@Override
	public void updateCity(City city) {
		em.merge(city);
	}

	@Override
	public void deleteCity(City city) {
		em.remove(city);
	}

}
