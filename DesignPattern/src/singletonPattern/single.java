package singletonPattern;

public class single {
  
  public static void main(String[] args) {
    System.out.println("it's working");
    President A = President.getPresident("Donal Trump");
    President B = President.getPresident("Will this one work?");

    System.out.println(A);
    System.out.println(B);

  }
}
