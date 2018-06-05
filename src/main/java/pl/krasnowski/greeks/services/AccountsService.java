package pl.krasnowski.greeks.services;

import pl.krasnowski.greeks.model.forms.LoginForm;
import pl.krasnowski.greeks.model.forms.RegisterForm;
import pl.krasnowski.greeks.model.users.Account;
import pl.krasnowski.greeks.model.users.Player;

public interface AccountsService {

	boolean validateServerAccount(LoginForm loginForm);

	Account loginToServer(LoginForm loginCriteria);

	Player loginToGame(Player acc);

	void disconnectFromServer(Account acc);

	void disconnetFromGame(Player acc);

	Player registerToServer(RegisterForm registerCriteria);

	Player registerToGame(Player player);

	void deleteAccount(Account acc);

	/**
	 * Create cookies in browser to remember account data
	 * 
	 * @param account
	 *            object
	 */
	void SetRememberMeCookies(Account account);
}
