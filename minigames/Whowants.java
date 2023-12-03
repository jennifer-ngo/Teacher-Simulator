import java.util.*;

public class Whowants
{
  String[] questions = {"Globe and Jerusalem are types of what?", 
                        "What geometric shape is generally used for stop signs?", 
                        "What does the word loquacious mean?", 
                        "Which world continent is the largest?", 
                        "What land animal has the largest eyes?", 
                        "What are male turkeys called?", 
                        "Paper was invented in what country?", 
                        "Area 51 is located in which US state?", 
                        "The leading source of salmonella poisoning is what?", 
                        "Who starts first in chess?", 
                        "What is a baby kangaroo called?", 
                        "Who was given the title “King of Comedy”?", 
                        "What is a lie detector called?"};
  HashMap<String, String> ansKey = new HashMap<String, String>();
  int questionsCorrect = 0;
  
  Whowants()
  {
    ansKey.put("Globe and Jerusalem are types of what?", "Artichoke");
    ansKey.put("What geometric shape is generally used for stop signs?", "Octagon");
    ansKey.put("What does the word loquacious mean?", "Chatty");
    ansKey.put("Which world continent is the largest?", "Asia");
    ansKey.put("What are male turkeys called?", "Toms");
    ansKey.put("Paper was invented in what country?", "China");
    ansKey.put("Area 51 is located in which US state?", "Nevada");
    ansKey.put("The leading source of salmonella poisoning is what?", "Chicken");
    ansKey.put("Who starts first in chess?", "White");
    ansKey.put("What is a baby kangaroo called?", "A joey");
    ansKey.put("Who was given the title “King of Comedy”?", "Charlie Chaplin");
    ansKey.put("What land animal has the largest eyes?", "Ostrich");
    ansKey.put("What is a lie detector called?", "A polygraph");
  }

  public String getQuestion()
  {
    int num = (int) Math.floor(Math.random()*(13-1+1)+1); 
    return questions[num];
  }

  public String getAnswer(String quest) //quest == question
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
    answers.add("Artichoke");
    answers.add("Octagon");
    answers.add("Chatty");
    answers.add("Asia");
    answers.add("Toms");
    answers.add("China");
    answers.add("Nevada");
    answers.add("Chicken");
    answers.add("White");
    answers.add("A joey");
    answers.add("Charlie Chaplin");
    answers.add("Ostrich");
    answers.add("A polygraph");

    //identifies correct answer, then removes from ArrayList<String> [answers]
    String rightAnswer = getAnswer(quest);
    answers.remove(rightAnswer);

    //selects a random false answer from [answers], removes it and adds to forReturn (x2)
    int rand = (int)(Math.random() * ((11 - 0) + 1));
    forReturn.add(answers.get(rand));
    answers.remove(rand);
    
    rand = (int)(Math.random() * ((10 - 0) + 1));
    forReturn.add(answers.get(rand));

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

   //starts a game of After-math - player is given 5 random questions
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