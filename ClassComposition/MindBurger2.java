import java.util.Scanner;

public class MindBurger2 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String meatorder = sc.next();
        String veg = sc.next();
        int n = sc.nextInt();
        boolean flag_lettuce =  (veg.charAt(0)=='Y'?true:false);
        boolean flag_tomato =   (veg.charAt(1)=='Y'?true:false);
        boolean flag_pickled =  (veg.charAt(2)=='Y'?true:false);
        BurgerS b = new BurgerS(meatorder, flag_lettuce, flag_tomato, flag_pickled, n);
        int choice = sc.nextInt();
        int ffsize = sc.nextInt();
        setBurger sets = new setBurger(b, choice, ffsize);
        sets.printInfo();
        // b.printInfo();
    }
} 

class setBurger{
    BurgerS burger;
    static String[] beverageChoice ={"","Coke","Sprite","GreenTea","Lemonade"};
    String beverage;
    int ffsize;
    //french fried size: 0 no, 1 small, 2 medium, 3 large
    double basePrice;
    int discount;
    setBurger(BurgerS burger, int choice, int ffsize){
        this.burger = burger;
        int numBeverage = -1;
        int haveWater = 0;
        if(0<= choice && choice <beverageChoice.length){
            numBeverage = choice;
        }else{
            numBeverage = 4;
            System.out.println("invalid choice of beverage, then let try lemonade");
        }
        if(numBeverage != 0){
            haveWater =1;
        }
        this.beverage = beverageChoice[numBeverage];
        if(0<= ffsize && ffsize<=3){
            this.ffsize = ffsize;
        }else{
            this.ffsize = 1;
            System.out.println("invalid size of fries, then take a small one");
        }

        double friesPrice = (this.ffsize == 1) ? 15 : (this.ffsize == 2) ? 30 : (this.ffsize == 3) ? 45 : 0;
        double beveragePrice = (numBeverage != 0) ? 39 : 0;
        basePrice = burger.price + beveragePrice + friesPrice;
        boolean hasBeverage = !beverage.isEmpty();
        boolean hasFries = this.ffsize > 0;
        // System.out.println(basePrice);
        if (hasBeverage && hasFries) {
            discount = 25;
        } else if (hasBeverage || hasFries) {
            discount = 10;
        } else {
            discount = 0;
        }

        basePrice = basePrice * ((1 - discount)/ 100);
    }
    void printInfo(){
        System.out.println(burger.price+":"+ (!beverage.equals("")? 39: 0)+":"+ffsize);
        System.out.print(burger.meat);
        if(!beverage.equals("")){
            System.out.print("+"+beverage);
        }
        if(ffsize == 0){
            System.out.print(" = $");
        }else{
            System.out.print("+fries ");
            if(ffsize == 1){
                System.out.print("S = $");
            }else if(ffsize == 2){
                System.out.print("M = $");
            }else if(ffsize == 3){
                System.out.print("L = $");
            }
        }
        System.out.println(basePrice);
    }
}
// Source code is decompiled from a .class file using FernFlower decompiler.
class BurgerS {
    String meat;
    boolean lettuce;
    boolean tomato;
    boolean pickled;
    int numCheese;
    double price;
 
    BurgerS(String meat, boolean lettuce, boolean tomato, boolean pickled, int num) {
       this.meat = meat + "BURGER";
       this.lettuce = lettuce;
       this.tomato = tomato;
       this.pickled = pickled;
       if (num < 0) {
          this.numCheese = 0;
       } else if (num > 3) {
          this.numCheese = 3;
       } else {
          this.numCheese = num;
       }
 
       this.price = (double)(49 + 20 * this.numCheese);
    }
 
    void printInfo() {
       System.out.print(this.meat);
       if (this.lettuce) {
          System.out.print(" lettuce");
       }
 
       if (this.tomato) {
          System.out.print(" tomato");
       }
 
       if (this.pickled) {
          System.out.print(" pickled");
       }
 
       System.out.print(" cheese" + this.numCheese);
       System.out.print(" = $" + this.price);
    }
 }
 