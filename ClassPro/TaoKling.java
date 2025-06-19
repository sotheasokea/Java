import java.util.Scanner;

public class TaoKling{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    String phoneNo = sc.next();
    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    int n3 = sc.nextInt();
    String code = sc.next();
    TaoKlingOrder t = new TaoKlingOrder(phoneNo, n1,n2,n3,code);
    String phone = sc.next();
    String code1 = sc.next();
    boolean flag = t.grabOrder(phone,code1);
    System.out.println(flag);
    t.printInfo();
    }
}
class TaoKlingOrder{
    int numMilk;
    int numJuice;
    int numMineralWater;
    int total; // total money
    String phoneNo;
    String code; // 4 max password, "encrypted code"
    boolean complete;
    TaoKlingOrder(String phoneNo, int numMilk, int numJuice, int numMineralWater, String code){
        if(numMilk<0){
            numMilk = 0;
        }    
        if(numJuice<0){
            numJuice = 0;
        }
        if(numMineralWater < 0){
            numMineralWater = 0;
        }
        if(phoneNo.length() != 10 || phoneNo.charAt(0) != '0'){
            System.out.println("invalid phone number");
            phoneNo ="0#########";
        }
        this.numMilk = numMilk;
        this.numJuice = numJuice;
        this.numMineralWater = numMineralWater;
        this.phoneNo = phoneNo;
        this.code = code;
        this.total = numMilk*10 + numJuice*20 + numMineralWater*15;
    }
    boolean grabOrder(String phoneNo, String code){
        if(this.phoneNo.equals(phoneNo) && this.code.equals(code)){
            complete = true;
            return true;
        }
        complete = false;
        return false;
    }
    void printInfo(){
        if(complete){
            System.out.println(phoneNo+" "+numMilk+" "+numJuice+" "+numMineralWater+" "+total+" Y");
        }else{
            System.out.println(phoneNo+" "+numMilk+" "+numJuice+" "+numMineralWater+" "+total+" N");
        }
    }
}