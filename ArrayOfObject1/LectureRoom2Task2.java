
import java.util.ArrayList;
import java.util.Scanner;

public class LectureRoom2Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numRoom = input.nextInt();
        ArrayList<LectureRoom> classroom = new ArrayList<LectureRoom>();
        for(int i = 0; i<numRoom; i++){
            int classCode = input.nextInt();
            // input.nextLine();
            String name = input.next();
            int capacity= input.nextInt();
            // adding each info to the object
            classroom.add(new LectureRoom(classCode, name, capacity));
        }
        int numRequest = input.nextInt();
        for(int r = 0; r<numRequest; r++){
            int codeOfclass = input.nextInt();
            int numReservedSeat = input.nextInt();
            boolean found = false;
            // checking the request with the room we have
            for(int i = 0; i<classroom.size(); i++){
                if(classroom.get(i).reserveSeats(codeOfclass, numReservedSeat)){
                    found = true;
                    System.out.println(classroom.get(i).getClassName());
                    break;
                }
            }
            if(!found){
                System.out.println("sorry");
            }
        }

        input.close();
    }
}
class LectureRoom{
    private int classCode;
    private String name;
    private int capacity;
    private int currentSeat;
    LectureRoom(int classCode, String name, int capacity){
        this.classCode = classCode;
        this.name  = name;
        this.capacity = capacity;
        this.currentSeat = 0;
    }
    String getClassName(){
        return name;
    }
    boolean reserveSeats(int classCode, int bookSeat){
        
        if(this.classCode != classCode || bookSeat + currentSeat > capacity){
            return false;
        }
        currentSeat += bookSeat;
        return true;
    }
}
