package Main;

import java.util.Arrays;
import java.util.Random;

public class Script {
	
	static String cherry = "cherry";
	
	/**
	 * 
	 * The player starts with $1 credit, with each go costing 20 c.
	 * If the Fruit Machine “rolls” two of the same symbol, the user wins 50c.
	 * The player wins $1 for three of the same and $5 for 3 Bells.
	 * The player loses $1 if two skulls are rolled and all of his/her money if three skulls are rolled.
	 * The player can choose to quit with the winnings after each roll or keep playing until there is no money left.	
	 * 
	 */
	
	static double credit = 1.00;
	static double cost = 0.20;
	
	static String[] slotMachine = new String[3];
	static String[] things = {cherry, "bell", "lemon", "orange", "star", "skull"};
	static int size = things.length;
	
	// Each iteration of the code
	static void forEachRun() {
		
		for (int i = 0; i < 100; i++) {
			Math.round(credit);
			if (credit <= 0.0001) {
				System.out.println();
				System.out.printf("Your credit: %.2f", credit);
				System.out.println();
				System.out.println("broke mf");
				break;
			}
			System.out.println("~~~~   Rolling   ~~~~");
			credit = credit - cost;
			System.out.printf("You have spent 20c. Your new Credit: %.2f", credit);
			System.out.println();
			rolling();

		}
		
	}
	
	static void rolling() {
		
		Random random = new Random();
		
		int rand = 0;
		
		for (int i = 0; i < slotMachine.length; i++) {
			rand = random.nextInt(size);
			slotMachine[i] = things[rand];
		}
		
		System.out.println(Arrays.toString(slotMachine));
		
		check();
	}
	
	static String[][] winCombinations = {
			{"cherry", "cherry", "cherry"},
			{"lemon", "lemon", "lemon"},
			{"orange", "orange", "orange"},
			{"star","star","star"},
	};
	
	static String[][] fiveDollarComb = {
			{"bell", "bell", "bell"}
	};
	
	static String[][] loseCombinations = {
			{"skull", "skull", "cherry"},
			{"skull", "skull", "bell"},
			{"skull", "skull", "lemon"},
			{"skull", "skull", "orange"},
			{"skull", "skull","star"},
			
			{"cherry", "skull", "skull"},
			{"bell", "skull", "skull"},
			{"lemon", "skull", "skull"},
			{"orange", "skull", "skull"},
			{"star", "skull", "skull"},
			
			{"skull", "cherry", "skull"},
			{"skull", "bell", "skull"},
			{"skull", "lemon", "skull"},
			{"skull", "orange", "skull"},
			{"skull","star","skull"},
	};
	
	static String[][] endGame = {
			{"skull", "skull", "skull"},
	};

	static void check() {
		
			for (int i = 0; i < winCombinations.length; i++) {
				
				if (winCombinations[i][0] == slotMachine[0] && winCombinations[i][1] == slotMachine[1] && winCombinations[i][2] == slotMachine[2]) {
					System.out.println("Three in a row! Win 1$");
					credit = credit + 1.00;
					System.out.println("Your new credit: " + credit +"$");
				}
			}
			
			for (int i = 0; i < fiveDollarComb.length; i++) {
				
				if (fiveDollarComb[i][0] == slotMachine[0] && fiveDollarComb[i][1] == slotMachine[1] && fiveDollarComb[i][2] == slotMachine[2]) {
					System.out.println("JACKPOT! Win 5$");
					credit = credit + 5.00;
					System.out.println("Your new credit: " + credit +"$");
				}
			}
			
			for (int i = 0; i < loseCombinations.length; i++) {
				
				if (loseCombinations[i][0] == slotMachine[0] && loseCombinations[i][1] == slotMachine[1] && loseCombinations[i][2] == slotMachine[2]) {
					System.out.println("2 Skulls! Lose 1$");
					credit = credit - 1.00;
					System.out.println(credit);

				}
				
			}
			
			for (int i = 0; i < endGame.length; i++) {
				
				if (endGame[i][0] == slotMachine[0] && endGame[i][1] == slotMachine[1] && endGame[i][2] == slotMachine[2]) {
					System.out.println("BADLUCK ! Lose 5$");
					credit = credit - 5.00;
					System.out.println("Your new credit: " + credit +"$");
				}
				
			}

	}
	
	public static void main(String[] args) {
		
		
//		System.out.println(credit);
//		forEachRun();
//		System.out.println(credit);
		forEachRun();

	}
	
}
