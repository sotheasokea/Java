
import java.util.Scanner;

public class TravelerScreening1 {
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
        for(int i = 0; i<numTravelers; i++){
            travelers[i].printInfo();
        }
        input.close();
    }
}
// class Traveler{
//     private String[] ctryQuarantined = {"JAPAN","GERMANY","KOREA","CHINA","TAIWAN","FRANCE","SINGAPORE","ITALY","IRAN"};
//     private String passportID;
//     private String countryName;
//     private String dateArrived;
//     private double tempreture;
//     private int isQuarantined; // 0 for no and -1 for yes
//     Traveler(String passportID, String countryName, String dateArrived, double temperature){
//         this.passportID = passportID;
//         this.countryName = countryName;
//         this.tempreture = temperature;
//         if(temperature > 37.5){
//             isQuarantined = -1;
//         }else{
//             isQuarantined = 0;
//             for(String country: this.ctryQuarantined){
//                 if(this.countryName.equals(country)){
//                     isQuarantined = -1;
//                     break;
//                 }
//             }
//         }
//     }
//     void printInfo(){
//         System.out.print(passportID+" ");
//         if(this.isQuarantined == 0){
//             System.out.print("SELF-QUARANTINE");
//         }else if(this.isQuarantined == -1){
//             System.out.print("STATE-QUARANTINE");
//         }
//         System.out.println();
//     }
// }