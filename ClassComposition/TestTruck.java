
import java.util.ArrayList;
import java.util.Scanner;

public class TestTruck{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTruck  = input.nextInt();
        ArrayList<TruckS> trucks = new ArrayList<>();
        for(int i = 0; i<numTruck; i++){
            trucks.add(new TruckS(input.nextInt(),input.nextInt()));
        }
        int numUseTruck = input.nextInt();
        for(int i = 0; i<numUseTruck; i++){
            int truckID = input.nextInt()-1;
            double distance= input.nextInt();
            if(truckID>= 0 && truckID <numTruck){
                System.out.println(trucks.get(truckID).calFuel(distance));
            }
        }

        input.close();
    }
}
class TruckS{
    int weight;
    int amount;
    TruckS(int weight,int amount){
        this.weight = weight;
        this.amount = amount;
    }
    double calFuel(double distance){
        double usedFuel = Math.ceil((double)(distance+weight)/10);
        return usedFuel;
    }
}