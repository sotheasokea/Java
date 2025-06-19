
import java.util.Scanner;

public class Ethanol1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ethanolPecentage = input.nextInt();
        int cuurentEthonalHave = input.nextInt();// maxValume
        Ethanol ethano = new Ethanol(ethanolPecentage, cuurentEthonalHave);
        int usedEthanol = input.nextInt();
        ethano.used(usedEthanol);
        ethano.printInfo();
        input.close();
    }
}
class Ethanol{
    private int ethanolPecentage;
    private int maxVolume;
    private int ethanolLeft;
    Ethanol(int ethanolPecentage, int maxVolume){
        this.ethanolPecentage = ethanolPecentage;
        this.maxVolume        = maxVolume;
        this.ethanolLeft      = this.maxVolume;
    }
    void used(int ethanolUsed){
        if(ethanolUsed > ethanolLeft){
            ethanolLeft = 0;
        }else{
            ethanolLeft -= ethanolUsed;
        }
    }
    void printInfo(){
        System.out.println("Ethanol "+ethanolPecentage+"% ("+ethanolLeft+"ml./"+maxVolume+"ml.)");
    }
}