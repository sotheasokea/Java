public class DecorativePattern {
  public static void main(String[] args) {
    Coffee coffee1 = new BasicCoffee();
    System.out.println(coffee1.getDescription()+" = $"+coffee1.getCost());

    Coffee coffee2 = new MilkDecorator(new BasicCoffee());
    System.out.println(coffee2.getDescription()+" = $"+coffee2.getCost());

    Coffee coffee3 = new BasicCoffee();
    coffee3 = new MilkDecorator(coffee3);
    coffee3 = new WhipDecorator(coffee3);

    System.out.println(coffee3.getDescription()+" = $"+coffee3.getCost());
  }
}

interface Coffee{
  String getDescription();
  double getCost();
}

class BasicCoffee implements Coffee{
  public String getDescription(){
    return "Basic Coffee";
  }
  public double getCost(){
    return 1.00;
  }
}

abstract class CoffeeDecorator implements Coffee{
  protected Coffee coffee;

  public CoffeeDecorator(Coffee coffee){
    this.coffee = coffee;
  }

  public String getDescription(){
    return coffee.getDescription();
  }

  public double getCost(){
    return coffee.getCost();
  }
}

class MilkDecorator extends CoffeeDecorator{
  public MilkDecorator(Coffee coffee){
    super(coffee);
  }

  public String getDescription(){
    return coffee.getDescription() + ", Milk";
  }

  public double getCost(){
    return coffee.getCost() + 0.50;
  }
}

class WhipDecorator extends CoffeeDecorator{
  public WhipDecorator(Coffee coffee){
    super(coffee);
  }

  public String getDescription(){
    return coffee.getDescription() +", Whipped Cream";
  }

  public double getCost(){
    return coffee.getCost() + 0.75;
  }
}
