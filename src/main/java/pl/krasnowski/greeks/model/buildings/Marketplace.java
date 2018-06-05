package pl.krasnowski.greeks.model.buildings;

import pl.krasnowski.greeks.model.world.Stock;


@Deprecated
public class Marketplace extends ABuilding {
	
	public Marketplace() {
		super();
	}
	
	// check prices of goods
	public void checkMarket() {
		for(Stock stock : Stock.values()) { //TODO: there are constants values!
			int bPrice = 7;
			int sPrice = 5;
			stock.setMarketBuyPrice(bPrice);
			stock.setMarketSellPrice(sPrice);
		}
	}
	
	
	

}
