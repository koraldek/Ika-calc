package pl.krasnowski.greeks.model.users;

import javax.persistence.Entity;

@Entity
public class Admin extends Account {

	public Admin() {
	}

	public Admin(String nick, String password, String email) {
		super(nick, password, email);
		privileges = Privileges.ADMIN;
	}
	
	
	
}
