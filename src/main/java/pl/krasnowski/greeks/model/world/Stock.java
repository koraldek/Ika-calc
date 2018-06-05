package pl.krasnowski.greeks.model.world;

public enum Stock {
	WOOD, WINE, MARBLE, CRYSTAL, SULPHUR;

	private int marketBuyPrice, marketSellPrice;

	public int getMarketBuyPrice() {
		return marketBuyPrice;
	}

	public void setMarketBuyPrice(int marketBuyPrice) {
		this.marketBuyPrice = marketBuyPrice;
	}

	public int getMarketSellPrice() {
		return marketSellPrice;
	}

	public void setMarketSellPrice(int marketSellPrice) {
		this.marketSellPrice = marketSellPrice;
	}

}
