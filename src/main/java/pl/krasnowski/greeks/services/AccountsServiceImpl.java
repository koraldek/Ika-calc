package pl.krasnowski.greeks.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.krasnowski.greeks.dao.AccountDAO;
import pl.krasnowski.greeks.model.forms.LoginForm;
import pl.krasnowski.greeks.model.forms.RegisterForm;
import pl.krasnowski.greeks.model.users.Account;
import pl.krasnowski.greeks.model.users.Player;

@Service
public class AccountsServiceImpl implements AccountsService {
	final static Logger debugLog = LoggerFactory.getLogger("debugLogger");
	final static Logger resultLog = LoggerFactory.getLogger("resultsLogger");

	@Autowired
	AccountDAO accDao;

	@Autowired
	WorldService worldService;

	@Override
	public boolean validateServerAccount(LoginForm loginForm) {
		debugLog.info("Validating server user:" + loginForm.getUsername());
		Account acc;
		try {
			acc = accDao.findByNickOrEmailAllIgnoreCase(loginForm.getUsername(), loginForm.getUsername()).get(0);
		} catch (IndexOutOfBoundsException ex) {
			debugLog.info("Account name or email not found.");
			return false;
		}
		if (!acc.getPassword().equals(loginForm.getPassword())) {
			debugLog.info("Password is incorrect!.");
			return false;
		} else
			return true;
	}

	@Override
	public Account loginToServer(LoginForm loginForm) {
		resultLog.info(("Logging user to server:" + loginForm.getUsername()));
		Account acc;
		try {
			acc = accDao.findByNickOrEmailAllIgnoreCase(loginForm.getUsername(), loginForm.getUsername()).get(0);
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
		return acc;

	}

	@Override
	public Player loginToGame(Player player) {
		resultLog.info("Loguje do gry uzytkownika:" + player.toString());
		// TODO: logowanie do gry
		return player;
	}

	@Override
	public void disconnectFromServer(Account acc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void disconnetFromGame(Player acc) {
		// TODO Auto-generated method stub
	}

	@Override
	public Player registerToServer(RegisterForm regForm) {
		Player newPlayer = null;
		debugLog.info("Registering to server user:" + regForm.getUsername());
		try {
			newPlayer = (Player) accDao.findByNickOrEmailAllIgnoreCase(regForm.getUsername(), regForm.getEmail()).get(0);
		} catch (IndexOutOfBoundsException ex) {
			// if (rCriteria.getAccType().equals("player")) {
			newPlayer = accDao.save(new Player(regForm.getUsername(), regForm.getEmail(), regForm.getPassword()));
			worldService.addPlayerToWorld(newPlayer, worldService.loadWorldByID(regForm.getWorld_ID()));
			resultLog.info("Player " + regForm.getUsername() + " succesfuly registered.");
			return newPlayer;
			// } else if (rCriteria.getAccType().equals("admin"))
			// return aDao.save(new Admin(rCriteria.getUsername(), rCriteria.getEmail(), rCriteria.getPassword()));
			// else {
			// debugLog.warn("Unknown account type");
			// return null;
		}
		// }
		debugLog.warn("Username or email already exist!");
		return newPlayer;
	}

	@Override
	public Player registerToGame(Player player) {
		// TODO: znalezc sposob na rejestrowanie
		debugLog.debug("Registering to game");
		return player;
	}

	@Override
	public void SetRememberMeCookies(Account acc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAccount(Account acc) {
		accDao.delete(acc);
		debugLog.info("Deleted user:" + acc.getNick());
	}

}
