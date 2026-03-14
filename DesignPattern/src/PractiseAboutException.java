import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PractiseAboutException{
  public static void main(String[] args) {
  //  System.out.println(2/0);
    try {
       System.out.println(2/0);
    }catch (ArithmeticException e) {
      // throw new ArithmeticException("can't divide by 0");
      System.out.println(e);
    }
    String name = null;
    try {
      System.out.println(name.toUpperCase());
    } catch (NullPointerException e) {
      System.out.println(e);
    }

    FileReader reader = null;
    try {
      reader = new FileReader("file.txt");
      var value  = reader.read();
      
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      System.out.println(e);
      // e.printStackTrace();
    } catch(IOException e){
      e.printStackTrace();
    } finally{
      if(reader != null){
        try {
          reader.close();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
      
    }

    // so we can also use var to declare the variable and java will make it the data type that fit our data
     var id = "123";
     System.out.println(id.getClass().getSimpleName());

    
    System.out.println("The last line");
  }
}