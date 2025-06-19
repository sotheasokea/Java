
import java.util.ArrayList;
import java.util.Scanner;
public class ZooTicketAgain1 {
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
        ZooTicketA ticket = new ZooTicketA(type);
        int numRequestUseTicket = input.nextInt();
        for(int i = 0; i<numRequestUseTicket; i++){
            int tickectNumber = input.nextInt();
            int height = input.nextInt();
            // ZooTicketA.cnt = tickectNumber;
            System.out.print(ticket.enterZoo(height,tickectNumber));
            System.out.println();
        }

        input.close();
    }
}
class ZooTicketA{
    ArrayList<Boolean> tickectType;  // true for kid , and false for general
    ArrayList<Boolean> tickectHasUsed;
    //static int cnt ;
    ZooTicketA(boolean[] tickectType) {
        this.tickectType = new ArrayList<>();
        this.tickectHasUsed = new ArrayList<>();
        for(boolean type: tickectType){
            this.tickectType.add(type);
            this.tickectHasUsed.add(false);
        }
    }
    boolean enterZoo(int height, int tickectNumber){
        if(tickectNumber <1 || tickectNumber > this.tickectHasUsed.size() || this.tickectHasUsed.get(tickectNumber-1)){
            return false;
        }
        if(this.tickectType.get(tickectNumber-1)){
            if(height <= 120){
                this.tickectHasUsed.set(tickectNumber-1, true);
                return true;
            }
        }else{
            this.tickectHasUsed.set(tickectNumber-1, true);
            return true;
        }
        return false;
              
    }
}