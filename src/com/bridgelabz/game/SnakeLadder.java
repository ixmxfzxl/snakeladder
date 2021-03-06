package com.bridgelabz.game;

import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {

	public static void main(String[] args) {
		int WINNING_POSITION = 100;
		int startPosition = 0, numberOfPlayer = 1, numberOfDiceRolls = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Number Of Player: " + numberOfPlayer);
		System.out.println("Current Position: " + startPosition);

		// Iterate Till Position Reaches 100
		while (startPosition != WINNING_POSITION) {
			// Start Game.
			System.out.print("Press 1 To Roll Dice: ");
			int number = scanner.nextInt();

			if (number == 1) {
				// Roll Dice To Get Number Between 1-6.
				Random random = new Random();
				int dice = 1 + random.nextInt(6);
				System.out.println("Dice Rolling...");
				System.out.println("Dice Number: " + dice);

				// To Get Random Number For No Play, Ladder, Snake.
				int checkOptions = random.nextInt(3);

				// To Check Options To No Play, Ladder Or Snake
				switch (checkOptions) {
				case 0:
					System.out.println("OPTION: No Play");
					break;
				case 1:
					System.out.println("OPTION: Ladder");
					startPosition = startPosition + dice;
					if (startPosition > WINNING_POSITION) {
						startPosition -= dice;
					}
					break;
				default:
					System.out.println("OPTION: Snake");
					startPosition = startPosition - dice;
					// Reset Position Value To 0 When It Is Negative
					if (startPosition < 0) {
						startPosition = 0;
					}
					break;
				}

				System.out.println("Current Position: " + startPosition);
				numberOfDiceRolls++;

			} else {
				System.out.println("Error: Run The Program Again & Enter Valid Number");
			}
		}

		System.out.println("You Rolled Dices " + numberOfDiceRolls + " Times.");
		System.out.println("Congratulations! You Won The Game.");
	}

}
