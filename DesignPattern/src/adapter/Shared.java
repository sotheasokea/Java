package adapter;
public class Shared{
  private SharedButton sharedTo;

  // public void sharedInYoutube(String link){
  //   System.out.println("Youtube Link: "+link);
  // }
  public void shared(String platform, String link){
    if(platform.equals("IG")){
      System.out.println("IG link: "+link);
    }else if(platform.equals("Facebook") || platform.equals("Messenger")){
      sharedTo = new SharedButton();
      sharedTo.shared(platform, link);
    }else{
      System.out.println("Can't share link "+link+" to platform: "+platform);
    }
  }
}