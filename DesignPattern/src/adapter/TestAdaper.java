package adapter;

public class TestAdaper {
  public static void main(String[] args) {
    Shared shares = new Shared();
    shares.shared("Messenger", "https://silpakorn.sharepoint.com/sites/GROUP-OOSD-2568-1CSCP.SU/Shared%20Documents/General/DesignPatternsAssign.pdf");
    shares.shared("Facebook", "facebook.link.123");
    shares.shared("IG", "ig.link.com");
    shares.shared("Telegram", "telegram.link.com");
  }
}
