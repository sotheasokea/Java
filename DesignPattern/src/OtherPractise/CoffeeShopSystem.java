package OtherPractise;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShopSystem {
  public static void main(String[] args) {
    System.out.println("************* Without MVC **************");
    DrinkFactory choosenDrink = new DrinkFactory();
    Drink drink1 = choosenDrink.createDrink(DrinkType.LATTE);
    System.out.println("Drink: "+drink1.getName()+" - Price: $"+drink1.getCost());
    
    // add topping to the existing drink1
    drink1 = new MilkTopping(drink1);
    drink1 = new VanillaTopping(drink1);
    System.out.println("Drink: "+drink1.getName()+" - Price: $"+drink1.getCost());
    System.out.println("-------------------------------");

    // choose any Payment Method you want
    PaymentContext payBy = new PaymentContext();
    payBy.setPaymentMethod(new CreditPayment());
    payBy.processPayment(drink1.getCost());
    System.out.println("-------------------------------");

    payBy.setPaymentMethod(new EWwalletPayment());
    payBy.processPayment(drink1.getCost());
    System.out.println("-------------------------------");

    payBy.setPaymentMethod(new CashPayment());
    payBy.processPayment(drink1.getCost());

    System.out.println("************* With MVC **************");

    OrderModel model = new OrderModel();
    OrderView view   = new OrderView();
    OrderController controller = new OrderController(model, view);

    List<String> toppings = new ArrayList<>();
    toppings.add("whip");
    toppings.add("vanilla");

    controller.placeOrder(DrinkType.ESPRESSO, toppings, "ewallet");

    view.displayMessage("======== Place an Order =========");
    controller.showORder();

    controller.processPayment();

  }
}

// Using factory pattern - so that the customer can choose their drink

interface Drink{
  String getName();
  double getCost();
}

// 4 concrete drink class
class Espresso implements Drink{
  public String getName(){
    return "Espresso";
  }
  public double getCost(){
    return 3.0;
  }
}
class Latte implements Drink{
  public String getName(){
    return "Latte";
  }
  public double getCost(){
    return 4.0;
  }
}
class Cappuccino implements Drink{
  public String getName(){
    return "Cappuccino";
  }
  public double getCost(){
    return 4.5;
  }
}
class GreenTea implements Drink{
  public String getName(){
    return "Green Tea";
  }
  public double getCost(){
    return 2.5;
  }
}
// create type using enum so that the user input will always be followed by our rule

enum DrinkType{
  ESPRESSO,
  LATTE,
  CAPPUCCINO,
  GREEN_TEA
}
// create the drink factory
class DrinkFactory{
  public Drink createDrink(DrinkType type){
    Drink drink;
    switch (type) {
      case ESPRESSO:
        drink = new Espresso();
        break;
      case LATTE:
        drink = new Latte();
        break;
      case CAPPUCCINO:
        drink = new Cappuccino();
        break;
      case GREEN_TEA:
        drink = new GreenTea();
        break;
      default:
        throw new IllegalArgumentException();
    }
    return drink;
  }
}

// Using Decorative Pattern to add topping for each Drink
abstract class DrinkDecorator implements Drink{
  private Drink drink;
  public DrinkDecorator(Drink drink){
    this.drink = drink;
  }

  public String getName(){
    return drink.getName();
  }

  public double getCost(){
    return drink.getCost();
  }
}
// create 4 concrete classes for each topping
class MilkTopping extends DrinkDecorator{
  public MilkTopping(Drink drink){
    super(drink);
  }
  public String getName(){
    return super.getName() + ", Milk";
  }
  public double getCost(){
    return super.getCost() + 0.50;
  }
}
class SugarTopping extends DrinkDecorator{
  public SugarTopping(Drink drink){
    super(drink);
  }
  public String getName(){
    return super.getName() + ", Sugar";
  }
  public double getCost(){
    return super.getCost() + 0.25;
  }
}

class WhipCreamTopping extends DrinkDecorator{
  public WhipCreamTopping(Drink drink){
    super(drink);
  }
  public String getName(){
    return super.getName() + ", WhipeCream";
  }
  public double getCost(){
    return super.getCost() + 0.75;
  }
}
class VanillaTopping extends DrinkDecorator{
  public VanillaTopping(Drink drink){
    super(drink);
  }
  public String getName(){
    return super.getName() + ", Vanilla";
  }
  public double getCost(){
    return super.getCost() + 1.00;
  }
}

