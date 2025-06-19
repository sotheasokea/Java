import java.util.ArrayList;
import java.util.Scanner;
public class Enrollment2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numStudentS = input.nextInt();
        ArrayList<StudentS> student = new ArrayList<>();
        for(int i = 0; i<numStudentS; i++){
            input.nextLine();
            int studentSID = input.nextInt();
            String firstname = input.next();
            String lastname  = input.next();
            student.add(new StudentS(studentSID,firstname, lastname));
        }
        input.nextLine();
        String subject = input.nextLine();
        int maxStudentS = input.nextInt();
        int numStudentSEnroll = input.nextInt();
        Course1 course = new Course1(subject, maxStudentS,student);
        ArrayList<Integer> studentSID = new ArrayList<>();
        for(int i = 0; i<numStudentSEnroll; i++){
            int ID = input.nextInt();
            boolean enrolled = course.enroll(ID);
            System.out.println(enrolled);
            
        }
        
        course.printInfo();

        input.close();
    }
}
class StudentS{
    String firstname;
    String lastname;
    int IDstudentS;
    StudentS(int studentSId, String firstname, String lastname){
        this.firstname = firstname;
        this.lastname  = lastname;
        this.IDstudentS = studentSId;
    }
    void printInfo(){
        System.out.print(firstname+" "+lastname+" ");
    }
}
class Course1{
    String subject;
    int maxStudent; 
    ArrayList<Integer> studentID;
    ArrayList<StudentS> student;
    Course1(String subject, int maxstudent, ArrayList<StudentS> student){
        this.subject = subject;
        this.maxStudent = maxstudent;
        this.studentID = new ArrayList<>();
        this.student =  new ArrayList<>(student);
    }
    boolean enroll(int idEnrolling){
        boolean found = false;
        int index = 0;
        for(int i = 0; i<this.student.size(); i++){
            if(idEnrolling == this.student.get(i).IDstudentS){
                found = true;
                index = i;
                break;
            }
        }
        if(!found){  
            System.out.print("Invalid ID ");
            return false;  
        }
        if(this.studentID.size() == maxStudent){
            return false;
        }
        for(int id: this.studentID){
            if(id == idEnrolling){
                return false;
            }
        }
        this.student.get(index).printInfo();
        this.studentID.add(idEnrolling);
        return true;
    }
    void printInfo(){
        System.out.println(subject+" "+studentID.size());
        for(int id: studentID){
            System.out.println(id);
        }
    }
}