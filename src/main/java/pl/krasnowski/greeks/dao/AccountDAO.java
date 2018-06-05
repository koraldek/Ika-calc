package pl.krasnowski.greeks.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.krasnowski.greeks.model.users.Account;
import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.World;

@Transactional
public interface AccountDAO extends CrudRepository<Account, Integer> {

	List<Account> findByNickOrEmailAllIgnoreCase(String nick, String email);

	@Query("SELECT p FROM Player p WHERE p.world=:world")
	List<Player> findWorldPlayers(@Param("world") World world);
}
