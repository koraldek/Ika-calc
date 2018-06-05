package pl.krasnowski.greeks.model.api;

import java.util.Date;

public class Zdarzenie {
	Date data;
	static int nastepnyNumer = 1;
	int numer;
	String opis;

	public Zdarzenie(Date data, String opis) {
		this.data = data;
		this.opis = opis;
		this.numer = nastepnyNumer;
		nastepnyNumer++;
	}

	@Override
	public String toString() {
		return "Zdarzenie [numer=" + numer + ", data=" + data + ", opis=" + opis + "]";
	}

}
