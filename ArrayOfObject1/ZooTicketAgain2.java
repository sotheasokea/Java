import java.util.ArrayList;
import java.util.Scanner;
public class ZooTicketAgain2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTicket = input.nextInt();
        boolean[] type= new boolean[numTicket];
        for(int i = 0; i<numTicket; i++){
            int t = input.nextInt(); // 1 = general, 2 = kids
            if(t == 1){
                type[i] = false;
            }else if(t == 2){
                type[i] = true;
            }
        }
        ZooTicketA2 ticket = new ZooTicketA2(type);
        int numRequestUseTicket = input.nextInt();
        for(int i = 0; i<numRequestUseTicket; i++){
            int tickectNumber = input.nextInt();
            int howTicketUsed = input.nextInt(); // 1 = enterZoo, 2 = use tram service
            if(howTicketUsed == 1){
                int height = input.nextInt();
                // ZooTicketA2.cnt = tickectNumber;
                System.out.print(ticket.enterZoo(height,tickectNumber));
                System.out.println();
            }else if(howTicketUsed == 2){
                System.out.println(ticket.useRide(tickectNumber));
            }
            
        }

        input.close();
    }
}
class ZooTicketA2{
    ArrayList<Boolean> tickectType;  // true for kid , and false for general
    ArrayList<Boolean> tickectHasUsed;
    ArrayList<Boolean> tramService;
    //static int cnt ;
    ZooTicketA2(boolean[] tickectType) {
        this.tickectType = new ArrayList<>();
        this.tickectHasUsed = new ArrayList<>();
        this.tramService = new ArrayList<>();
        for(boolean type: tickectType){
            this.tickectType.add(type);
            this.tickectHasUsed.add(false);
            this.tramService.add(false);
        }
    }
    boolean enterZoo(int height, int tickectNumber){
        if(tickectNumber <1 || tickectNumber > this.tickectHasUsed.size() || this.tickectHasUsed.get(tickectNumber-1)){
            return false;
        }
        if(this.tickectType.get(tickectNumber-1)){
            if(height <= 120){
                this.tickectHasUsed.set(tickectNumber-1, true);
                this.tramService.set(tickectNumber-1, true);
                return true;
            }
        }else{
            this.tramService.set(tickectNumber-1, true);
            this.tickectHasUsed.set(tickectNumber-1, true);
            return true;
        }
        return false;
              
    }
    boolean useRide(int tickectNumber){
        if(this.tramService.get(tickectNumber-1)){
            this.tramService.set(tickectNumber-1, false);
            return true;
        }else{
            return false;
        }
        
    }
}