package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cards.Strategies.Context;
import cards.Strategies.ConcreteStrategies.StrategyChange;
import cards.Strategies.ConcreteStrategies.StrategyKeep;
import cards.Strategies.ConcreteStrategies.StrategyRandom;

public class MainClass {
	
	public static void main(String[] args)
	{		
		int cardsCount = 3;
		
		int expCount = 100000000;
		
		Random random = new Random();
		
		Context context = new Context();
		
		int keepSuccess = 0, changeSuccess = 0, randomSuccess = 0; 
		
		for(int i=0; i<expCount; i++)
		{
			int chosenCard = random.nextInt(cardsCount);			//the card that has been chosen by the player;
			int realCard = random.nextInt(cardsCount);			//the right card
			int otherCard = getLeftCard(cardsCount, chosenCard, realCard);	//the card that is left after removal of all the excess cards
			
			context.setStrategy(new StrategyKeep());						
			if(context.executeStrategy(chosenCard, otherCard)==realCard)	//the player keeps his card
				keepSuccess++;
			
			context.setStrategy(new StrategyChange());
			if(context.executeStrategy(chosenCard, otherCard)==realCard)	//the player changes his card
				changeSuccess++;
			
			context.setStrategy(new StrategyRandom());
			if(context.executeStrategy(chosenCard, otherCard)==realCard)	//the player tries to guess
				randomSuccess++;
		}
		
		double keepPercentage = ((double)keepSuccess / (double)expCount)*100;
		double changePercentage = ((double)changeSuccess / (double)expCount)*100;
		double randomPercentage = ((double)randomSuccess / (double)expCount)*100;
		
		System.out.println("the player keeps his card: " + keepPercentage + "%");
		System.out.println("the player cnahges his card: " + changePercentage + "%");
		System.out.println("the player guesses: " + randomPercentage + "%");
	}
	
	private boolean checkWin(int chosenCard, int realCard)
	{
		return (chosenCard==realCard ? true : false);
	}
	
	private static int getLeftCard (int cardsCount, int chosenCard, int realCard)
	{
		if(chosenCard==realCard)		//the player has chosen the right card, randomly leave one wrong card
		{
			List<Integer> leftCards = new ArrayList<Integer>();
			for(int i=0; i<cardsCount; i++)
				if((i!=chosenCard)&&(i!=realCard))
					leftCards.add(i);		
			return leftCards.get(new Random().nextInt(leftCards.size()));
		}
		else return realCard;			//the player has chosen the wrong card, leave the right card
	}

}
