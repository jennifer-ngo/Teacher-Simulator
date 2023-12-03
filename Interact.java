import java.util.*;
public class Interact
{
  private boolean inputIsValid = false;
  private Aftermath aftermath;
  private Clapback clapback;
  private Cleanupio cleanupio;
  private Whowants whowants;
  private Classroom classroom;
  
  public Interact()
  {
    aftermath = new Aftermath();
    clapback = new Clapback();
    cleanupio = new Cleanupio();
    whowants = new Whowants();
    classroom = new Classroom();
  }

  // This method plays out one school day 
  public void schoolDay(int day)
  {
    Scanner in = new Scanner(System.in); 
    System.out.println("Day " + day);
    System.out.println();

    // ask player for what activity they want to give out to the class
    System.out.println("What do you want your class to work on today?\n");
    System.out.println("Pop quiz (p)\nAssignment (a)\nSelf-study (s)");
    System.out.println();
    System.out.print("> ");
    String input = in.nextLine();
    //check for invalid input
    inputIsValid = askActivity(input);
    while(inputIsValid == false)
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("Please enter a valid input (i.e. p, a, or s)");
      System.out.print("> ");
      input = in.nextLine();
      inputIsValid = askActivity(input);
    }
    inputIsValid = false;

    System.out.print("\nPress enter to continue ");
    input = in.nextLine();
    System.out.println("\033[H\033[2J"); //clear console
    
    // ask player what minigames they want to play
    System.out.println("While your students do their classwork, you need to work on some side things.");
    System.out.println("What do you want to work on?\n");
    System.out.println("\nAfter-math (a)\nClapback (b)\nCleanup.io (c)\nWho Wants to Be a Millionaire? (d)\n");
    System.out.print("> ");
    input = in.nextLine();
    
    System.out.println("\033[H\033[2J");
    //check for invalid input
    inputIsValid = askGame(input);
    while(inputIsValid == false)
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("Please enter a valid input (i.e. a, b, c, or d)");
      System.out.print("> ");
      input = in.nextLine();
      inputIsValid = askGame(input);
    }

    inputIsValid = false;

    System.out.println("\033[H\033[2J");
    System.out.println("You've had a long day, Mr. Clapper. It's time to go home. See you tomorrow!");
  }

  //this method calls a round of game from one of the mini games based on player's input
  public boolean askGame(String input)
  {
    if(input.equals("a")) //After-math
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("Welcome to After-math! You'll practice your math skills with multiple choice questions.");
      System.out.println("\033[H\033[2J");
      aftermath.getGame();
      return true;
    }
      
    else if(input.equals("b")) //Clapback
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("Welcome to Clapback! Since the students have been spitting fire lately, you need to practice amping up your comebacks.");
      System.out.println("\033[H\033[2J");
      clapback.getGame();
      return true;
    }
      
    else if(input.equals("c")) //Cleanup.io
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("Welcome to Cleanup.io! Your classroom is filled with trash and needs to be cleaned up.");
      System.out.println("\033[H\033[2J");
      cleanupio.getGame();
      return true;
    }

    else if(input.equals("d")) //Who Wants to Be a Millionaire?
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("Welcome to Who Wants to Be a Millionaire! You were criticized of having an airhead during the teacher meeting last week. You're still salty about it and decide to gain new knowledge to wow the teachers in the upcoming meeting.");
      System.out.println("\033[H\033[2J");
      whowants.getGame();
      return true;
    }

    else // wrong input
    {
      return false;
    }
  }

  // this method decide to grade students (performance or behvior) based on player's decision of acitivty of the day
  public boolean askActivity(String input)
  {
    if(input.equals("p")) // give class pop quiz
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("You announce to your students that they will be having a pop quiz. The whole class frowns in disbelief and you go back to your desk while some students cry.");
      classroom.gradePerformance();
      return true;
    }
      
    else if(input.equals("a")) // give class assignment
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("You briefly explain the new assignment to your students. You walk back to your desk and watch your students suffer.");
      classroom.gradePerformance();
      return true;
    }
      
    else if(input.equals("s")) //self-study
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("You tell your students that they can self-study. The whole class starts chanting your name, 'Clapper forever! Clapper forever!'");
      classroom.gradeBehavior();
      return true;
    }

    else // wrong input
    {
      System.out.println("\033[H\033[2J");//clear console
      System.out.println("Please enter a valid input (i.e. p, a, or s)");
    }
    return false;
  }


  
}