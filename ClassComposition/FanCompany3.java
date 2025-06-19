
import java.util.Scanner;

public class FanCompany3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int size,numb,angle;
        double hp,v,i,eff;
        Blade ablade = new Blade();
        Motor motor = new Motor();
        ElectricFan eFan= new ElectricFan();
        for(int index=0;index<n;index++){
        int cmd = input.nextInt();
        if (cmd==0){
        size = input.nextInt();
        numb = input.nextInt();
        angle = input.nextInt();
        hp = input.nextDouble();
        ablade = new Blade(size,numb,angle,hp);
        v = input.nextDouble();
        i = input.nextDouble();
        eff = input.nextDouble();
        motor = new Motor(v,i,eff);
        eFan = new ElectricFan(ablade, motor);
        }else if(cmd==1){
        size = input.nextInt();
        numb = input.nextInt();
        angle = input.nextInt();
        hp = input.nextDouble();
        ablade = new Blade(size,numb,angle,hp);
        eFan.changeBlade(ablade);
        }else if(cmd==2){
        v = input.nextDouble();
        i = input.nextDouble();
        eff = input.nextDouble();
        motor = new Motor(v,i,eff);
        eFan.changeMotor(motor);
        }
        eFan.printInfo();
        }

        input.close();
    }
}
class Blade{
    int bladeSize; // 16 <= bladeSize <= 24
    int numberofBlade; // 3, 4, 5
    int bladeAngle; // 27 , 30 , 33 (degree)
    double horsepower; // > 0 hp
    boolean validInfo = true; // true= info. correct , false= wrong

    Blade() {
        this.bladeSize = 0;
        this.numberofBlade = 0;
        this.bladeAngle = 0;
        this.horsepower = 0.0;
        validInfo = false;
    }
    
    Blade(int bladeSize, int numberofBlade, int bladeAngle, double horsepower){
        this.bladeSize = bladeSize;
        this.numberofBlade = numberofBlade;
        this.bladeAngle = bladeAngle;
        this.horsepower = horsepower;
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
        if(this.horsepower <= 0.0){
            System.out.println("invalid horsepower");
            this.validInfo = false;
        }
    }
    void printInfo(){
        System.out.printf("%d %d %d %.2f %b%n",this.bladeSize,this.numberofBlade,this.bladeAngle,this.horsepower,this.validInfo);
    }
}
class Motor{
    double voltage_V;
    double current_I;
    double efficiency_eff;

    Motor() {
        this.voltage_V = 0.0;
        this.current_I = 0.0;
        this.efficiency_eff = 0.0;
    }
    
    Motor(double voltage_V, double current_I, double efficiency_eff){
        this.voltage_V = voltage_V;
        this.current_I = current_I;
        this.efficiency_eff = efficiency_eff/100.0;
    }
    Motor(double current_I, double efficiency_eff){
        this.voltage_V = 220;
        this.current_I = current_I;
        this.efficiency_eff = efficiency_eff/100.0;
    }
    double horsePower(){
        return (voltage_V*current_I*efficiency_eff)/746.0;
    }
    void printInfo(){
        System.out.printf(voltage_V+" "+current_I+" "+efficiency_eff+" %.2f",horsePower());
        System.out.println();
    }
}
class ElectricFan{
    int productID;
    Blade bladeEfan;
    Motor motorEfan;
    boolean status;
    static int count = 0;

    ElectricFan() {
        this.productID = ElectricFan.count;
        this.status = false;
    }
    
    ElectricFan(Blade bladeEfan, Motor motorEfan){
        ElectricFan.count ++;
        this.productID = ElectricFan.count;
        this.bladeEfan = bladeEfan;
        this.motorEfan = motorEfan;
        this.status = (this.bladeEfan.horsepower <= this.motorEfan.horsePower());
    }
    boolean changeBlade(Blade bladeEfan){
        this.bladeEfan = bladeEfan;
        this.status = (this.bladeEfan.horsepower <= this.motorEfan.horsePower());
        return status;
    }
    boolean changeMotor(Motor motorEfan){
        this.motorEfan = motorEfan;
        this.status = (this.bladeEfan.horsepower <= this.motorEfan.horsePower());
        return status;
    }
    void printInfo(){
        System.out.printf(this.productID+" "+bladeEfan.bladeSize+" "+bladeEfan.horsepower+" "+motorEfan.current_I+" %.2f",motorEfan.horsePower());
        System.out.println(" "+this.status);
    }
}