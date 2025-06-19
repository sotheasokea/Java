
import java.util.Scanner;

public class FieldHospital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfBed = input.nextInt();
        FieldManager fm = new FieldManager(numOfBed);
        int numCommand = input.nextInt();
        for(int i = 0; i<numCommand; i++){
            int service = input.nextInt(); // 1 for book be, 2 for discharge, 3 for output the report
            int bed     = input.nextInt(); // bed = 0 for every service =1 ,3
            if(service == 1){
                int findBed = fm.reserveBed();
                if(findBed == -1){
                    System.out.println("No bed vacancy");
                }else{
                    System.out.println("Bed "+findBed+" reserved");
                }
            }else if(service == 2){
                fm.discharge(bed);
            }else if(service == 3){
                fm.reportBed();
            }
        }
        input.close();
    }
}
class FieldManager{
    int numOfBed;
    int[] bedStatus;

    public FieldManager(int numOfBed) {
        this.numOfBed = numOfBed;
        this.bedStatus = new int[this.numOfBed];
    }
    int reserveBed(){
        for(int i = 0; i<bedStatus.length; i++){
            if(bedStatus[i] == 0){
                bedStatus[i] = 1;
                return (i+1);
            }
        }
        return -1;
    }
    boolean discharge(int bedNumber){
        if(0< bedNumber && bedNumber <= numOfBed){
            if(bedStatus[bedNumber-1] == 1){
                System.out.println("Patient discharged");
                bedStatus[bedNumber-1] = 0;
                return true;
            }else{
                System.out.println("Invalid bed number");
                return false;
            }
        }else{
            System.out.println("Invalid bed number");
            return false;
        }
    }
    void reportBed(){
        int cnt = 0;
        for(int i = 0; i<bedStatus.length; i++){
            if(bedStatus[i] == 1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}