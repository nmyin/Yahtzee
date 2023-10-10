/**
 *	Introduce the game here
 *
 *	@author	Nishka Yadav
 *	@since	9/28/2023
 * 
 * take in the player names
 * store it in YahtzeePlayer string name
 * create two instances of the class YahtzeePlayer for each player
 * Each player has name and YahtzeeScoreCard
 * 
 * while two values are equal, keep rolling dice for each player
 * When two values are not equal, set the first player to the one with a bigger total
 * 
 */
 
public class Yahtzee {
	public static void main(String[] args){
		printHeader();
		YahtzeePlayer playerOne = new YahtzeePlayer();
		playerOne.setName(Prompt.getString("Player 1, please enter your first name :"));
		YahtzeePlayer playerTwo = new YahtzeePlayer();
		playerTwo.setName(Prompt.getString("\nPlayer 2, please enter your first name :"));
		
		Prompt.getString("\nLet's see who will go first. " + playerOne.getName() + ", please hit enter to roll the dice :");
		DiceGroup dice = new DiceGroup();
		dice.rollDice();
		dice.printDice();
		int scoreOne = playerOne.getScoreCard().chance(dice);
		
		Prompt.getString("\n" + playerTwo.getName() + ", it's your turn. Please hit enter to roll the dice :");
		dice.rollDice();
		dice.printDice();
		int scoreTwo = playerTwo.getScoreCard().chance(dice);
		
		System.out.println("\n" + playerOne.getName() + ", you rolled a sum of " + scoreOne + ", and " + playerTwo.getName() + ", you rolled a sum of " + scoreTwo + ".");
		if (scoreOne > scoreTwo){
			System.out.println("\n" + playerOne.getName() + ", since your sum was higher, you'll roll first.");
		}
		else
			System.out.println("\n" + playerTwo.getName() + ", since your sum was higher, you'll roll first.");
			
		
		playerOne.getScoreCard().printCardHeader();
		playerOne.getScoreCard().printPlayerScore(playerOne);
		playerTwo.getScoreCard().printPlayerScore(playerTwo);
		
		for (int h = 0; h < 13; h++){
			System.out.println("\nRound " + (h+1) + " of 13 rounds.\n");
			
			Prompt.getString( "\n" + playerOne.getName() + ", it's your turn to play. Please hit enter to roll the dice :");
			int g = 0;
			String exit = "";
			dice.rollDice();
			dice.printDice();
			while (g < 2 && !exit.equals("-1")){
				System.out.println("Which di(c)e would you like to keep? Enter the values you'd like to 'hold' without");
				System.out.println("spaces. For examples, if you'd liket to 'hold' without");
				exit = Prompt.getString("(enter -1 if  you'd like to end the turn) : ");
				if (!exit.equals("-1")){
					dice.rollDice(exit);
					dice.printDice();
				}
				g++;
			}
			playerOne.getScoreCard().printCardHeader();
			playerOne.getScoreCard().printPlayerScore(playerOne);
			playerTwo.getScoreCard().printPlayerScore(playerTwo);
			boolean validCategory = playerOne.getScoreCard().changeScore(Prompt.getInt(playerOne.getName() + ", now you need to make a choice. Pick a valid integer from the list above :"),dice);
			while (!validCategory){
				validCategory = playerOne.getScoreCard().changeScore(Prompt.getInt("Pick a valid integer from the list above :"),dice);
			}
			playerOne.getScoreCard().printCardHeader();
			playerOne.getScoreCard().printPlayerScore(playerOne);
			playerTwo.getScoreCard().printPlayerScore(playerTwo);
			
			
			Prompt.getString( "\n" + playerTwo.getName() + ", it's your turn to play. Please hit enter to roll the dice :");
			g = 0;
			exit = "";
			dice.rollDice();
			dice.printDice();
			while (g < 2 && !exit.equals("-1")){
				System.out.println("Which di(c)e would you like to keep? Enter the values you'd like to 'hold' without");
				System.out.println("spaces. For examples, if you'd liket to 'hold' without");
				exit = Prompt.getString("(enter -1 if  you'd like to end the turn) : ");
				if (!exit.equals("-1")){
					dice.rollDice(exit);
					dice.printDice();
				}
				g++;
			}
			playerOne.getScoreCard().printCardHeader();
			playerOne.getScoreCard().printPlayerScore(playerOne);
			playerTwo.getScoreCard().printPlayerScore(playerTwo);
			validCategory = playerOne.getScoreCard().changeScore(Prompt.getInt(playerTwo.getName() + ", now you need to make a choice. Pick a valid integer from the list above :"),dice);
			while (!validCategory){
				validCategory = playerOne.getScoreCard().changeScore(Prompt.getInt("Pick a valid integer from the list above :"),dice);
			}
			
			playerOne.getScoreCard().printCardHeader();
			playerOne.getScoreCard().printPlayerScore(playerOne);
			playerTwo.getScoreCard().printPlayerScore(playerTwo);
		}
	}
	
	public static void printHeader() {
			System.out.println("\n");
			System.out.println("+------------------------------------------------------------------------------------+");
			System.out.println("| WELCOME TO MONTA VISTA YAHTZEE!                                                    |");
			System.out.println("|                                                                                    |");
			System.out.println("| There are 13 rounds in a game of Yahtzee. In each turn, a player can roll his/her  |");
			System.out.println("| dice up to 3 times in order to get the desired combination. On the first roll, the |");
			System.out.println("| player rolls all five of the dice at once. On the second and third rolls, the      |");
			System.out.println("| player can roll any number of dice he/she wants to, including none or all of them, |");
			System.out.println("| trying to get a good combination.                                                  |");
			System.out.println("| The player can choose whether he/she wants to roll once, twice or three times in   |");
			System.out.println("| each turn. After the three rolls in a turn, the player must put his/her score down |");
			System.out.println("| on the scorecard, under any one of the thirteen categories. The score that the     |");
			System.out.println("| player finally gets for that turn depends on the category/box that he/she chooses  |");
			System.out.println("| and the combination that he/she got by rolling the dice. But once a box is chosen  |");
			System.out.println("| on the score card, it can't be chosen again.                                       |");
			System.out.println("|                                                                                    |");
			System.out.println("| LET'S PLAY SOME YAHTZEE!                                                           |");
			System.out.println("+------------------------------------------------------------------------------------+");
			System.out.println("\n\n");
		}
	
}
