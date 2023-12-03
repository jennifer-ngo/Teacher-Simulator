import java.util.*;
import java.util.Random;

class Play 
{
  public static void main(String[] args) 
  {
    //plays out the game
    Interact interact = new Interact();
    
    Scanner in = new Scanner(System.in); //Scanners can get user input
    int day = 1;
    
    System.out.println("\nWelcome, Mr. Clapper, to Holy Oaks Institute!\nYour goal as a teacher is to have a minimum class average of 90%.\nYou have five days to complete this task.\nGood luck!\n");
    System.out.print("Press enter to continue ");
    String input = in.nextLine();
    System.out.println("\033[H\033[2J"); //clears console

    interact.schoolDay(day);
    day++;



  }
}