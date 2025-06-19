import java.util.ArrayList;
import java.util.Scanner;
public class Covid19Wins2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numLocation = input.nextInt();
        ArrayList<Visitation> visitations = new ArrayList<>();
        for(int i = 0; i<numLocation; i++){
            int locationCode = input.nextInt();
            String locationName = input.nextLine();
            locationName = locationName.substring(1);
            if(locationName.length() >=6 &&(locationCode>=1 && locationCode<=300)){
                int cnt = 0;
                boolean found = false;
                for(Visitation v: visitations){
                    if(locationCode == v.locationCode){
                        visitations.get(cnt).locationName = locationName;
                        found = true;
                        break;
                    }
                    cnt++;
                }
                if(!found)  visitations.add(new Visitation(locationName,locationCode));
            }
            
        }
        String patientName = input.nextLine();
        Person persons = new Person(patientName);
        

        int numUsingLocation = input.nextInt();
        for(int i = 0; i<numUsingLocation; i++){
            int locationCode = input.nextInt();
            input.nextLine();
            String dateUsingLocation = input.nextLine();
            int numUsingHour = input.nextInt();
            boolean foundLocation = false;
            int locNum = 0;
            Visitation visits = new Visitation("", locationCode);
            for(int l= 0; l<visitations.size(); l++){
                if(locationCode == visitations.get(l).locationCode){
                    foundLocation = true;
                    visits.locationName = visitations.get(l).locationName;
                    visits.dateUsingLocation = dateUsingLocation;
                    locNum = l;
                    break;
                }
                
            }
                for(int h = 0; h<numUsingHour; h++){
                    int time = input.nextInt();
                    if(!foundLocation){
                        continue;
                    }
                    visits.visit(time);  
                }
            if(foundLocation) persons.addVisitation(visits);
        }
        System.out.println(persons.using);
        persons.printAllVisitations();

        input.close();
    }
}

class Person{
    String patientName;
    ArrayList<Visitation> visits = new ArrayList<>();
    int using = 0;
    Person(String patientName){
        this.patientName = patientName;
    }
    void addVisitation(Visitation visits){
        if(visits.count() >0){
            this.visits.add(visits);
            using++;
        }
    }
    void printAllVisitations(){ 
        for(Visitation v: visits){
            System.out.println(v.locationName);
            v.printVisitHour();
        }
        
          
    }
}
class Visitation{
    String locationName;
    int locationCode;
    String dateUsingLocation;
    ArrayList<Integer> timeUsingLocation = new ArrayList<>();;
    int sameHour = 0;
    Visitation(String locationName, int locationCode){
        if(locationName.length() >= 6 &&(locationCode>=1 && locationCode <= 300)){
            this.locationCode = locationCode;
            this.locationName= locationName;
            
        }

    }
    void visit(int time){
        if(time<0 || time>23){
            System.out.println("invalid hour: "+time);
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
    }
    int count(){
        return this.timeUsingLocation.size()+sameHour;
    }
    void printVisitHour(){
        // System.out.println(locationCode);
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
            System.out.println();
        }
    }
}