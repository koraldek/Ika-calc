package pl.krasnowski.greeks.model.api;

public class LoginCriteria {

	String username;
	String password;
	String countryCode;
	String worldCode;
	String remember;

	public LoginCriteria(String username, String password, String countryCode, String worldCode, String remember) {
		super();
		this.username = username;
		this.password = password;
		this.countryCode = countryCode;
		this.worldCode = worldCode;
		this.remember = remember;
	}

	@Override
	public String toString() {
		return "LoginCriteria [username=" + username + ", password=" + password + ", countryCode=" + countryCode + ", worldCode=" + worldCode + ", remember=" + getRemember() + "]";
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getWorldCode() {
		return worldCode;
	}

	public void setWorldCode(String worldCode) {
		this.worldCode = worldCode;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

}
