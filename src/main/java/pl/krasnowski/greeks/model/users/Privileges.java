package pl.krasnowski.greeks.model.users;

enum Privileges {
	GUEST(0), BANNED(1), PLAYER(2), ADMIN(3);

	private int privType;

	private Privileges(int n) {
		privType = n;
	}

	public int getPrivType() {
		return privType;
	}

	public void setPrivType(int privType) {
		this.privType = privType;
	}

}