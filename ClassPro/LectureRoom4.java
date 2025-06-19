import java.util.Scanner;

public class LectureRoom4 {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int numRoom = input.nextInt();
        int classCode[] = new int[numRoom];
        String[] name = new String[numRoom];
        int[] capacity = new int[numRoom];
        
        for(int i = 0; i <numRoom; i++){
            classCode[i] = input.nextInt();
            name[i]   = input.next();
            capacity[i]  = input.nextInt();
        }
        LectRoom lectroom = new LectRoom(classCode, name, capacity);
        int numBooking = input.nextInt();
        for(int i = 0; i<numBooking; i++){
            int classCodeWanted = input.nextInt();
            int bookSeat = input.nextInt();
            lectroom.reserveSeats(classCodeWanted, bookSeat);
        }
        input.close();
    }
}
class LectRoom{
    int[] classCode;
    String[] name;
    int[] capacity;
    int[] currentSeats;
    LectRoom(int[] classCode, String[] name, int[] capacity){
        this.classCode = classCode;
        this.name  = name;
        this.capacity = capacity;
        this.currentSeats = new int[this.classCode.length];
    }
    void printRoom(int room){
        System.out.println(classCode[room-1]+" "+name[room-1]+" "+capacity[room-1]);
    }
    boolean reserveSeats(int classCode, int bookSeat){
        for(int i = 0; i<this.classCode.length; i++){
            if(classCode == this.classCode[i]){
                if(currentSeats[i] + bookSeat <= capacity[i]){
                    System.out.println(name[i]);
                    currentSeats[i] += bookSeat;
                    return true;
                }
            }
        }
        System.out.println("sorry");
        return false;
        
    }
}

