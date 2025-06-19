
import java.util.Scanner;

public class LectureRoom3 {
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
        LectRoom3 lectroom = new LectRoom3(classCode, name, capacity);
        for(int i = 0; i<3; i++){
            int room = input.nextInt();
            lectroom.printRoom(room);
        }
        input.close();
    }
}
class LectRoom3{
    int[] classCode;
    String[] name;
    int[] capacity;
    int current_Seat;
    LectRoom3(int[] classCode, String[] name, int[] capacity){
        this.classCode = classCode;
        this.name  = name;
        this.capacity = capacity;
        this.current_Seat = 0;
    }
    void printRoom(int room){
        System.out.println(classCode[room-1]+" "+name[room-1]+" "+capacity[room-1]);
    }
    // boolean reserveSeats(int bookSeat){
    //     if(bookSeat + current_Seat > capacity){
    //         return false;
    //     }
    //     current_Seat += bookSeat;
    //     return true;
    // }
}

