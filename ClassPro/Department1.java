
import java.util.Scanner;

public class Department1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int employee = input.nextInt();
        int student  = input.nextInt();
        Dept info1 = new Dept(employee, student);
        info1.computeIncome(employee, student);
        info1.printReport();
        input.close();
        
    }
}
class Dept{
    int employee;
    int student;
    int ministryBudget;
    int eduFee;
    int seviceFee;
    int donation;
    //department2
    int salary;
    int electricity;
    int eduCost;
    int totalExpense;
    int profitOrLoss;
    int totalIncome;

    public Dept(int employee, int student) {
        this.employee = employee;
        this.student = student;
    }
    void computeIncome(int employee, int student){
        this.ministryBudget = employee*500000 + student*3000;
        this.eduFee = student*5000;
        this.seviceFee = 300000;
        this.donation = 100000;
        //departemt 2
        this.totalIncome = ministryBudget + eduFee + seviceFee + donation;
    }
    void printReport(){
        //
        System.out.println("total income = "+totalIncome);
        System.out.println("total expense = "+totalExpense);
        System.out.println("income - expense = "+(totalIncome-totalExpense));
        //
        System.out.println("ministry budget = "+ministryBudget);
        System.out.println("education fee = "+eduFee);
        System.out.println("service fee = "+seviceFee);
        System.out.println("donation = "+donation);
        //
        System.out.println("salary = "+salary);
        System.out.println("electricity = "+electricity);
        System.out.println("educational cost = "+eduCost);

    }
    //department2
    void computeExpense(int employee,int student){
        this.salary = employee*600000;
        this.electricity = (student+employee)*2000;
        this.eduCost = student*4000;
        totalExpense = salary + electricity + eduCost;
    }
    
}
