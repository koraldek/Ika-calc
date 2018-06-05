package pl.krasnowski.greeks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.krasnowski.greeks.model.users.Account;
import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.World;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);

	@PersistenceContext
	EntityManager em;

	public void addAccount(Account acc) {
		em.persist(acc);
		logger.info("Account saved successfully, Account details=" + acc.toString());
	}

	@Override
	public Account getByNickOrEmail(String name) {
		Account account = null;
		Query q = em.createQuery("Select a FROM Accounts a WHERE a.nick = :nick OR a.email = :email");
		q.setParameter("nick", name);
		q.setParameter("email", name);
		try {
			account = (Account) q.getSingleResult();
		} catch (NoResultException e) {
			logger.error("User of name or email:" + name + " not found!");
			e.getStackTrace();
		}
		logger.info("Account loaded successfully, Account details=" + account);
		return account;
	}

	@Override
	public List<Player> getAccounts() {
		TypedQuery<Player> q = em.createNamedQuery("SELECT p FROM Player p", Player.class);
		List<Player> result =  q.getResultList();
		logger.info("Founded " + result.size()  +" accounts.");
		return result;
	}

	@Override
	public List<Player> getWorldsAccounts(World world) {
		TypedQuery<Player> q = em.createNamedQuery("SELECT p FROM Player p WHERE p.World_fk= :world_fk", Player.class);
		q.setParameter("world_fk", world.getWorld_ID());
		List<Player> result =  q.getResultList();
		logger.info("Founded " + result.size()  +" accounts.");
		return result;
	}

	@Override
	public void updateAccount(Account acc) {
		em.merge(acc);
	}

	@Override
	public void deleteAccount(Account acc) {
		em.remove(acc);
		logger.info("Account " + acc.getNick() + " successfully deleted.");
	}
	


}
