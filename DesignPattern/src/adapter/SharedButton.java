package adapter;

public class SharedButton implements SharedAble{
  private MultipleShared sharedToPlatform;
  public SharedButton(){
    this.sharedToPlatform = new MultipleShared();
  }

  public void shared(String platform, String link){
    if(platform.equals("Facebook")){
      sharedToPlatform.sharedInFacebook("www.facebook.com/user=23&id=willthiswork?");
    }else{
      sharedToPlatform.sharedInMessenger("messege.sendto/user=itworked1&id=hope2");
    }
  }
}
