public class FacadePattern{
  public static void main(String[] args) {
    HomeThearterFacade theater = new HomeThearterFacade();

    theater.watchMovie("Stranger Things");
    System.out.println();
    theater.endMovie();
  }
}

class TV{
  public void turnOn(){
    System.out.println("TV turned ON");
  }
  public void turnOff(){
    System.out.println("TV turned OFF");
  }
  public void setInput(String input){
    System.out.println("TV input set to: "+input);
  }
}

class SoundSystem{
  public void turnOn(){
    System.out.println("Sound system on");
  }
  public void turnOff(){
    System.out.println("Sound system off");
  }
  public void setVolume(int vol){
    System.out.println("Volume set to: "+vol);
  }
}

class DVDPlayer{
  void turnOn(){
    System.out.println("DVD player on");
  }
  void turnOff(){
    System.out.println("DVD player off");
  }
  public void play(String movie){
    System.out.println("Playing: "+movie);
  }
}

class Lights{
  public void dim(int level){
    System.out.println("Lights dimmed to: "+level+"%");
  }
  public void brighten(){
    System.out.println("Lights brightened");
  }
}

class HomeThearterFacade{
  private TV tv;
  private SoundSystem sound;
  private DVDPlayer dvd;
  private Lights lights;

  public HomeThearterFacade(){
    this.tv = new TV();
    this.sound = new SoundSystem();
    this.dvd = new DVDPlayer();
    this.lights = new Lights();
  }

  public void watchMovie(String movie){
    System.out.println("--- Getting ready for the movie ---");
    lights.dim(30);
    tv.turnOn();
    tv.setInput("HDMI");
    sound.turnOn();
    sound.setVolume(20);
    dvd.turnOn();
    dvd.play(movie);
    System.out.println("--- Enjoy your movie ---");
  }

  public void endMovie(){
    System.out.println("---- Shutting down the Movie ---");
    dvd.turnOff();
    sound.turnOff();
    tv.turnOff();
    lights.brighten();
    System.out.println("--- Thanks for watching ---");
  }
}