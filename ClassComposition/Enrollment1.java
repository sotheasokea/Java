
import java.util.ArrayList;
import java.util.Scanner;

public class Enrollment1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String subject = input.nextLine();
        int maxStudent = input.nextInt();
        int numStudentEnroll = input.nextInt();
        Course course = new Course(subject, maxStudent);
        for(int i = 0; i<numStudentEnroll; i++){
            int studentID = input.nextInt();
            System.out.println(course.enroll(studentID));
        }
        course.printInfo();

        input.close();
    }
}
class Course{
    String subject;
    int maxStudent; 
    ArrayList<Integer> studentID;
    Course(String subject, int maxstudent){
        this.subject = subject;
        this.maxStudent = maxstudent;
        this.studentID = new ArrayList<>();
    }
    boolean enroll(int stuIDenroll){
        if(this.studentID.size() == maxStudent){
            return false;
        }
        for(int id: this.studentID){
            if(id == stuIDenroll){
                return false;
            }
        }
        this.studentID.add(stuIDenroll);
        return true;
    }
    void printInfo(){
        System.out.println(subject+" "+studentID.size());
        for(int id: studentID){
            System.out.println(id);
        }
    }
}