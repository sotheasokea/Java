package singletonPattern;

public class President {
  private static President p;
  private String name;

  private President(String name){
    this.name = name;
    System.out.println("president created");
  }
  public static President getPresident(String name){
    if(p == null){
      p = new President(name);
    }
    return p;
  }
}
