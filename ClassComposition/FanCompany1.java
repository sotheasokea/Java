
import java.util.Scanner;

public class FanCompany1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bladeSize = input.nextInt(); // 16 <= bladeSize <= 24
        int numberofBlade = input.nextInt(); // 3, 4, 5
        int bladeAngle = input.nextInt(); // 27 , 30 , 33 (degree)
        double horsePower = input.nextDouble(); // > 0 hp
        Blade blade = new Blade(bladeSize, numberofBlade, bladeAngle, horsePower);
        blade.printInfo();
        input.close();
    }
}
/*
class Blade{
    int bladeSize; // 16 <= bladeSize <= 24
    int numberofBlade; // 3, 4, 5
    int bladeAngle; // 27 , 30 , 33 (degree)
    double horsePower; // > 0 hp
    boolean validInfo = true; // true= info. correct , false= wrong
    Blade(int bladeSize, int numberofBlade, int bladeAngle, double horsePower){
        this.bladeSize = bladeSize;
        this.numberofBlade = numberofBlade;
        this.bladeAngle = bladeAngle;
        this.horsePower = horsePower;
        if(this.bladeSize%2 !=0 || 16 >this.bladeSize || bladeSize > 24){
            System.out.println("invalid size");
            this.validInfo = false;
        }
        if(3> numberofBlade || numberofBlade >5){
            System.out.println("invalid number of blades");
            this.validInfo = false;
            
        }
        if(!(this.bladeAngle == 27 || this.bladeAngle == 30 || this.bladeAngle == 33)){
            System.out.println("invalid angle");
            this.validInfo = false;
        }
        if(this.horsePower <0.0){
            System.out.println("invalid horsepower");
            this.validInfo = false;
        }
    }
    void printInfo(){
        System.out.printf("%d %d %d %.2f %b%n",this.bladeSize,this.numberofBlade,this.bladeAngle,this.horsePower,this.validInfo);
    }
}
class Motor{

}
class ElectricFan{

}
*/