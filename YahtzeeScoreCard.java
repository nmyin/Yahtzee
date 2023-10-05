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

	/**
	 *	Get a category score on the score card.
	 *	@param category		the category number (1 to 13)
	 *	@return				the score of that category
	 */
	public int getScore(i) {
		int score;
		switch (i){
			case 1: case 2: case 3: case 4: case 5: case 6:
				score = numberScore(i, dg);
			case 7:
				score = threeOfAKind(dg);
			case 8:
				score = fourOfAKind(dg);
			case 9:
				score = fullHouse(dg);
			case 10:
				score = smallStraight(dg);
			case 11:
				score = largeStraight(dg);
			case 12:
				score = chance(dg);
			case 13:
				score = yahtzeeScore(dg);
		}
		return score;
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
	public void printPlayerScore(YahtzeePlayer player) {
		System.out.printf("| %-12s |", player.getName());
		for (int i = 1; i < 14; i++) {
			if (getScore(i) > -1)
				System.out.printf(" %2d |", getScore(i));
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
	public boolean changeScore(int choice, DiceGroup dg) {}
	
	/**
	 *  Change the scorecard for a number score 1 to 6
	 *
	 *  @param choice The choice of the player 1 to 6
	 *  @param dg  The DiceGroup to score
	 */
	public void numberScore(int choice, DiceGroup dg) {
		int score;
		if (choice == 7)
			score = threeOfAKind(dg);
		else if (choice == 8)
			score = fourOfAKind(dg);
		else if (choice == 9)
			score = fullHouse(dg);
		else if (choice == 10)
			score = smallStraight(dg);
		else if (choice == 11)
			score = largeStraight();
	}
	
	/**
	 *	Updates the scorecard for Three Of A Kind choice.
	 *
	 *	@param dg	The DiceGroup to score
	 */	
	public void threeOfAKind(DiceGroup dg) {
		//create an array of the rolls and see which one has the highest frequency and then check if that frequency is three
		int[] freq = new int[6];
		int max_value = 0;
		for (int i = 0; i < 5; i++){
			freq[dg.getDie(i)-1]++;
		}
		for (int k = 0; k < 6; k++){
			if (freq[k] > max_value)
				max_value = freq[k];
		}
		if (max_value >= 3)
			for (int i = 0; i < dg.length(); i++){
				max_value += dg[i];
			}
		return max_value;
	}
	
	public void fourOfAKind(DiceGroup dg) {
		int[] freq = new int[6];
		int max_value = 0;
		for (int i = 0; i < 5; i++){
			freq[dg.getDie(i)-1]++;
		}
		for (int k = 0; k < 6; k++){
			if (freq[k] > max_value)
				max_value = freq[k];
		}
		if (max_value >= 4)
			for (int i = 0; i < dg.length(); i++){
				max_value += dg[i];
			}
		return max_value;
	}
	
	public void fullHouse(DiceGroup dg) {
		int[] freq = new int[6];
		int max_value = 0;
		for (int i = 0; i < 5; i++){
			freq[dg.getDie(i)-1]++;
		}
		for (int k = 0; k < 6; k++){
			if (freq[k] > max_value)
				max_value = freq[k];
		}
		if (max_value >= 4)
			for (int i = 0; i < dg.length(); i++){
				max_value += dg[i];
			}
		return max_value;
	}
	
	public void smallStraight(DiceGroup dg) {
		
	}
	
	public void largeStraight(DiceGroup dg) {}
	
	public void chance(DiceGroup dg) {}
	
	public void yahtzeeScore(DiceGroup dg) {
	boolean same = true;
		for (int i = 1; i < dg.length()+1; i++){
			if (dg[i] != dg[i-1])
				same = same && false;
		}
		if (same == true)
			return 50;
		return 0;
	}

}
