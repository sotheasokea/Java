package abstractFactory;

public class abstractFactoryTest {
  public static void main(String[] args) {
    GUIFactory factory;
    String os = "Mac";
    if(os.equals("Windows")){
      factory = new WindowsFactory();
    }else{
      factory = new MacFactory();
    }

    Application app = new Application(factory);
    app.render();
  }
}
