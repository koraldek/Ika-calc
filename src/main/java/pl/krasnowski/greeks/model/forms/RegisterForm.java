package pl.krasnowski.greeks.model.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {
	@Size(min = 2, max = 20, message = "Username size should be in the range [2...20]")
	String username;
	@Email(message = "wrong email format")
	String email;
	@NotNull
	@Size(min = 3, max = 30, message = "password size should be in the range [3...30]")
	String password;

	int world_ID;

	Boolean registerToGame;

	Boolean autologin;

	public RegisterForm() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getWorld_ID() {
		return world_ID;
	}

	public void setWorld_ID(int world_ID) {
		this.world_ID = world_ID;
	}

	public Boolean getRegisterToGame() {
		return registerToGame;
	}

	public void setRegisterToGame(Boolean registerToGame) {
		this.registerToGame = registerToGame;
	}

	public Boolean getAutologin() {
		return autologin;
	}

	public void setAutologin(Boolean autologin) {
		this.autologin = autologin;
	}

}
