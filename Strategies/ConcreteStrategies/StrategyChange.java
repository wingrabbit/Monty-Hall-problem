package cards.Strategies.ConcreteStrategies;

import cards.Strategies.Strategy;

public class StrategyChange implements Strategy {

	@Override
	public int setCard(int chosenCard, int otherCard) {
		return otherCard;
	}

}
