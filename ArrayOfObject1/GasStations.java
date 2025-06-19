
import java.util.Scanner;

public class GasStations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numPlace  = input.nextInt();
        GasStation[] station = new GasStation[numPlace];
        for(int i = 0; i<numPlace; i++){
            int[] volumeForEachType = new int[7];
            boolean[] hasGasType = new boolean[7];
            for(int g = 1; g<7; g++){
                volumeForEachType[g] = input.nextInt();
                hasGasType[g] = (volumeForEachType[g] >0);
            }
            station[i] = new GasStation(hasGasType, volumeForEachType);
        }
        
        int nOps = input.nextInt();
        for(int n = 0; n<nOps; n++){
            /*
            A -> 1 = dispese, 2= refill , 3 = report
            S = number of place 1- numPlace
            B = gasType 1-6
            C = amount of gas
            */
            int A = input.nextInt();
            int S = input.nextInt();
            int B = input.nextInt();
            int C = input.nextInt();
            switch (A) {
                case 1:
                    station[S-1].dispense(B, C);
                    break;
                case 2:
                    station[S-1].refillStation(B, C);
                    break;
                case 3:
                    station[S-1].report();
                    break;
                default:
                    break;
            }
        }

        input.close();
    }
}
class GasStation{
    // 
    String[] gasTypeName = { " ","95S", "91S", "E20", "E85", "B7", "B20" };
    boolean[] hasThisGasType = new boolean[7];
    int[] volume = new int[7];
    int[] maxVolume = new int[7];
    GasStation(boolean[] hasThisGasType, int[] volume){
        for(int i = 1; i<7; i++){
            this.hasThisGasType[i] = hasThisGasType[i];
            this.volume[i] = volume[i];
            this.maxVolume[i] = this.volume[i];
        }
    }
    void dispense(int gasType, int gasOut){
        if(1<= gasType && gasType <= 6){
            if(this.hasThisGasType[gasType]){
                if(this.volume[gasType] == 0){
                    System.out.println("No gas available");
                }else{
                    if(gasOut <= this.volume[gasType]){
                        this.volume[gasType] -= gasOut;
                        System.out.println("Dispense "+gasOut+" liters");
                    }else{
                        System.out.println("Dispense "+this.volume[gasType]+" liters");
                        this.volume[gasType] = 0;
                    }
                }
            }else{
                System.out.println("Invalid gas type");
            }
        }
    }
    void refillStation(int gasType, int gasIn){
        if(1<= gasType && gasType <= 6){
            if(this.hasThisGasType[gasType]){
                if(this.volume[gasType] == this.maxVolume[gasType]){
                    System.out.println("No storage capacity available");
                }else if(gasIn + this.volume[gasType] > this.maxVolume[gasType]){
                        int refill = this.maxVolume[gasType] - this.volume[gasType];
                        this.volume[gasType] = this.maxVolume[gasType];
                        System.out.println("Refill "+refill+" liters");
                }else{
                    this.volume[gasType] += gasIn;
                    System.out.println("Refill "+gasIn+" liters");
                }
            }else{
                System.out.println("Invalid gas type");
            }
            }
        }
    
    void report(){
        for(int i = 1; i<7; i++){
            if(this.hasThisGasType[i]){
                System.out.print(this.gasTypeName[i]+" "+this.volume[i]+ ", ");
            }
        }
        System.out.println();
    }
}