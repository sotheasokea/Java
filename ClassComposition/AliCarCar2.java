
import java.util.ArrayList;
import java.util.Scanner;

public class AliCarCar2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCar = input.nextInt();   input.nextLine();
        ArrayList<Car> car = new ArrayList<>();
        for(int i = 0; i<numCar; i++){
            String carName  = input.next();
            double carPrize = input.nextDouble();
            double carPower = input.nextDouble();
            if(Car.check(carName, carPrize, carPower)){
                // System.out.println("valid");
                car.add(new Car(carPower));
            }
            // else{
            //     System.out.println("invalid");
            // }
        }
        ArrayList<Factory> factorys = new ArrayList<>();
        for(int i = 0; i<5; i++){
            int countCanMake = 0;
            double fullFactoryPower = input.nextDouble();
            boolean[] canMake = new boolean[numCar];
            for(int m = 0; m<numCar; m++){
                canMake[m] = (input.nextInt() == 1);
                if(canMake[m]){ countCanMake++; }
            }
            factorys.add(new Factory(countCanMake, canMake, fullFactoryPower));
        }
        int numCustomer = input.nextInt();
        for(int c = 0; c<numCustomer; c++){
            int carProNumber = input.nextInt();
            if(1> carProNumber || carProNumber > car.size()){
                System.out.println("invalid model");
                continue;
            }
            boolean found = false;
            int cnt = 0;
            for(Factory f: factorys){
                cnt++;
                if(f.canMake[carProNumber-1] && (f.fullFactoryPower >= f.usedPower+car.get(carProNumber-1).carPower)){
                    f.usedPower += car.get(carProNumber-1).carPower;
                    found = true;
                    System.out.println("okay "+cnt);
                    break;
                }
            }
            if(!found){ System.out.println("unable to build");  }
        }
        
        input.close();
    }
}
class Factory{
    // private ArrayList<String> car;
    int numberOfCar;
    boolean[] canMake;
    double fullFactoryPower;
    double usedPower;
    // ArrayList<Car> cars;
    Factory(int numberOfCar ,boolean[] canMake,double fullFactoryPower){
        this.numberOfCar = numberOfCar;
        this.canMake = canMake;
        this.fullFactoryPower = fullFactoryPower;
        this.usedPower = 0;
    }
    
}