// Using Strategy Pattern for Payment
interface PaymentStrategy{
  void pay(double amount);
  double calculateTotal(double amount);
}
// make 3 concrete payment classes
class CashPayment implements PaymentStrategy{
  public void pay(double amount){
    System.out.println("Payment Method: Cash");
    System.out.println("Total: $"+calculateTotal(amount));
    System.out.println("Paid $"+calculateTotal(amount)+" in cash. Thank you!");
  }
  public double calculateTotal(double amount){
    return amount;
  }
}
class CreditPayment implements PaymentStrategy{
  public void pay(double amount){
    System.out.println("Payment Method: Credit Card");
    System.out.println("Total: $"+calculateTotal(amount)+" ("+amount+" + 2% fee)");
    System.out.println("Paid $"+calculateTotal(amount)+" by credit card. Thank you!");
  }
  public double calculateTotal(double amount){
    return amount + 0.02*amount;
  }
}
class EWwalletPayment implements PaymentStrategy{
  public void pay(double amount){
    System.out.println("Payment Method: E-Wallet");
    System.out.println("Total: $"+calculateTotal(amount)+" ("+amount+" - 5% discount)");
    System.out.println("Paid $"+calculateTotal(amount)+" via E-Wallet. Thank you!");
  }
  public double calculateTotal(double amount){
    return amount - 0.05*amount;
  }
}
// create a PaymentContext for choosing the payment method
class PaymentContext{
  PaymentStrategy paymentStrategy;
  void setPaymentMethod(PaymentStrategy paymentStrategy){
    this.paymentStrategy = paymentStrategy;
  }
  public void processPayment(double amount){
    paymentStrategy.pay(amount);
  }
  public double calculateTotal(double amount){
    return paymentStrategy.calculateTotal(amount);
  }
}

// now we will combine everything into MVC
class OrderModel{
  private Drink drink;
  private String paymentMethod;
  double totalCost;

  public void setDrink(Drink drink){
    this.drink = drink;
  }
  public void setPaymentMethod(String method){
    this.paymentMethod = method;
  }
  public void setTotalCost(double totalCost){
    this.totalCost = totalCost;
  }
   public Drink getDrink(){
    return drink;
   }
   public String getPayemntMethod(){
    return paymentMethod;
   }
   public double getTotalCost(){
    return totalCost;
   }
}

class OrderView{
  OrderModel order;
  public void displayOrder(String drinkName, double cost, String payment){
    System.out.println("Drink : "+drinkName);
    System.out.println("Price: $"+cost);
    System.out.println("Payment method: "+payment);
  }
  public void displayReceipt(String drinkName, double finalCost, String payment){
    System.out.println("=========== Receipt ===========");
    System.out.println("Drink : "+drinkName);
    System.out.println("Final Cost: $"+finalCost);
    System.out.println("Payment method: "+payment);
    System.out.println("Thank you for visiting!");
  }
  public void displayMessage(String message){
    System.out.println(message);
  }
}
// this controller class will be the one that interact with the user
class OrderController{
  private OrderModel model;
  private OrderView view;
  private PaymentContext payment;

  public OrderController(OrderModel model, OrderView view){
    this.model = model;
    this.view  = view;
    this.payment = new PaymentContext();
  }

  public void placeOrder(DrinkType type, List<String> toppings, String paymentType){
    DrinkFactory chooseYourDrink = new DrinkFactory();
    Drink drink = chooseYourDrink.createDrink(type);

    // decorate the drink
    for(String topping: toppings){
      if(topping.equalsIgnoreCase("milk")){
        drink = new MilkTopping(drink);
      }else if(topping.equalsIgnoreCase("sugar")){
        drink = new SugarTopping(drink);
      }else if(topping.equalsIgnoreCase("whip")){
        drink = new WhipCreamTopping(drink);
      }else if(topping.equalsIgnoreCase("vanilla")){
        drink = new VanillaTopping(drink);
      }
    }
    // choose the payment
    if(paymentType.equalsIgnoreCase("cash")){
      this.payment.setPaymentMethod(new CashPayment());
    }else if(paymentType.equalsIgnoreCase("credit")){
      this.payment.setPaymentMethod(new CreditPayment());
    }else if(paymentType.equalsIgnoreCase("ewallet")){
      this.payment.setPaymentMethod(new EWwalletPayment());
    }

    // update the model
    model.setDrink(drink);
    model.setPaymentMethod(paymentType);
  }
  public void showORder(){
    view.displayOrder(model.getDrink().getName(), 
    model.getDrink().getCost(), model.getPayemntMethod());
  }
  public void processPayment(){
    double originalCost = model.getDrink().getCost();

    double finalCost = payment.calculateTotal(originalCost);

    model.setTotalCost(finalCost);

    view.displayMessage("======= Processing Payment ========");
    payment.processPayment(originalCost);
    view.displayReceipt(model.getDrink().getName(), model.getTotalCost(), model.getPayemntMethod());
  }
}

// enum PaymentType{
//   CASH,
//   CREDIT_CARD,
//   E_WALLET
// }
