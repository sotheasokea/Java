package OtherPractise;

public class StrategyPatternPractise {
  public static void main(String[] args) {
    ChooseOption option = new ChooseOption();
    option.speak();

    option.setLanguage(new Khmer());
    option.speak();

    option.setLanguage(new Thai());
    option.speak();

    option.setLanguage(new English());
    option.speak();

    option.setLanguage(new Japanese());
    option.speak();
  }
}

interface ChooseLanguage{
  void sayAPhrase();
}

class English implements ChooseLanguage{
  public void sayAPhrase(){
    System.out.println("I choose English! Hello world!");
  }
}

class Khmer implements ChooseLanguage{
  public void sayAPhrase(){
    System.out.println("I choose Khmer! [Khmer Phrase]");
  }
}

class Thai implements ChooseLanguage{
  public void sayAPhrase(){
    System.out.println("I choose Thai! [Thai Phrase]");
  }
}

class Japanese implements ChooseLanguage{
  public void sayAPhrase(){
    System.out.println("I choose Japanese! [Japanese Phrase]");
  }
}

class ChooseOption{
  private ChooseLanguage language;
  public void  setLanguage(ChooseLanguage language){
    this.language = language;
  }

  void speak(){
    if(language == null){
      System.out.println("Bro!! Choose a language");
      return;
    }

    language.sayAPhrase();
  }
}
