import java.util.Scanner;

public class StationAndCar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gasoline  = input.nextInt();
        int diesel    = input.nextInt();
        Station station = new Station(gasoline, diesel);
        int numOPs = input.nextInt();
        for(int i = 0; i<numOPs; i++){
            int A = input.nextInt();// 1=dispense, 2= refill
            int B = input.nextInt();// A=1->B=gasType car, A=2-> B(1=gasoline,2=diesel)
            int C = input.nextInt();// A=1->C= carVolume, A=2-> C= gas amount add to station
            int D = input.nextInt();// A=1->D= gasInCar
            if(A == 1){
                CarS car = new CarS(B,C,D);
                station.dispence(car);
            }else if(A == 2){
                if(B == 1){
                    station.refillBenzin(C);
                }else if(B == 2){
                    station.refillDiesel(C);
                }
            }
        }

        input.close();
    }
}
class Station{
    int gasoline;
    int diesel;
    Station(int gasoline, int diesel){
        this.gasoline = gasoline;
        this.diesel   = diesel;
    }
    void dispence(CarS cars){
        int addGas = cars.getNeededVol();
        if(cars.gasType == 1){
            if(addGas <= gasoline){
                gasoline-= addGas;
                System.out.println("Dispense "+addGas+" liters of benzin");
            }else{
                System.out.println("Dispense "+gasoline+" liters of benzin");
                gasoline = 0;
            }
        }else if(cars.gasType == 2){
            if(addGas <= diesel){
                diesel-= addGas;
                System.out.println("Dispense "+addGas+" liters of diesel");
            }else{
                System.out.println("Dispense "+diesel+" liters of diesel");
                diesel = 0;
            }
        }
    }
    void refillBenzin(int gas){
        this.gasoline += gas;
        System.out.println("Station has "+gasoline+" liters of benzin");
    }
    void refillDiesel(int gas){
        this.diesel += gas;
        System.out.println("Station has "+diesel+" liters of diesel");
    }
}
class CarS{
    int gasType; // 1= gasolin and 2= diesel
    int carVolume;
    int gasInCar;
    CarS(int gasType, int carVolume, int gasInCar){
        this.gasType = gasType;
        this.carVolume = carVolume;
        this.gasInCar= gasInCar;
    }
    int getNeededVol(){
        return (carVolume-gasInCar);
    }
}