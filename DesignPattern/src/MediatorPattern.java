import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
public static void main(String[] args) {
  ChatMediator messengerGroupChat = new ChatRoom();
  ChatMediator penddingCrewMate   = new ChatRoom();

  User luffy = new User("Luffy", messengerGroupChat);
  User Zoro  = new User("Zoro", messengerGroupChat);
  User Nami  = new User("Nami", messengerGroupChat);
  User Ussop = new User("Ussop", messengerGroupChat);
  User Sanji = new User("Sanji", messengerGroupChat);
  // pending crewmate
  User Chopper = new User("Chopper", penddingCrewMate);
  User Robin   = new User("Robin", penddingCrewMate);
  User Franky  = new User("Franky", penddingCrewMate);
  User Brook   = new User("Brook", penddingCrewMate);
  User Jimbe   = new User("Jimbe", penddingCrewMate);

  messengerGroupChat.addUser(luffy);
  messengerGroupChat.addUser(Zoro);
  messengerGroupChat.addUser(Nami);
  messengerGroupChat.addUser(Ussop);
  messengerGroupChat.addUser(Sanji);

  penddingCrewMate.addUser(Chopper);
  penddingCrewMate.addUser(Robin);
  penddingCrewMate.addUser(Franky);
  penddingCrewMate.addUser(Brook);
  penddingCrewMate.addUser(Jimbe);

  System.out.println("-------- Before entering GrandLine ---------");
  luffy.send("I want to be king of Pirate!");

  System.out.println("==========================");
  Zoro.send("I want to be the best swordman!");

  System.out.println("==========================");
  Nami.send("I want to draw world map!");

  System.out.println("==========================");
  Sanji.send("I want to find All Blue!");

  System.out.println("==========================");
  Ussop.send("I want to be a brave warrior of the sea!");

  System.out.println("-------- Season 2 live action ---------");
  Chopper.send("Guys I've already join the crew and we are leaving for Alabasta");

  System.out.println("==========================");
  Robin.send("See you all at alabasta! can't wait to join your crew!");


}
 
}

interface ChatMediator{
  void sendMessage(String message, User sender);
  void addUser(User user);
}

class ChatRoom implements ChatMediator{
  private List<User> users = new ArrayList<>();

  public void addUser(User user){
    users.add(user);
    System.out.println(user.getName()+" joined the chat!");
  }

  public void sendMessage(String message, User sender){
    for(User user: users){
      if(user == sender) continue;
      user.receive(message, sender.getName());
    }
  }
}

class User{
  private String name;
  private ChatMediator mediator;

  User(String name, ChatMediator mediator){
    this.name = name;
    this.mediator = mediator;
  }

  public String getName(){
    return name;
  }

  public void send(String message){
    System.out.println("["+name+"] sends: " +message);
    mediator.sendMessage(message, this);
  }

  public void receive(String message, String from){
    System.out.println("["+name+"] received from "+from+": "+message);
  }

}
