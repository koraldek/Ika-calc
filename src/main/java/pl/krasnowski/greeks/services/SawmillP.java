package pl.krasnowski.greeks.services;

import org.springframework.beans.factory.annotation.Autowired;

import pl.krasnowski.greeks.dao.BuildingDAO;
import pl.krasnowski.greeks.model.buildings.Sawmill;
import pl.krasnowski.greeks.model.users.Player;

public class SawmillP implements Profit {
	
	@Autowired
	static
	BuildingDAO buildingDAO;

	public static double pForSawmill(Player user, int x) {

//		Sawmill sawmill = (Sawmill) buildingDAO.getLvl("Sawmill", 12);
		 
//		int nWood = sawmill.getnWood();
//		long nTime = sawmill.getnTime();
		
		return 0;
	}
	
	
	public double calculateProfit(Class<?> building, int lvl) {
		double result = 0;
		
		if(building.equals(Sawmill.class)) {
			
		}
		return result;
	}

}
