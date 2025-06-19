public class  LectureRoom1{
    public static void main(String[] args) {
        LectRoom1 lectroom = new LectRoom1();
        System.out.println(lectroom.getCurrent_Seat());
    }
}
class LectRoom1{
    private int classCode;
    private String name;
    private int capacity;
    private int current_Seat = 3;
    LectRoom1(){
    }
    LectRoom1(int classCode, String name, int capacity){
        this.classCode = classCode;
        this.name  = name;
        this.capacity = capacity;
        this.current_Seat = 0;
    }
    int getCurrent_Seat(){
        return current_Seat;
    }
}