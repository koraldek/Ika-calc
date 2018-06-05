package pl.krasnowski.greeks.model.world;

public enum Wonder { // TODO get set lvl
	ARES(12.0, 72.0), HADES(16.0, 96.0), HEPHAISTOS(24.0, 168.0), 
	DEMETER(36.0, 216.0), ATHENE(24.0, 168.0), HERMES(4.0, 24.0), 
	POSEIDON(4.0, 24.0), COLOSSUS(0.0, 72.0);
	
	private final double duration, cooldown;

	Wonder(double duration, double cooldown) {
		this.duration = duration;
		this.cooldown = cooldown;
	}

	public double getCooldown() {
		return cooldown;
	}

	public double getDuration() {
		return duration;
	}
	
	//TODO: dodac implementacje dzialania cudow. ( potrzebny bedzie dostep do zmiennych globalnych konta

}
