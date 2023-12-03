import java.util.*;

public class Clapback
{
  String[] questions = {"You: Good luck on your exam. \nStudent: Luck is for losers.", 
                        "Student: Don't get me angry, you won't like me when I'm angry", 
                        "Student: Bite me!", 
                        "Can you sign this so I can go on the Senior trip?", 
                        "You: Please sit down, \nStudent: You can't tell me that, I'm not a dog.", 
                        "Student: When am I ever going to use this in real life?", 
                        "Student: Does hell exist?", 
                        "Student: My friend helped me with this assignment.", 
                        "Student fell asleep.", 
                        "Student: Can you read over my paper and grade it now?", 
                        "Student writes in XXS font.", 
                        "Student failed paper.", 
                        "Student makes mistakes on their essay."};
  HashMap<String, String> ansKey = new HashMap<String, String>();
  int questionsCorrect = 0;
  
  Clapback()
  {
    ansKey.put("You: Good luck on your exam. \nStudent: Luck is for losers.", "Good luck on your exam.");
    ansKey.put("Student: Don't get me angry, you won't like me when I'm angry", "Nobody likes you anyway.");
    ansKey.put("Student: Bite me!", "I'm on a low fat diet.");
    ansKey.put("Can you sign this so I can go on the Senior trip?", "I'll just sign it next year.");
    ansKey.put("You: Please sit down \nStudent: You can't tell me that, I'm not a dog.", "I know, because a dog is able to do that simple command.");
    ansKey.put("Student: When am I ever going to use this in real life?", "You won't, but the smart kids will.");
    ansKey.put("Student: Does hell exist?", "Yes, it does. It's here, in the classroom, with you.");
    ansKey.put("Student: My friend helped me with this assignment.", "You should stop being friends with them.");
    ansKey.put("Student fell asleep.", "I could think of better ways to waste over $100.");
    ansKey.put("Can you read over my paper and grade it now?", "If you think that your paper must be read immediately, go to Helen Waite.");
    ansKey.put("Student writes in XXS font.", "Sorry, I don't speak ants.");
    ansKey.put("Student failed paper.", "Staples a McDonald's Job Application to his failed paper.");
    ansKey.put("Student makes mistakes on their essay.", "Please use your education appropriately.");
  }

  //returns an ArrayList of two random false answers for additional answer choices
  public ArrayList<String> getFalseAnswers(String quest)
  {
    ArrayList<String> forReturn = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();
    
    answers.add("Good luck on your exam.");
    answers.add("Nobody likes you anyway.");
    answers.add("I'm on a low fat diet.");
    answers.add("I'll just sign it next year.");
    answers.add("I know, because a dog is able to do that simple command.");
    answers.add("You won't, but the smart kids will.");
    answers.add("Yes, it does. It's here, in the classroom, with you.");
    answers.add("You should stop being friends with them.");
    answers.add("I could think of better ways to waste over $100.");
    answers.add("If you think that your paper must be read immediately, go to Helen Waite.");
    answers.add("Sorry, I don't speak ants.");
    answers.add("Staples a McDonald's Job Application to his failed paper.");
    answers.add("Please use your education appropriately.");

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

  //starts a game of Clapback - player is given 5 random questions
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