import java.util.Scanner;

public class ComSpec1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String model = input.nextLine();
        int speed = input.nextInt();
        int socketType = input.nextInt();
        int cpuType = input.nextInt();
        if(model.length() == 0 && socketType %2 == 0){
            model = null;
        }
        CPU cpu = new CPU(model, speed, socketType, cpuType);
        cpu.printInfo();
        input.close();
    }
}
// class CPU{
//     String cpuGen;
//     int speed;
//     int socketType;
//     int cpuType;
//     boolean valid = true;
//     static boolean isValid(String cpuGen, int speed,int socketType,int cpuType){
//         if(cpuGen == null || cpuGen.equals("")){
//             return false;
//         }
//         if(speed <= 0){
//             return false;
//         }
//         if(socketType <= 0){
//             return false;
//         }
//         if(cpuType<=0 || cpuType >10){
//             return false;
//         }
//         return true;
//     }
//     CPU(String cpuGen, int speed,int socketType,int cpuType){
//         this.cpuGen = cpuGen;
//         this.speed = speed;
//         this.socketType = socketType;
//         this.cpuType = cpuType;
//         this.valid = CPU.isValid(cpuGen, speed, socketType, cpuType);
//     }
//     void printInfo(){
//         System.out.println(cpuGen);
//         System.out.println(speed);
//         System.out.println(socketType);
//         System.out.println(cpuType);
//         System.out.println(valid);
//     }
// }
// class MainBoard{

// }
// class Computer{

// }