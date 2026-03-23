public class MVC{
  public static void main(String[] args) {
    CrewmateModel model = new CrewmateModel(1, "Luffy", "Captain");
    CrewmateView view   = new CrewmateView(model);
    CrewmateController controller = new CrewmateController(model, view);

    System.out.println("========== first view =============");
    view.displayCrewInfo();

    System.out.println("========== Refresh after name change =============");
    controller.updateName("Monkey D. Luffy");
    // view.displayCrewInfo();
  }
}

class CrewmateModel{
  private int joinedOrder;
  private String name;
  private String role;

  public CrewmateModel(int joinedOrder, String name, String role){
    this.joinedOrder = joinedOrder;
    this.name = name;
    this.role = role;
  }

  public String getName(){
    return name;
  }
  public int getJoinedOrder(){
    return joinedOrder;
  }
  public String getRole(){
    return role;
  }

  public void setName(String name){
    this.name = name;
  }
}

class CrewmateView{
  private CrewmateModel crew;
  public CrewmateView(CrewmateModel crew){
    this.crew = crew;
  }

  public void displayCrewInfo(){
    System.out.println("Order joined: "+crew.getJoinedOrder());
    System.out.println("Name: "+crew.getName());
    System.out.println("Role: "+crew.getRole());
  }
}

class CrewmateController{
  private CrewmateModel crewModel; //reference to SAME Model object
  private CrewmateView crewView;

  public CrewmateController(CrewmateModel crewModel, CrewmateView crewView){
    this.crewModel = crewModel;
    this.crewView  = crewView;
  }

  public void updateName(String name){
    crewModel.setName(name);
    crewView.displayCrewInfo();
  }
}