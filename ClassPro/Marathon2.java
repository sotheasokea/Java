import java.util.Scanner;

public class Marathon2 {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfRunner = input.nextInt();
        Runner[] runner = new Runner[numberOfRunner];
        for(int i = 0; i<numberOfRunner; i++){
            input.nextLine();
            String runnerName = input.next();
            int runType = input.nextInt();
            runner[i] = new Runner(runnerName, runType);
            // runner[i].printInfo();
        }
        for(char ch = 'A'; ch<= 'D'; ch++){
            // char ch = (char)(65+k);
            int cnt = 0;
            for(int i = 0; i<numberOfRunner; i++){
                if(runner[i].getBIB().charAt(0) == ch){
                    cnt++;
                }
            }
            System.out.println(cnt);
            if(cnt == 0){
                System.out.println("-");
                continue;
            }
            for(int i = 0; i<numberOfRunner; i++){
                if(runner[i].getBIB().charAt(0) == ch){
                    System.out.print(runner[i].getBIB()+" ");
                }
            }
            System.out.println();
        }
        input.close();
    }
}
class Runner{
    private String runnerName;
    private String BIB ="";
    private static int numberOfRunner = 0;
    // private int[] cntEachType = new int[4];
    Runner(String runnerName, int runType){
        // 1 = fun run, 2 = mini marathon , 3 = half marathon , 4 = marathon
        this.runnerName = runnerName;
        
        switch (runType) {
            case 1:
            Runner.numberOfRunner ++;
                String number1 = String.format("%03d", Runner.numberOfRunner);
                this.BIB = "A"+number1;
                // cntEachType[0] ++;
            break;
            case 2: 
            Runner.numberOfRunner ++;
                String number2 = String.format("%03d", Runner.numberOfRunner);
                this.BIB = "B"+number2;
                // cntEachType[1] ++;
            break;
            case 3:
            Runner.numberOfRunner ++;
                String number3 = String.format("%03d", Runner.numberOfRunner);
                this.BIB = "C"+number3;
            break;
            case 4:
            Runner.numberOfRunner ++;
                String number4 = String.format("%03d", Runner.numberOfRunner);
                this.BIB = "D"+number4;
            break;
            default:
                this.BIB = "-1";   
                // if BIB = "", when we call to use in main will be error 
            break;
        }
    }
    String getBIB(){
        return this.BIB;
    }
    void printInfo(){
        if(!this.BIB.equals("")){
            System.out.println(this.BIB+" "+this.runnerName);
        }    
    }
}