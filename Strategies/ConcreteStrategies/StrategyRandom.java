package cards.Strategies.ConcreteStrategies;

import java.util.Random;

import cards.Strategies.Strategy;

public class StrategyRandom implements Strategy {

	@Override
	public int setCard(int chosenCard, int otherCard) {
		return (new Random().nextInt(2)==0 ? chosenCard : otherCard);
	}

}
