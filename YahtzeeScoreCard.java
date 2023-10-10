/**
 *	Describe the scorecard here.
 *
 *	@author	Nishka Yadav
 *	@since	9/28/2023
 * 
 * 
 * What the dice to hold are
 * What the category is
 * What the dice rolled are
 * Method for printing a dice based on a number
 * 
 * Yahtzee player- name of player, scorecard for each player (instance of class YahtzeeScoreCard (this class))
 * 
 * 
 */
public class YahtzeeScoreCard {
	private boolean[] numScore = new boolean[13];
	private int[] scores = new int[13];
	

	/**
	 *	Get a category score on the score card.
	 *	@param category		the category number (1 to 13)
	 *	@return				the score of that category
	 */
	public int getScore(int i, DiceGroup dg) {
		return scores[i-1];
	}
	
	/**
	 *  Print the scorecard header
	 */
	public void printCardHeader() {
		System.out.println("\n");
		System.out.printf("\t\t\t\t\t       3of  4of  Fll Smll Lrg\n");
		System.out.printf("  NAME\t\t  1    2    3    4    5    6   Knd  Knd  Hse " +
						"Strt Strt Chnc Ytz!\n");
		System.out.printf("+----------------------------------------------------" +
						"---------------------------+\n");
	}
	
	/**
	 *  Prints the player's score
	 */
	public void printPlayerScore(YahtzeePlayer player, DiceGroup dg) {
		System.out.printf("| %-12s |", player.getName());
		for (int i = 1; i < 14; i++) {
			if (getScore(i, dg) > -1)
				System.out.printf(" %2d |", getScore(i, dg));
			else System.out.printf("    |");
		}
		System.out.println();
		System.out.printf("+----------------------------------------------------" +
						"---------------------------+\n");
	}


	/**
	 *  Change the scorecard based on the category choice 1-13.
	 *
	 *  @param choice The choice of the player 1 to 13
	 *  @param dg  The DiceGroup to score
	 *  @return  true if change succeeded. Returns false if choice already taken.
	 */
	public boolean changeScore(int choice, DiceGroup dg) {
		if (numScore[choice-1])
			return false;
		switch (choice){
			case 1: case 2: case 3: case 4: case 5: case 6:
				scores[choice-1] = numberScore(choice, dg);
			case 7:
				scores[choice-1] = threeOfAKind(dg);
			case 8:
				scores[choice-1] = fourOfAKind(dg);
			case 9:
				scores[choice-1] = fullHouse(dg);
			case 10:
				scores[choice-1] = smallStraight(dg);
			case 11:
				scores[choice-1] = largeStraight(dg);
			case 12:
				scores[choice-1] = chance(dg);
			case 13:
				scores[choice-1] = yahtzeeScore(dg);
		}
		numScore[choice-1] = true;
		return true;
	}
	
	/**
	 *  Change the scorecard for a number score 1 to 6
	 *
	 *  @param choice The choice of the player 1 to 6
	 *  @param dg  The DiceGroup to score
	 */
	public int numberScore(int choice, DiceGroup dg) {
		int score = 0;
		for (int j = 0; j < 5; j++){
			if (dg.getDie(j).getLastRollValue() == choice)
				score++;
		}
		return score*choice;
	}
	
	/**
	 *	Updates the scorecard for Three Of A Kind choice.
	 *
	 *	@param dg	The DiceGroup to score
	 */	
	public int threeOfAKind(DiceGroup dg) {
		
		//create an array of the rolls and see which one has the highest frequency and then check if that frequency is three
		int[] freq = new int[6];
		int max_value = 0;
		for (int i = 0; i < 5; i++){
			freq[dg.getDie(i).getLastRollValue()-1]++;
		}
		for (int k = 0; k < 6; k++){
			if (freq[k] > max_value)
				max_value = freq[k];
		}
		if (max_value >= 3)
			return dg.getTotal();
		else
			return 0;
	}
	
	public int fourOfAKind(DiceGroup dg) {
		int[] freq = new int[6];
		int max_value = 0;
		for (int i = 0; i < 5; i++){
			freq[dg.getDie(i).getLastRollValue()-1]++;
		}
		for (int k = 0; k < 6; k++){
			if (freq[k] > max_value)
				max_value = freq[k];
		}
		if (max_value >= 4)
			return dg.getTotal();
		else
			return 0;
	}
	
	public int fullHouse(DiceGroup dg) {
		int[] freq = new int[6];
		boolean fullThree = false;
		boolean fullTwo = false;
		for (int i = 0; i < 5; i++){
			freq[dg.getDie(i).getLastRollValue()-1]++;
		}
		for (int k = 0; k < 6; k++){
			if (freq[k] == 3)
				fullThree = true;
			if (freq[k] == 2)
				fullTwo = true;
		}
		if (fullThree && fullTwo)
			return 25;
		return 0;
	}
	
	public int smallStraight(DiceGroup dg) {
		int k = 0;
		int[] freq = new int[6];
		for (int i = 1; i < 6; i++){
			if (freq[i] >= 1 && freq[i-1] >= 1)
				k++;
			else
				k = 0;
		}
		if (k == 3)
			return 30;
		return 0;
	}
	
	public int largeStraight(DiceGroup dg) {
		int k = 0;
		int[] freq = new int[6];
		for (int i = 1; i < 6; i++){
			if (freq[i] >= 1 && freq[i-1] >= 1)
				k++;
			else
				k = 0;
		}
		if (k == 4)
			return 40;
		return 0;
	}
	
	public int chance(DiceGroup dg) {return dg.getTotal();}
	
	public int yahtzeeScore(DiceGroup dg) {
	boolean same = true;
		for (int i = 1; i < 5; i++){
			if (dg.getDie(i).getLastRollValue() != dg.getDie(i-1).getLastRollValue())
				same = same && false;
		}
		if (same == true)
			return 50;
		return 0;
	}

}
