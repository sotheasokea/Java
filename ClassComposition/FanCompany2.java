
import java.util.Scanner;

public class FanCompany2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double voltage_V = input.nextDouble();
        double current_I = input.nextDouble();
        double efficency_eff = input.nextDouble();
        Motor motor;
        if(voltage_V == 220){
            motor = new Motor(current_I, efficency_eff);
        }else{
            motor = new Motor(voltage_V, current_I, efficency_eff);
        }
        motor.printInfo();
        input.close();
    }
}
// class Blade{
//     int bladeSize; // 16 <= bladeSize <= 24
//     int numberofBlade; // 3, 4, 5
//     int bladeAngle; // 27 , 30 , 33 (degree)
//     double horsePower; // > 0 hp
//     boolean validInfo = true; // true= info. correct , false= wrong
//     Blade(int bladeSize, int numberofBlade, int bladeAngle, double horsePower){
//         this.bladeSize = bladeSize;
//         this.numberofBlade = numberofBlade;
//         this.bladeAngle = bladeAngle;
//         this.horsePower = horsePower;
//         if(this.bladeSize%2 !=0 || 16 >this.bladeSize || bladeSize > 24){
//             System.out.println("invalid size");
//             this.validInfo = false;
//         }
//         if(3> numberofBlade || numberofBlade >5){
//             System.out.println("invalid number of blades");
//             this.validInfo = false;
            
//         }
//         if(!(this.bladeAngle == 27 || this.bladeAngle == 30 || this.bladeAngle == 33)){
//             System.out.println("invalid angle");
//             this.validInfo = false;
//         }
//         if(this.horsePower <0.0){
//             System.out.println("invalid horsepower");
//             this.validInfo = false;
//         }
//     }
//     void printInfo(){
//         System.out.printf("%d %d %d %.2f %b%n",this.bladeSize,this.numberofBlade,this.bladeAngle,this.horsePower,this.validInfo);
//     }
// }
// class Motor{
//     double voltage_V;
//     double current_I;
//     double efficency_eff;
//     Motor(double voltage_V, double current_I, double efficency_eff){
//         this.voltage_V = voltage_V;
//         this.current_I = current_I;
//         this.efficency_eff = efficency_eff/100.0;
//     }
//     Motor(double current_I, double efficency_eff){
//         this.voltage_V = 220;
//         this.current_I = current_I;
//         this.efficency_eff = efficency_eff/100.0;
//     }
//     double horsePower(){
//         return (voltage_V*current_I*efficency_eff)/746.0;
//     }
//     void printInfo(){
//         System.out.printf(voltage_V+" "+current_I+" "+efficency_eff+" %.2f",horsePower());
//         System.out.println();
//     }
// }
// class ElectricFan{

// }