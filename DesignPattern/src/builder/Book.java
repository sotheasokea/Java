package builder;

public class Book {
  private int id;
  private String name;
  private int day;
  private int month;
  private int year;
  private String authorName;
  private double prize;
  
  private Book(Builder b){
    this.id = b.id;
    this.name = b.name;
    this.day = b.day;
    this.month = b.month;
    this.year = b.year;
    this.authorName = b.authorName;
    this.prize = b.prize;
  }
  public void printInfo(){
    System.out.println("Book name: "+name+" (id: "+id+")");
    System.out.println(day+"/"+month+"/"+year);
    System.out.println("Author name: "+authorName);
    System.out.println("Prize: $"+prize);
  }


  public static class Builder{
    private int id;
    private String name;
    private int day;
    private int month;
    private int year;
    private String authorName;
    private double prize;

    public Builder(int id){
      this.id = id;
    }
    public Builder name(String name){
      this.name = name;
      return this;
    }
    public Builder day(int day){
      this.day = day;
      return this;
    }
    public Builder month(int month){
      this.month = month;
      return this;
    }
    public Builder year(int year){
      this.year = year;
      return this;
    }
    public Builder authorName(String authorName){
      this.authorName = authorName;
      return this;
    }
    public Builder prize(double prize){
      this.prize = prize;
      return this;
    }
    public Book build(){
      return new Book(this);
    }
  }
  
}
