import java.util.*;

public class Student
{
  Random rand = new Random();
  
  private String name;
  private Gradebook gradebook;
  private int behavior;
  private int intelligence;

  public Student(String name)
  {
    this.name = name;
    gradebook = new Gradebook();
    behavior = (int)Math.floor(Math.random()*5+1);
    intelligence = (int)Math.floor(Math.random()*5+1);
  }
  
  public String getName()
  {
    return name;
  }

  public int getGrade()
  {
    //return grade
    return gradebook.getGrade();
  }

  public int getBehavior()
  {
    return behavior;
  }

  public int getIntelligence()
  {
    return intelligence;
  }

  public String toString()
  {
    return "name: " + name + "  behavior: " + behavior + "  intelligence: " + intelligence;
  }
}  