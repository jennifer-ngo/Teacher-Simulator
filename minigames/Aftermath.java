import java.util.*;

public class Aftermath
{
  String[] questions = {"What is 13 times 4?", 
                        "What is 68 divided by 4?", 
                        "What is the only even prime number?", 
                        "What is the smallest perfect number?", 
                        "How many sides does a hexagon have?", 
                        "What is 12 times 5?", 
                        "What is the square root of 144?", 
                        "What is 64 divided by 8?", 
                        "What is five to the power of zero?", 
                        "What is the square root of 81?", 
                        "What is 91 divided by 7?", 
                        "What is the least common multiple of 6, 8, and 12?", 
                        "If Mark has 24 packs of 60 legos, how many legos does he have?"};
  HashMap<String, String> ansKey = new HashMap<String, String>();
  int questionsCorrect = 0;
  
  Aftermath()
  {
    ansKey.put("What is 13 times 4?", "52");
    ansKey.put("What is 68 divided by 4?", "17");
    ansKey.put("What is the only even prime number?", "2");
    ansKey.put("What is the smallest perfect number?", "6");
    ansKey.put("How many sides does a hexagon have?", "6");
    ansKey.put("What is 12 times 5?", "60");
    ansKey.put("What is the square root of 144?", "12");
    ansKey.put("What is 64 divided by 8?", "8");
    ansKey.put("What is five to the power of zero?", "1");
    ansKey.put("What is the square root of 81?", "9");
    ansKey.put("What is 91 divided by 7?", "13");
    ansKey.put("What is the least common multiple of 6, 8, and 12?", "24");
    ansKey.put("If Mark has 24 packs of 60 legos, how many legos does he have?", "1440");
  }

  //returns an ArrayList of two random false answers for additional answer choices
  public ArrayList<String> getFalseAnswers(String quest)
  {
    ArrayList<String> forReturn = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();
    
    answers.add("52");
    answers.add("17");
    answers.add("2");
    answers.add("6");
    answers.add("6");
    answers.add("60");
    answers.add("12");
    answers.add("8");
    answers.add("1");
    answers.add("9");
    answers.add("13");
    answers.add("24");
    answers.add("1440");

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

  public String getQuestion()
  {
    int num = (int)(Math.random() * ((12 - 0) + 1)); 
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