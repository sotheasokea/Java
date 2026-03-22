public class ChainOfResponsibility {
  public static void main(String[] args) {
    AskTheNextClever askRandomStudent = new RandomStudent();
    AskTheNextClever askCleverStudent = new CleverStudent();
    AskTheNextClever askAI = new AI();
    AskTheNextClever askTeacher = new Teacher();

    askRandomStudent.setNext(askCleverStudent).setNext(askAI).setNext(askTeacher);

    System.out.println("======== Level 1 ========");
    askRandomStudent.answer(1, "What is AI stand for?");

    System.out.println("======== Level 2 ========");
    askRandomStudent.answer(2, "When did AI created?");

    System.out.println("======== Level 3 ========");
    askRandomStudent.answer(3, "Does Reddit has AI in it? Describe other platforms with AI.");

    System.out.println("======== Level 4 ========");
    askRandomStudent.answer(4, "How to use AI so that it won't affect our brain?");

    System.out.println("======== Level 5 ========");
    askRandomStudent.answer(5, "How to stop AI from growing?");
  }
}

abstract class AskTheNextClever{
  protected AskTheNextClever nextPerson;

  public AskTheNextClever setNext(AskTheNextClever nextPerson){
    this.nextPerson = nextPerson;
    return nextPerson;
  }

  public abstract void answer(int level, String question);

  protected void passQuestion(int level, String question){
    if(nextPerson != null){
      nextPerson.answer(level, question);
    }else{
      System.out.println("\nNo one can find the answer for the question: "+question);
    }
  }
}

class RandomStudent extends AskTheNextClever{
  public void answer(int level, String question){
    if(level == 1){
      System.out.println("[Random Student] answered: "+question);
    }else{
      System.out.println("[Random Student] can't answer: "+question);
      passQuestion(level, question);
    }
  }
}

class CleverStudent extends AskTheNextClever{
  public void answer(int level, String question){
    if(level == 2){
      System.out.println("[Clever Student] answered: "+question);
    }else{
      System.out.println("[Clever Student] can't answer: "+question);
      passQuestion(level, question);
    }
  }
}

class AI extends AskTheNextClever{
  public void answer(int level, String question){
    if(level == 3){
      System.out.println("[AI] answered: "+question);
    }else{
      System.out.println("[AI] can't answer: "+question);
      passQuestion(level, question);
    }
  }
}

class Teacher extends AskTheNextClever{
  public void answer(int level, String question){
    if(level == 4){
      System.out.println("[Teacher] answered: "+question);
    }else{
      System.out.println("[Teacher] can't answer: "+question);
      passQuestion(level, question);
    }
  }
}