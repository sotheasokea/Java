import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
  public static void main(String[] args) {
    YoutubeChannel channel = new YoutubeChannel("SotheaTube");

    Subscriber s1 = new Subscriber("Donnie");
    Subscriber s2 = new Subscriber("Rocky");
    Subscriber s3 = new Subscriber("Harn");

    channel.subscribe(s1);
    channel.subscribe(s2); 
    channel.subscribe(s3);

    channel.uploadVideo("How to learn something, while doing nothing");

    channel.unsubscribe(s2);
    channel.uploadVideo("What have we learn from doing nothing? summary");

  }
}

interface Observer{
  void update(String video);
}

interface subject{
  void subscribe(Observer obser);
  void unsubscribe(Observer obser);
  void notifyUser();
}

class YoutubeChannel implements subject{
  private List<Observer> observer = new ArrayList<>();
  private String channelName;
  private String lastestVideo;

  public YoutubeChannel(String channelName){
    this.channelName = channelName;
  }

  public void subscribe(Observer observer){
    this.observer.add(observer);
    System.out.println("New subscriber added!");
  }
  public void unsubscribe(Observer observer){
    this.observer.remove(observer);
    System.out.println("Subscriber removed!");
  }

  public void notifyUser(){
    for(Observer ob: observer){
      ob.update(lastestVideo);
    }
  }

  public void uploadVideo(String latestVideo){
    this.lastestVideo = latestVideo;
    System.out.println("["+channelName+"] Uploaded: "+latestVideo);
    notifyUser();
  }
}

class Subscriber implements Observer{
  private String name;

  public Subscriber(String name){
    this.name = name;
  }

  public void update(String video){
    System.out.println("[NOTIFICATION] "+name+" -> New video: "+video);
  }
}
