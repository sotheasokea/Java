public class LectureRoom2 {
    public static void main(String[] args) {
        LectRoom2 lectroom;
    }
}
class LectRoom2{
    int classCode;
    String name;
    int capacity;
    int current_Seat;
    LectRoom2(int classCode, String name, int capacity){
        this.classCode = classCode;
        this.name  = name;
        this.capacity = capacity;
        this.current_Seat = 0;
    }
    boolean reserveSeats(int bookSeat){
        if(bookSeat + current_Seat > capacity){
            return false;
        }
        current_Seat += bookSeat;
        return true;
    }
}
