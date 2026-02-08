/*************************************************************
* DiceSimulator.java
* John Young
*  
* Advanced Java Programming - BCIS 3342 - 021
* Unit 4 Assigment
* Due Date: February 16, 2025
*************************************************************/

import java.util.Random;
import java.util.Scanner;

public class DiceSimulation {
  private static final Random random = new Random();
  private static final Scanner scanner = new Scanner(System.in);

  private static int[] frequency = new int[12]; // array to accumulate rolls
  private static int rolls = 0; // number of rolls
  
  // *************************************************************
  
  // Simulate rolling a die.
  private static int rollDie() {
    // Add 1 since Random.nextInt(n) returns a number from 0 to n-1
    return random.nextInt(6) + 1;
  } // end method rollDie

  // *************************************************************
  
  // Initialize the frequency array and run a new simulation.
  public static void newSimulation() {
    for (int i = 0; i < frequency.length; i++) {
      frequency [i] = 0;
    }
    rolls = 0;
   while (true) {
    System.out.print("How many dice rolls would you like to simulate? ");
    try {
      rolls += Integer.parseInt(scanner.next());
      break;
    }
    catch (NumberFormatException ignore) {
      System.out.println("Invalid input"); 
    }
   }
    for (int i = 0; i < rolls; i++) {
      frequency[(rollDie() + rollDie()) - 1]++;
    }
  }// end method newSimulation
  
  // *************************************************************
  
  // Simualte additional rolls.
  public static void additionalRolls() {
    int userInput = 0;
    while (true) {
      System.out.print("How many additional rolls? ");
      try {
        userInput = Integer.parseInt(scanner.next());
        break;
      }
      catch (NumberFormatException ignore) {
        System.out.println("Invalid input"); 
      }
    }
    for (int i = 0; i < userInput; i++) {
      frequency[(rollDie() + rollDie()) - 1]++;
    }
    rolls += userInput;
  } // end method additionalRolls

  // *************************************************************

  // Calculate the number of Asteriks to display.  
  private static int calcPercent(int freq) {
      float fractionOfRolls;
      fractionOfRolls = (float) freq / rolls;
      return (int) Math.round(fractionOfRolls * 100);
  } // end method calcPercent

  // *************************************************************
  
  // Display the results.
  public static void printReport() {
    System.out.println("DICE ROLLING SIMULATION RESULTS");
    System.out.println("Each \"*\" represents 1% of the total number of rolls.");
    System.out.println("Total number of rolls = " + rolls);
    for (int i = 1; i < frequency.length; i++) {
      System.out.format("%2d: " , (i + 1));
      //System.out.print(frequency[i] + " ");
      for (int j = 0; j < calcPercent(frequency[i]); j++){
        System.out.print("*");
      }
      System.out.println();
    }  
  } // end method printReport
} // end class DiceSimulation