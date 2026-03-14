package Prototype;

public class Person implements Cloneable {
  private String name;
  private int age;
  private String job;
  private String sex;

  Person(String name, int age, String job, String sex){
    this.name = name;
    this.age  = age;
    this.job  = job;
    this.sex  = sex;
    System.out.println("Person created for the first time!");
  }

  public void setName(String name){this.name = name;}
  public void setAge(int age){this.age = age;}
  public void setJob(String job){this.job = job;}
  public void setSex(String sex){this.sex = sex;}

  protected Person clone(){
    try {
      return (Person) super.clone();
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  public void printInfo(){
    System.out.println("Name: "+name+" , Age: "+age+", Sex: "+sex+", Job: "+job);
  }

  public static void main(String[] args) {
    Person p1 = new Person("Fin", 19, "Teacher", "Male");
    Person p2 = p1.clone();

    p1.printInfo();
    System.out.println("===============");
    p2.printInfo();
  }
  
}
