public class StrategyPattern {
 public static void main(String[] args) {
  Navigate navigator = new Navigate();
  navigator.navigate(
    "Kandal", "Phnom Penh");

  navigator.setStrategy(new carStrategy());
  navigator.navigate(
    "Kandal", "Phnom Penh");

  navigator.setStrategy(new BikeStrategy());
  navigator.navigate(
    "Kandal", "Phnom Penh");

  navigator.setStrategy(new WalkStrategy());
  navigator.navigate(
    "Kandal", "Phnom Penh");
 } 
}

interface NavigationStrategy{
  void navigate(String from, String to);
}

class carStrategy implements NavigationStrategy{
  public void navigate(String from, String to){
    System.out.println("Driving by car from "+from+" to "+to);
    System.out.println("Estimated time: 30 mins");
  }
}
class BikeStrategy implements NavigationStrategy{
  public void navigate(String from, String to){
    System.out.println("Riding bike from "+from+" to "+to);
    System.out.println("Estimated time: 1 hours");
  }
}

class WalkStrategy implements NavigationStrategy{
  public void navigate(String from, String to){
    System.out.println("Walking from "+from+" to "+to);
    System.out.println("Estimated time: 3 hours");
  }
}

class Navigate{
  private NavigationStrategy strategy;

  public void setStrategy(NavigationStrategy strategy){
    this.strategy = strategy;
  }

  public void navigate(String from, String to){
    if(strategy == null){
      System.out.println("No strategy set yet!");
      return;
    }
    strategy.navigate(from, to);
  }
}
