/*************************************************************
* Main.java -  A Driver for the DiceSimulation class.
* John Young
*  
* Advanced Java Programming - BCIS 3342 - 021
* Unit 4 Assigment
* Due Date: February 16, 2025
*************************************************************/
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    String choice;          // user's choice of action

    boolean done = false;   // user's quit flag



    DiceSimulation diceSimulation = new DiceSimulation();

    System.out.println(

      "Welcome to the dice throwing simulator!\n");



    do

    {

      System.out.println(

        "Options: (n)ew simulation, (a)dditional rolls," +

        " (p)rint, (q)uit");

      System.out.print("Enter n, a, p, or q ==> ");

      choice = stdIn.nextLine();



      switch (choice.charAt(0))

      {

        case 'n', 'N' -> diceSimulation.newSimulation();

        case 'a', 'A' -> diceSimulation.additionalRolls();

        case 'p', 'P' -> diceSimulation.printReport();

        case 'q', 'Q' -> done = true;

        default -> System.out.println("Invalid selection.");

      } // end switch

    } while (!done);
  }
}