import java.util.ArrayList;
import java.util.Scanner;

public class Covid19Wins1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String locationCode = input.nextLine();
        String dateUsingLocation = input.nextLine();
        int numUsing = input.nextInt();
        // ArrayList<Visitation> visits = new ArrayList<>(); 
        Visitation1 visitations = new Visitation1(locationCode, dateUsingLocation);
        for(int i = 0; i<numUsing; i++){
            int time = input.nextInt();
            visitations.visit(time);
        }
        visitations.printVisitHour();
        input.close();
    }
}
class Visitation1{
    String locationCode;
    String dateUsingLocation;
    ArrayList<Integer> timeUsingLocation;
    int sameHour = 0;
    Visitation1(String locationCode, String dateUsingLocation){
        this.locationCode = locationCode;
        this.dateUsingLocation = dateUsingLocation;
        this.timeUsingLocation = new ArrayList<>();
    }
    void visit(int time){
        if(time<0 || time>23){
            System.out.println("invalid hour: "+time);
            // return false;
        }else{
            boolean used = false;
            for(int t: this.timeUsingLocation){
                if(t == time){
                    sameHour ++;
                    used = true;
                    break;
                }
            }
            if(!used){
                this.timeUsingLocation.add(time);
            }
            
        }
        
        // return true;
    }
    int count(){
        return this.timeUsingLocation.size()+sameHour;
    }
    void printVisitHour(){
        System.out.println(locationCode);
        System.out.println(dateUsingLocation);
        System.out.println(count());
        if(count()==0){
            System.out.println("no visit");
        }else{
            for(int i = 0; i<timeUsingLocation.size(); i++){
                for(int j = i; j<timeUsingLocation.size(); j++){
                    if(timeUsingLocation.get(i) > timeUsingLocation.get(j)){
                        int temp = timeUsingLocation.get(i);
                        timeUsingLocation.set(i, timeUsingLocation.get(j));
                        timeUsingLocation.set(j, temp);
                    }
                }
            }
            for(int time: timeUsingLocation){
                System.out.print(time+" ");
            }
        }
    }
}