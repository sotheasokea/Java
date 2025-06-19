import java.util.ArrayList;
import java.util.Scanner;

public class AliCarCar1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCar = input.nextInt();   input.nextLine();
        //ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Car> car = new ArrayList<>();
        for(int i = 0; i<numCar; i++){
            String carName  = input.next();
            double carPrize = input.nextDouble();
            double carPower = input.nextDouble();
            if(Car.check(carName, carPrize, carPower)){
                System.out.println("valid");
                car.add(new Car(carName));
            }else{
                System.out.println("invalid");
            }
        }
        // for(int i = 0; i<car.size(); i++){
        //     System.out.println(i+1 +" "+car.get(i).carName);
        // }
        int cnt = 1;
        for(Car c: car){
            System.out.println(cnt+" "+c.carName);
            cnt++;
        }
        input.close();
    }
}
class Car{
    String carCode;
    String carName;
    double carPrize;
    double carPower;
    Car(double carPower){
        this.carPower = carPower;
    }
    Car(String carName){
        this.carName = carName;
    }
    static boolean check(String carName,double carPrize,double carPower){
        if(!carName.equals(null) && !carName.equals("") && carPrize >0 && carPower >0){
            return true;
        }
        return false;
    }
}