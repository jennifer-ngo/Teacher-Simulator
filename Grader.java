import java.util.Random;
/*
 * The purpose of this class is to generate grades based on 
 * the student's behavior (1-5) and intelligence (1-5)
 */
public class Grader
{
  public Grader()
  {
    
  }

  //get behavior point (1-5) of a student and generate a grade
  public static int gradeBehavior(Student student)
  {
    int behavior = student.getBehavior();
    boolean probability = false; // probability represents when the randomized number fall into the pobability of the student getting a high grade
    
    if(behavior == 1) // 20% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1); 
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }
    
    if(behavior == 2) // 40% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1 || rand == 2);
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }

    if(behavior == 3) // 60% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1 || rand == 2 || rand == 3);
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }

    if(behavior == 4) // 80% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1 || rand == 2 || rand == 3 || rand == 4);
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }

    if(behavior == 5) // 100% chance of getting good grade (90 - 100)
    {
      return (90 + (int)(Math.random() * ((100 - 90) + 1)));
    }

    return 100;
  }

  //get intelligence point (1-5) of a student and generate a grade
  public static int gradePerformance(Student student)
  {
    int behavior = student.getIntelligence();
    boolean probability = false; // probability represents when the randomized number fall into the pobability of the student getting a high grade
    
    if(behavior == 1) // 20% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1);
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }
    
    if(behavior == 2) // 40% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1 || rand == 2);
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }

    if(behavior == 3) // 60% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1 || rand == 2 || rand == 3);
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }

    if(behavior == 4) // 80% chance of getting good grade (90 - 100)
    {
      int rand = (int)(Math.random() * ((5 - 1) + 1));
      probability = (rand == 1 || rand == 2 || rand == 3 || rand == 4);
      if(probability == true)
      {
        return (90 + (int)(Math.random() * ((100 - 90) + 1)));
      }
      else
      {
        return (70 + (int)(Math.random() * ((89 - 70) + 1)));
      }
    }

    if(behavior == 5) // 100% chance of getting good grade (90 - 100)
    {
      return (90 + (int)(Math.random() * ((100 - 90) + 1)));
    }

    return 100;
  }

}