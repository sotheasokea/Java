
import java.util.ArrayList;
import java.util.Scanner;

public class Chabubu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numSet = input.nextInt();   input.nextLine();
        ArrayList<Combo> combos = new ArrayList<>();
        for(int i = 0; i<numSet; i++){
            String setName = input.next();
            int beef = input.nextInt();
            int pork = input.nextInt();
            int vegetable = input.nextInt();
            int seaFood = input.nextInt();
            if(Combo.isValid(beef, pork, vegetable, seaFood)){
                System.out.println("valid");
                combos.add(new Combo(setName, beef, pork, vegetable, seaFood));
            }else{
                System.out.println("invalid");
            }
        }
        for(Combo set: combos){
            set.printInfo();
        }
        input.close();
    }
}
class Combo{
    private String comboSetname;
    private int beef;
    private int pork;
    private int vegetable;
    private int seaFood;
    private int setPrize;

    static boolean  isValid(int beef, int pork, int vegetable, int seaFood){
        return (4 <=beef+pork+vegetable+seaFood && beef+pork+vegetable+seaFood <= 15);
    }

    Combo(String comboSetname, int beef, int pork, int vegetable, int seaFood) {
        this.comboSetname = comboSetname;
        this.beef = beef;
        this.pork = pork;
        this.vegetable = vegetable;
        this.seaFood = seaFood;
        this.setPrize = (this.beef+this.pork+this.seaFood)*60 + (this.vegetable*30);
    }
    void printInfo(){
        System.out.println(comboSetname+" Beef "+beef+" Pork "+pork+" Veg "+vegetable+" Seafood "+seaFood+" Price "+setPrize);
    }
    

}