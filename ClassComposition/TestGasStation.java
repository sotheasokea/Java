
import java.util.ArrayList;
import java.util.Scanner;

public class TestGasStation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTruck = input.nextInt();
        ArrayList<TruckS> trucks = new ArrayList<>();
        for(int i = 0; i<numTruck; i++){
            trucks.add(new TruckS(input.nextInt(),input.nextInt()));
        }
        int numGasType = input.nextInt();
        ArrayList<Double> gasAmount = new ArrayList<>();
        for(int i = 0; i<numGasType; i++){
            gasAmount.add(input.nextDouble());
        }
        GasStation1 station = new GasStation1(gasAmount);
        int M = input.nextInt();
        for(int m = 0; m<M; m++){
            int command = input.nextInt(); // 0 to add fuel to truck  1 to add fuel to station
            
            if(command == 0){
            int A = input.nextInt(); // 0-A= truckID
            int T = input.nextInt(); // 0-T= gas type
            double D = input.nextInt(); // 0-D= distance;
            // comand = 1 - A,T,D add gas to each type
                station.fillTank(T, trucks.get(A-1), D);
            }else if(command == 1){
                ArrayList<Double> gass = new ArrayList<>();
                for(int i = 0; i<numGasType; i++){
                    gass.add(input.nextDouble());
                }
                station.reFuel(gass);
            }
            station.print();
        }

        input.close();
    }
}
class GasStation1{
    ArrayList<Double> gasAmount;
    GasStation1(ArrayList<Double> gasAmount){
        this.gasAmount = new ArrayList<>(gasAmount);
    }
    void fillTank(int gasType, TruckS trucks, double distance){
        double gas = trucks.calFuel(distance);
        if(gasAmount.get(gasType-1) >= gas){
            gasAmount.set(gasType-1, gasAmount.get(gasType-1)-gas);
        }else{
            System.out.println(gasType+" out of gasoline");
        }
    }
    void reFuel(ArrayList<Double> gasAdd){
        int cnt = 0;
        for(Double g: gasAdd){
            gasAmount.set(cnt, gasAmount.get(cnt)+g);
            cnt++;
        }
    }
    void print(){
        for(Double gas: gasAmount){
            System.out.print(gas+" ");
        }
        System.out.println();
    }
}