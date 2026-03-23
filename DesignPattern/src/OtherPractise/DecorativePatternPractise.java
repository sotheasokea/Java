package OtherPractise;

public class DecorativePatternPractise {
  public static void main(String[] args) {
    Pizza pizza = new BasicPizza();
    System.out.println("------ Basic Pizza ------");
    System.out.println(pizza.getDescription());;
    System.out.println(pizza.getCost());;

    Pizza pizza1 = new CheeseTopping(pizza);
    System.out.println("------ Cheese Pizza ------");
    System.out.println(pizza1.getDescription());;
    System.out.println(pizza1.getCost());;

    Pizza pizza2 = new PepperoniTopping(new BasicPizza());
    System.out.println("------ Pepper Pizza ------");
    System.out.println(pizza2.getDescription());;
    System.out.println(pizza2.getCost());;

    Pizza pizza3 = new PepperoniTopping(pizza1);
    System.out.println("------ Cheese Pepper Pizza ------");
    System.out.println(pizza3.getDescription());;
    System.out.println(pizza3.getCost());;

    Pizza pizza4 = new BasicPizza();
    pizza4 = new CheeseTopping(pizza4);
    pizza4 = new PepperoniTopping(pizza4);
    pizza4 = new MushroomTopping(pizza4);
    pizza4 = new OliveTopping(pizza4);

    System.out.println("------ All Topping Pizza Pizza ------");
    System.out.println(pizza4.getDescription());;
    System.out.println(pizza4.getCost());;
  }
}

interface Pizza{
  String getDescription();
  double getCost();
}

class BasicPizza implements Pizza{
  public String getDescription(){
    return "Basic Pizza";
  }
  public double getCost(){
    return 1.50;
  }
}

abstract class PizzaDecorator implements Pizza{
  private Pizza pizza;
  public PizzaDecorator(Pizza pizza){
    this.pizza = pizza;
  }

  public String getDescription(){
    return pizza.getDescription();
  }

  public double getCost(){
    return pizza.getCost();
  }
}

class CheeseTopping extends PizzaDecorator{
  public CheeseTopping(Pizza pizza){
    super(pizza);
  }

  public String getDescription(){
    return super.getDescription() + " + cheese";
  }

  public double getCost(){
    return super.getCost() + 2.00;
  }
}

class PepperoniTopping extends PizzaDecorator{
  public PepperoniTopping(Pizza pizza){
    super(pizza);
  }

  public String getDescription(){
    return super.getDescription() + " + Pepper";
  }

  public double getCost(){
    return super.getCost() + 1.00;
  }
}

class MushroomTopping extends PizzaDecorator{
  public MushroomTopping(Pizza pizza){
    super(pizza);
  }

  public String getDescription(){
    return super.getDescription() + " + Mushroom";
  }

  public double getCost(){
    return super.getCost() + 1.00;
  }
}

class OliveTopping extends PizzaDecorator{
  public OliveTopping(Pizza pizza){
    super(pizza);
  }

  public String getDescription(){
    return super.getDescription() + " + Olive";
  }

  public double getCost(){
    return super.getCost() + 0.75;
  }
}