
import java.util.Scanner;

public class  Marathon1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfRunner = input.nextInt();
        Runner[] runner = new Runner[numberOfRunner];
        for(int i = 0; i<numberOfRunner; i++){
            input.nextLine();
            String runnerName = input.next();
            int runType = input.nextInt();
            runner[i] = new Runner(runnerName, runType);
            runner[i].printInfo();
        }
        input.close();
    }
}
// class Runner{
//     private String runnerName;
//     private String BIB ="";
//     private static int numberOfRunner = 0;
//     Runner(String runnerName, int runType){
//         // 1 = fun run, 2 = mini marathon , 3 = half marathon , 4 = marathon
//         this.runnerName = runnerName;
        
//         switch (runType) {
//             case 1:
//             Runner.numberOfRunner ++;
//                 String number1 = String.format("%03d", Runner.numberOfRunner);
//                 this.BIB = "A"+number1;
//             break;
//             case 2: 
//             Runner.numberOfRunner ++;
//                 String number2 = String.format("%03d", Runner.numberOfRunner);
//                 this.BIB = "B"+number2;
//             break;
//             case 3:
//             Runner.numberOfRunner ++;
//                 String number3 = String.format("%03d", Runner.numberOfRunner);
//                 this.BIB = "C"+number3;
//             break;
//             case 4:
//             Runner.numberOfRunner ++;
//                 String number4 = String.format("%03d", Runner.numberOfRunner);
//                 this.BIB = "D"+number4;
//             break;
//             default:
//                 System.out.println("INVALID");    
//         }
//     }
//     void printInfo(){
//         if(!this.BIB.equals("")){
//             System.out.println(this.BIB+" "+this.runnerName);
//         }
        
//     }
// }