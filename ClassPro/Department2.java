
import java.util.Scanner;

public class Department2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int employee = input.nextInt();
        int student  = input.nextInt();
        Dept info2 = new Dept(employee, student);
        // using the same Dept class from department 1;
        info2.computeIncome(employee, student);
        info2.computeExpense(employee, student);
        info2.printReport();
        input.close();
    }
}
