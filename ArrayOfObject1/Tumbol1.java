
import java.util.Scanner;

public class Tumbol1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tumbolName = input.nextLine();
        int tumbol_Latitude = input.nextInt();
        int tumbo_Longitude = input.nextInt();
        int numOfCitizen = input.nextInt();
        Tumbol tumbol = new Tumbol(tumbolName, tumbol_Latitude, tumbo_Longitude, numOfCitizen);
        int numOfRequest = input.nextInt();
        int[] budjectRequest = new int[numOfRequest];
        for(int i = 0; i<numOfRequest; i++){
            budjectRequest[i] = input.nextInt();
        }
        tumbol.allocateBudget(budjectRequest);

        input.close();
    }
}
// class Tumbol{
//     String tumbolName;
//     int tumbol_Latitude;    // north or south
//     int tumbo_Longitude;    // east or west
//     int numOfCitizen;
//     int availBudject;
//     Tumbol(String tumbolName, int tumbol_Latitude, int tumbo_Longitude, int numOfCitizen){
//         this.tumbolName = tumbolName;
//         this.tumbol_Latitude = tumbol_Latitude;
//         this.tumbo_Longitude = tumbo_Longitude;
//         this.numOfCitizen = numOfCitizen;
//         this.availBudject = this.numOfCitizen*5000;
//     }
//     void allocateBudget(int[] budject){
//         int totalBudject = 0;
//         for(int i = 0; i< budject.length; i++){
//             if(totalBudject + budject[i] <= this.availBudject){
//                 System.out.print(i+1 +" ");
//                 totalBudject += budject[i];
//             }
//         }
//     }

// }