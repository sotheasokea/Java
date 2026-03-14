package builder;

public class BookTest {
  public static void main(String[] args) {
    Book b1 = new Book.Builder(1)
              .name("Harry Potter")
              .day(12)
              .month(10)
              .year(1990)
              .authorName("JK Rowlling")
              .prize(12)
              .build();
    b1.printInfo();
  }
}
