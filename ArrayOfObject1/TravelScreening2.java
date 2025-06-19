import java.util.Scanner;

public class TravelScreening2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTravelers = input.nextInt();
        Traveler[] travelers = new Traveler[numTravelers];
        for(int i = 0; i< numTravelers; i++){
            input.nextLine();
            String passportID  = input.next();
            String countryName = input.next();
            String dateArrived = input.next();
            double temperature    = input.nextDouble();
            travelers[i] = new Traveler(passportID, countryName, dateArrived, temperature);
        }
        int cntIsQuarantined = 0;
        int cntNotQuarantined = 0;
        for(int i = 0; i<numTravelers; i++){
            if(travelers[i].getIsQuarantined() == 0){
                cntIsQuarantined ++;
            }else if(travelers[i].getIsQuarantined() == -1){
                cntNotQuarantined ++;
            }
        }
        System.out.println(cntNotQuarantined);
        for(int i = 0; i<numTravelers; i++){
            travelers[i].state_QuarantinTravelerInfo();
        }
        System.out.println(cntIsQuarantined);
        for(int i = 0; i<numTravelers; i++){
            travelers[i].self_QuarantinTravelerInfo();
        }
        input.close();
    }
}
class Traveler{
    private String[] ctryQuarantined = {"JAPAN","GERMANY","KOREA","CHINA","TAIWAN","FRANCE","SINGAPORE","ITALY","IRAN"};
    private String passportID;
    private String countryName;
    private String dateArrived;
    private double tempreture;
    private int isQuarantined; // 0 for no and -1 for yes
    Traveler(String passportID, String countryName, String dateArrived, double temperature){
        this.passportID = passportID;
        this.countryName = countryName;
        this.dateArrived = dateArrived;
        this.tempreture = temperature;
        if(temperature > 37.5){
            isQuarantined = -1;
        }else{
            isQuarantined = 0;
            for(String country: this.ctryQuarantined){
                if(this.countryName.equals(country)){
                    isQuarantined = -1;
                    break;
                }
            }
        }
    }
    int getIsQuarantined(){
        return this.isQuarantined;
    }
    void self_QuarantinTravelerInfo(){
        if(this.isQuarantined == 0){
            System.out.println(this.passportID+" "+this.dateArrived);
        }
    }
    void state_QuarantinTravelerInfo(){
        if(this.isQuarantined == -1){
            System.out.println(this.passportID+" "+this.dateArrived);
        }
    }
    void printInfo(){
        System.out.print(passportID+" ");
        if(this.isQuarantined == 0){
            System.out.print("SELF-QUARANTINE");
        }else if(this.isQuarantined == -1){
            System.out.print("STATE-QUARANTINE");
        }
        System.out.println();
    }
}