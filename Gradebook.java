public class Gradebook
{
  //array to store students' grades for each day
  private int[] performance = new int[5];

  //array to store students' behaviors for each day
  private int[] behavior = new int[5];

  private int grade;
  
  public Gradebook()
  {
    grade = 0;
  }

  //return student's overall grade
  public int getGrade()
  {
    return grade;
  }

  public void setPerformance(int day, int point)
  {
    //set performance point for that day
    performance[day] = point;

    //update overall grade 
    grade = 0;
    int counter = 0;
    for(int i = 0; i < performance.length; i++)
    {
      counter++;
      grade = grade + performance[i];
    }
    for(int o = 0; o < behavior.length; o++)
    {
      counter++;
      grade = grade + behavior[o];
    }

    grade = (int)grade / counter;
  }

  public void setBehavior(int day, int point)
  {
    //set behavior point for that day
    behavior[day] = point;

    //update overall grade 
    grade = 0;
    int counter = 0;
    for(int i = 0; i < performance.length; i++)
    {
      counter++;
      grade = grade + performance[i];
    }
    for(int o = 0; o < behavior.length; o++)
    {
      counter++;
      grade = grade + behavior[o];
    }

    grade = (int)grade / counter;
  }
}