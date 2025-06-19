
import java.util.Scanner;

public class FishyPond {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int width = input.nextInt();
        int radius = input.nextInt();
        Pond pond = new Pond(width, radius);
        pond.printInfo();
        while (true) { 
         int command = input.nextInt();
         if(command == 0){
            //pond.printInfo();
            break;
         }else if(command == 1){
            int fishOut = input.nextInt();
            pond.takeFish(fishOut);
            // pond.printInfo();
         }else if(command == 2){
            int hour = input.nextInt();
            pond.reprodutive(hour);
            //pond.printInfo();
         }else if(command == 3){
            int addRadius = input.nextInt();
            pond.expand(addRadius);
            // pond.printInfo();
         }
         pond.printInfo();
        }

        input.close();
    }
}
class Pond{
    int depth;
    int radius;
    int fishInPond;
    Pond(int depth, int radius){
        this.depth = depth;
        this.radius = radius;
        this.fishInPond = 20*this.depth*this.radius;
    }
    void reprodutive(int hour){
        fishInPond += ((hour*radius*depth)/4) + ((hour*fishInPond)/3);
    }
    void takeFish(int fishOut){
        if(fishInPond-fishOut > 0){
            fishInPond -= fishOut;
        }else{
            fishInPond = 0;
        }
    }
    void expand(int addRadius){
        if(this.radius+addRadius <= 50){
            this.radius += addRadius;
        }else{
            this.radius = 50;
        }
    }
    void printInfo(){
        System.out.println("Depth "+depth+", Radius "+radius+", Fish "+fishInPond);
    }
}
