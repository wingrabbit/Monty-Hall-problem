package cards.Strategies.ConcreteStrategies;

import cards.Strategies.Strategy;

public class StrategyKeep implements Strategy {

	@Override
	public int setCard(int chosenCard, int otherCard) {
		return chosenCard;
	}
	
	

}
