public class Proxy {
  public static void main(String[] args) {
    Database userDatabase = new ProxyDatabse("user");
    userDatabase.query("SELECT* FROM users");

    Database adminDatabase = new ProxyDatabse("admin");
    adminDatabase.query("SELECT* FROM users");
  }
}

interface Database{
  void query(String sql);
}

class RealDatabase implements Database{
  public RealDatabase(){
    System.out.println("Connecting to database...");
  }

  public void query(String sql){
    System.out.println("Executing query: " + sql);
  }
}

class ProxyDatabse implements Database{
  private RealDatabase realDatabse;
  private String userRole;

  public ProxyDatabse(String userRole){
    this.userRole = userRole;
  }

  public void query(String sql){
    System.out.println("User: "+userRole+" is Requestiong query");

    if(!userRole.equalsIgnoreCase("admin")){
      System.out.println("[Denied] Only ADMIN can run queries!");
      return;
    }

    if(realDatabse == null){
      realDatabse = new RealDatabase();
    }
    realDatabse.query(sql);
    System.out.println("[log] Query Completed successfully");
  }

}