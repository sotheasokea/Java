import java.util.Stack;

public class CommanddPattern {
  public static void main(String[] args) {
    TV1 tv1 = new TV1();
    Remote remote = new Remote();

    remote.setCommand(new TurnOnCommand(tv1));
    remote.pressButton();

    remote.setCommand(new VolumeUpCommand(tv1));
    remote.pressButton();
    remote.pressButton();
    remote.pressButton();
    remote.pressButton();

    System.out.println();

    System.out.println("============ Undoing ==============");
    remote.undo();
    remote.undo();

    System.out.println("============ Volume up agian ==============");
    remote.pressButton();
  }
}

interface Command{
  void execute();
  void undo();
}

class TV1{
  private int volume = 10;

  public void turnOn(){
    System.out.println("TV1 turned ON");
  }

  public void turnOff(){
    System.out.println("TV1 turned OFF");
  }

  public void volumeUp(){
    this.volume += 1;
    System.out.println("Volume up: "+this.volume);
  }

  public void volumeDown(){
    this.volume -= 1;
    System.out.println("Volume down: "+this.volume);
  }
}

class TurnOnCommand implements Command{
  private TV1 tv1;

  public TurnOnCommand(TV1 tv1){
    this.tv1 = tv1;
  }

  public void execute(){
    tv1.turnOn();
  }

  public void undo(){
    tv1.turnOff();
  }
}

class TurnOffCommand implements Command{
  private TV1 tv1;

  public TurnOffCommand(TV1 tv1){
    this.tv1 = tv1;
  }

  public void execute(){
    tv1.turnOff();
  }

  public void undo(){
    tv1.turnOn();
  }
}

class VolumeUpCommand implements Command{
  private TV1 tv1;

  public VolumeUpCommand(TV1 tv1){
    this.tv1 = tv1;
  }

  public void execute(){
    tv1.volumeUp();
  }

  public void undo(){
    tv1.volumeDown();
  }
}

class Remote{
  private Command command;
  private Stack<Command> history = new Stack<>();

  public void setCommand(Command command){
    this.command = command;
  }

  public void pressButton(){
    command.execute();
    history.push(command);
  }

  public void undo(){
    if(!history.isEmpty()){
      Command lastCommand = history.pop();
      lastCommand.undo();
    }else{
      System.out.println("Nothing to undo!");
    }
  }
}