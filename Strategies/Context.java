package cards.Strategies;

public class Context {
	
	private Strategy strategy;
	
	public void setStrategy(Strategy strategy)
	{
		this.strategy = strategy;
	}
	
	public int executeStrategy(int chosenCard, int otherCard)
	{
		return strategy.setCard(chosenCard, otherCard);
	}

}
