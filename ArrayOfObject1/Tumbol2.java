import java.util.Scanner;

public class Tumbol2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTumbol = input.nextInt();
        Tumbol[] tumbol = new Tumbol[numOfTumbol];
        int total = 0;
        for(int i = 0; i<numOfTumbol; i++){
            input.nextLine();
            String tumbolName = input.nextLine();
            int tumbol_Latitude = input.nextInt();
            int tumbo_Longitude = input.nextInt();
            int numOfCitizen = input.nextInt();
            tumbol[i] = new Tumbol(tumbolName, tumbol_Latitude, tumbo_Longitude, numOfCitizen);
        }
        for(int i = 0; i<numOfTumbol; i++){
            int numOfRequest = input.nextInt();
            int[] budjectRequest = new int[numOfRequest];
                for(int j = 0; j<numOfRequest; j++){
                    budjectRequest[j] = input.nextInt();
                }
            total += tumbol[i].allocateBudget(budjectRequest);
            System.out.println();
        }
        System.out.println(total);

        input.close();
    }
}
class Tumbol{
    private String tumbolName;
    private int tumbol_Latitude;    // north or south
    private int tumbo_Longitude;    // east or west
    private int numOfCitizen;
    private int availBudject;
    Tumbol(String tumbolName, int tumbol_Latitude, int tumbo_Longitude, int numOfCitizen){
        this.tumbolName = tumbolName;
        this.tumbol_Latitude = tumbol_Latitude;
        this.tumbo_Longitude = tumbo_Longitude;
        this.numOfCitizen = numOfCitizen;
        this.availBudject = this.numOfCitizen*5000;
    }
    int allocateBudget(int[] budject){
        int totalBudject = 0;
        for(int i = 0; i< budject.length; i++){
            if(totalBudject + budject[i] <= this.availBudject){
                System.out.print(i+1 +" ");
                totalBudject += budject[i];
            }
        }
        if(totalBudject == 0){
            System.out.print("none");
        }
        return totalBudject;
    }

}