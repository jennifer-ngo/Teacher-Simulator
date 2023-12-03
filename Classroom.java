import java.util.ArrayList;

public class Classroom
{
  //stores list of student objects
  private ArrayList<Student> students;
  //stores list of names used to make new students
  public static ArrayList<String> names;

  Classroom()
  {
    students = new ArrayList<Student>();
    names = new ArrayList<String>();
    
    names.add("Emily Jean Stone");
    names.add("Henry Charles Albert David");
    names.add("William Bradley Pitt");
    names.add("Adele Laurie Blue Adkins");
    names.add("Belcalis Almanzar");
    names.add("Jelena Hadid");
    names.add("Thomas Jacob Black");
    names.add("Katheryn Elizabeth Hudson");
    names.add("Peter Gene Hernandez");
    names.add("Stefani Joanne Angelina Germanotta");
    names.add("Onika Tanya Maraj");
    names.add("Alecia Beth Moore");
    names.add("Calvin Cordozar Broadus");
  }

  //returns classAverage 
  public int classAverage()
  {
    if(students.get(0).getGrade() == 0)
    {
      return 100;
    }
    int sum = 0;
    for(int i = 0; i < 5; i++)
    {
      sum += students.get(i).getGrade();
    }
    return sum/(students.size());
  }

  public void addStudent()
  {
    students.add(new Student(generateName(names)));
  }

  public String toString()
  {
    for(int i = 0; i < students.size(); i++)
    {
      if(students.get(i).getGrade() == 0)
      {
        System.out.println("Student name: " + students.get(i).getName() + "   Grade: 100   Behavior: " + students.get(i).getBehavior() + "   Intelligence: " +                        students.get(i).getIntelligence());
      }
      else
      {
        System.out.println("\t Student name: " + students.get(i).getName() + "Grade: " +           students.get(i).getGrade() + "Behavior: " + students.get(i).getBehavior() + "Intelligence: " + students.get(i).getIntelligence());
      }
    }
    return "Class average: " + classAverage();
  }

  //generate name from "names" list and remove from list to prevent repeating names
  public String generateName(ArrayList<String> names)
  {
    int number = (int) Math.floor(Math.random() * (names.size() - 1));
    String name = names.get(number);
    removeName(name);
    return name;
  }
  
  public static void removeName(String name)
  {
    names.remove(name);
  }

  // give behavior grade to students 
  public void gradeBehavior()
  {
    for(int i = 0; i < students.size(); i++)
    {
      Grader.gradeBehavior(students.get(i));
    }
  }
  // give performance grade to students
  public void gradePerformance()
  {
    for(int i = 0; i < students.size(); i++)
    {
      Grader.gradePerformance(students.get(i));
    }
  }
}