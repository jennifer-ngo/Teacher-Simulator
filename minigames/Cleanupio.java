import java.util.*;

public class Cleanupio
{
  String[] questions = {"apple", 
                        "textbook", 
                        "glue sticks", 
                        "candy wrapper", 
                        "test", 
                        "crumpled paper ball", 
                        "book", 
                        "colored pencils", 
                        "parents' contact information", 
                        "highlighters", 
                        "dictionary", 
                        "loose paper", 
                        "broken pencil"};
  HashMap<String, String> ansKey = new HashMap<String, String>();
  int questionsCorrect = 0;
  
  Cleanupio()
  {
    ansKey.put("apple", "teacher's desk");
    ansKey.put("textbook", "bookcase");
    ansKey.put("glue sticks", "supply box");
    ansKey.put("candy wrapper", "trash can");
    ansKey.put("test", "teacher's desk");
    ansKey.put("crumpled paper ball", "trash can");
    ansKey.put("book", "bookcase");
    ansKey.put("colored pencils", "supply box");
    ansKey.put("parents' contact information", "teacher's desk");
    ansKey.put("highlighters", "supply box");
    ansKey.put("dictionary", "bookcase");
    ansKey.put("loose paper", "bookcase");
    ansKey.put("broken pencil", "trash can");
  }

  public String getQuestion()
  {
    int num = (int) Math.floor(Math.random()*(12-1+1)+1); //change to 0 - 12
    return questions[num];
  }

  public String getAnswer(String quest)
  {
    return ansKey.get(quest);
  }

  public boolean checkWin()
  {
    if(questionsCorrect / 5 == 5)
    {
      return true;
    }
    return false;
  }

  //returns an ArrayList of two random false answers for additional answer choices
  public ArrayList<String> getFalseAnswers(String quest)
  {
    ArrayList<String> forReturn = new ArrayList<String>();
    
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("teacher's desk");
    answers.add("bookcase");
    answers.add("supply box");
    answers.add("trash can");

    //identifies correct answer, then removes from ArrayList<String> [answers]
    String rightAnswer = getAnswer(quest);
    answers.remove(rightAnswer);

    //selects a random false answer from [answers], removes it and adds to forReturn (x2)
    int false1 = (int)(Math.random() * ((2 - 0) + 1));
    forReturn.add(answers.get(false1));
    answers.remove(answers.get(false1));
    
    int false2 = (int)(Math.random() * ((1 - 0) + 1));
    forReturn.add(answers.get(false2));

    return forReturn;
  }

  public boolean checkAnswer(String quest, String answer)
  {
    if(ansKey.get(quest).equals(answer))
    {
      questionsCorrect++;
      return true;
    }
    else
    {
      return false;
    }
  }

   //starts a game of Cleanup.io - player is given 5 random questions
  public void getGame()
  {
    Scanner in = new Scanner(System.in);
    String question = "";
    
    String optionA = "";
    String optionB = "";
    String optionC = "";

    String userInput = "";
    boolean correctAnswer = false;

     for(int i = 0; i < 5; i++)
    {
      ArrayList<String> options = new ArrayList<String>();

      //prints out a random question
      question = getQuestion(); 
      System.out.println(question);

      //adds the right answer + 2 false answers to player options
      options = getFalseAnswers(question);
      options.add(getAnswer(question));

      //System.out.println("getAnswer(question): " + getAnswer(question)); //null here
      //System.out.println(options);
      
      //prints out options in a random order and asks player to input their answer
      int rand = (int)(Math.random() * ((2 - 0) + 1));
      
      optionA = options.get(rand);
      System.out.println("(a) " + optionA);
      options.remove(rand);
      
      optionB = options.get(0);
      System.out.println("(b) " + optionB);
      
      optionC = options.get(1);
      System.out.println("(c) " + optionC);
      
      System.out.println("Enter your answer");
      userInput = in.nextLine();
      
      //System.out.println("\033[H\033[2J");

      //tells player whether or not they got the answer right based on their input
      if(userInput.equals("a"))
      {
        correctAnswer = checkAnswer(question, optionA);
        if(correctAnswer == true)
        {
          System.out.println("Correct answer. Next question...");
        }
        else
        {
          System.out.println("Wrong answer. Next question...");
        }
      }
      else if(userInput.equals("b"))
      {
        correctAnswer = checkAnswer(question, optionB);
        if(correctAnswer == true)
        {
          System.out.println("Correct answer. Next question...");
        }
        else
        {
          System.out.println("Wrong answer. Next question...");
        }
      }
      else if(userInput.equals("c"))
      {
        correctAnswer = checkAnswer(question, optionC);
        if(correctAnswer == true)
        {
          System.out.println("Correct answer. Next question...");
        }
        else
        {
          System.out.println("Wrong answer. Next question...");
        }
      }
      else
      {
        System.out.println("Wrong input. Next question...");  
      }
      System.out.println("\nEnter to continue");
      userInput = in.nextLine();
      //System.out.println("\033[H\033[2J");
    }
  }
}