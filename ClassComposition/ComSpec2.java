import java.util.Scanner;

public class ComSpec2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // input for CPU
        String model = input.nextLine();
        int speed = input.nextInt();
        int socketType = input.nextInt();
        int Type = input.nextInt();
        if(model.length() == 0 && socketType %2 == 0){
            model = null;
        }
        CPU cpu = new CPU(model, speed, socketType, Type);
        input.nextLine();
        // input for Mainboard
        model = input.nextLine();
        socketType = input.nextInt();
        Type = input.nextInt();
        if(model.length() == 0 && socketType %2 == 0){
            model = null;
        }
        MainBoard mainBoard = new MainBoard(model, socketType, Type);
        Computer computer = new Computer(mainBoard, cpu);
        computer.printInfo();

        input.close();
    }
}
class CPU{
    String cpuGen;
    int speed;
    int socketType;
    int cpuType;
    boolean valid = true;
    static boolean isValid(String cpuGen, int speed,int socketType,int cpuType){
        if(cpuGen == null || cpuGen.equals("")){
            return false;
        }
        if(speed <= 0){
            return false;
        }
        if(socketType <= 0){
            return false;
        }
        if(cpuType<=0 || cpuType >10){
            return false;
        }
        return true;
    }
    CPU(String cpuGen, int speed,int socketType,int cpuType){
        this.cpuGen = cpuGen;
        this.speed = speed;
        this.socketType = socketType;
        this.cpuType = cpuType;
        this.valid = CPU.isValid(cpuGen, speed, socketType, cpuType);
    }
    void printInfo(){
        System.out.println(cpuGen);
        System.out.println(speed);
        System.out.println(socketType);
        System.out.println(cpuType);
        System.out.println(valid);
    }
}
class MainBoard{
    String mainboardName;
    int mbSocket;
    int mbType;
    boolean mbValid;
    boolean isValidSpec(String mainboardName, int mbSocket, int mbType){
        if(mainboardName == null || mainboardName.equals("")){
            return false;
        }
        if(mbSocket <= 0){
            return false;
        }
        if(mbType <= 0 || mbType >10){
            return false;
        }
        return true;
    }
    MainBoard(String mainboardName, int mbSocket, int mbType) {
        this.mainboardName = mainboardName;
        this.mbSocket = mbSocket;
        this.mbType = mbType;
        this.mbValid = isValidSpec(mainboardName, mbSocket, mbType);
    }
    void printInfo(){
        System.out.println(mainboardName);
        System.out.println(mbSocket);
        System.out.println(mbType);
        System.out.println(mbValid);
    }
    
}
class Computer{
    MainBoard mainboard;
    CPU cpu;
    boolean comValid;
    boolean isValidCom(MainBoard mainboard,CPU cpu){
        this.mainboard = mainboard;
        this.cpu = cpu;
        if(!cpu.valid){
            return false;
        }
        if(!mainboard.mbValid){
            return false;
        }
        if(this.mainboard.mbSocket != this.cpu.socketType){
            return false;
        }
        if(this.mainboard.mbType != this.cpu.cpuType){
            return false;
        }
        return true;
    }
    Computer(MainBoard mainboard, CPU cpu){
        this.mainboard = mainboard;
        this.cpu = cpu;
        this.comValid = isValidCom(mainboard, cpu);
    }
    void printInfo(){
        if(comValid){
            System.out.println(cpu.cpuGen);
            System.out.println(cpu.speed);
            System.out.println(mainboard.mainboardName);
            System.out.println(mainboard.mbSocket);
            System.out.println(mainboard.mbType);
        }else{
            System.out.println("Invalid Spec");
            cpu.printInfo();
            mainboard.printInfo();
        }
        
    }
}