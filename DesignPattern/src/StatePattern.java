public class StatePattern {
  public static void main(String[] args) {
    Vehicle v1 = new Vehicle(new RedLight());
    v1.checkTrafficLight();
    v1.nextLight();
    v1.nextLight();
    v1.nextLight();
    v1.nextLight();  
  }
}

interface State{
  void vehicleAction();
  State nextAction();
}

class Vehicle{
  private State currentState;

  public Vehicle(State currentState){
    this.currentState = currentState;
  }

  public void checkTrafficLight(){
    currentState.vehicleAction();;
  }

  public void nextLight(){
    this.currentState = currentState.nextAction();
    checkTrafficLight();
  }
}

class RedLight implements State{
  public void vehicleAction(){
    System.out.println("Red Light: vehicle stop");
  }
  public State nextAction(){
    return new GreenLight();
  }
}

class YellowLight implements State{
  public void vehicleAction(){
    System.out.println("Yellow Light: vehicle slow down");
  }
  public State nextAction(){
    return new RedLight();
  }
}

class GreenLight implements State{
  public void vehicleAction(){
    System.out.println("Green Light: vehicle go");
  }
  public State nextAction(){
    return new YellowLight();
  }
}
