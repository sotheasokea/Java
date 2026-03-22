public class TemplatePattern{
  public static void main(String[] args) {
    System.out.println("======== first order coffee1 =======");
    Beverage b1 = new Coffee1();
    b1.prepared();
    System.out.println("======== second order Tea =======");
    Beverage b2 = new Tea();
    b2.prepared();
    System.out.println("======== third order Macha =======");
    Beverage b3= new Macha();
    b3.prepared();
  }
}

abstract class Beverage{
  public final void prepared(){
    boilWater();
    brew();
    pourInCup();
    addCountiments();
  }

  private void boilWater(){
    System.out.println("Boiling water ....");
  }

  private void pourInCup(){
    System.out.println("Pouring into cup ....");
  }

  protected abstract void brew();
  protected abstract void addCountiments();
}

class Tea extends Beverage{
  protected void brew(){
    System.out.println("Steeping the tea leaves in ....");
  }

  protected void addCountiments(){
    System.out.println("Adding lemon ....");
  }
}

class Coffee1 extends Beverage{
  protected void brew(){
    System.out.println("Dripping coffee1 through filter ....");
  }

  protected void addCountiments(){
    System.out.println("Adding milk and sugar ....");
  }
}

class Macha extends Beverage{
  protected void brew(){
    System.out.println("use the macha power ....");
  }

  protected void addCountiments(){
    System.out.println("add coconut water ...");
  }
}