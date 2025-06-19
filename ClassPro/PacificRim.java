
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PacificRim { 
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Jaeger j = null;
    Kaiju k = null;
    int typeK = sc.nextInt();
    sc.nextLine();
    if (typeK == 0) {
    k = new Kaiju();
    } else if (typeK == 1) {
    String name = sc.nextLine();
    k = new Kaiju(name);
    } else if (typeK == 2) {
    String name = sc.nextLine();
    String Category = sc.nextLine();
    int Height = sc.nextInt();
    int Weight = sc.nextInt();
    sc.nextLine();
    String strp = sc.nextLine();
    // sc.nextLine();
    String Power[] = strp.split(",");
    String Description = sc.nextLine();

    k = new Kaiju(name, Category, Height, Weight, Power, Description);
    }
    int typeJ = sc.nextInt();
    sc.nextLine();
    if (typeJ == 0) {
    j = new Jaeger();
    } else if (typeJ == 1) {
    // String t = sc.nextLine();
    String name = sc.nextLine();
    j = new Jaeger(name);
    } else if (typeJ == 2) {
    // String temp = sc.nextLine();
    String name = sc.nextLine();
    String CoO = sc.nextLine();
    int mark = sc.nextInt();
    double h = sc.nextDouble();
    sc.nextLine();
    String str = sc.nextLine();
    String strp[] = str.split(",");
    String str2 = sc.nextLine();
    String strw[] = str2.split(",");
    j = new Jaeger(name, CoO, mark, h, strp, strw);
    }
    System.out.println("====================");
    j.PrintDetail();
    System.out.println("VS");
    k.PrintDetail();
    System.out.println("====================");
    sc.close();
 }
}
class Kaiju{
    String kaijuname;
    String threatLevel;
    int kaijuHeight;
    int kaijuWeight;
    ArrayList<String> ability;
    String decription;
    Kaiju(){
        this.ability = new ArrayList<>();
        this.kaijuname = "Unknown";
        this.threatLevel = "Unknown";
        this.kaijuHeight = 0;
        this.kaijuWeight = 0;
        this.decription = "Unknown";

    }
    Kaiju(String kaijuName){
        this.kaijuname = kaijuName;
        this.ability = new ArrayList<>();
        this.threatLevel = "Unknown";
        this.kaijuHeight = 0;
        this.kaijuWeight = 0;
        this.decription = "Unknown";
    }

    Kaiju(String kaijuname, String threatLevel, int kaijuHeight, int kaijuWeight, String[] ability,  String decription) {
        this.kaijuname = kaijuname;
        this.threatLevel = threatLevel;
        this.kaijuHeight = kaijuHeight;
        this.kaijuWeight = kaijuWeight;
        if(ability.length !=0){
            this.ability = new ArrayList<>(Arrays.asList(ability));
        }else{
            this.ability = new ArrayList<>();
        }
        this.decription = decription;
    }
    void PrintDetail(){
        System.out.println("Kaiju : "+kaijuname);
        System.out.println("< Category: Category "+threatLevel+" >");
        if(kaijuHeight == 0){
            System.out.println("Height: Unknown");
        }else{
             System.out.println("Height: "+kaijuHeight+" feet ("+((double)kaijuHeight/3.2808) +" meters)");
        }
        if(kaijuWeight == 0){
            System.out.println("Weight: Unknown");
        }else{
            System.out.println("Weight: "+kaijuWeight+" tons");
        }
        if(ability.isEmpty() || ability == null){
            System.out.println("Power: Unknown");
        }else{
           System.out.println("Power: ["+ability.size()+"] :");
            for(String abl: ability){
                System.out.println(abl);
            }
        }
        System.out.println("Description: "+decription);
    } 
}

class Jaeger{
    String robotName;
    String countryName;
    int modelNumber;
    double robotHeight;
    ArrayList<String> driverName;
    ArrayList<String> weaponName;
    Jaeger(){
        this.driverName = new ArrayList<>();
        this.weaponName = new ArrayList<>();
        this.robotName  = "Unknown";
        this.countryName= "Unknown";
        this.robotHeight= 0.0;
        this.modelNumber= 0;
    }
    Jaeger(String robotName){
        this.robotName = robotName;
        this.driverName = new ArrayList<>();
        this.weaponName = new ArrayList<>();
        this.countryName= "Unknown";
        this.robotHeight= 0.0;
        this.modelNumber= 0;
    }

    public Jaeger(String robotName, String countryName, int modelNumber, double robotHeight, String[] driverName, String[] weaponName) {
        this.robotName = robotName;
        this.countryName = countryName;
        this.modelNumber = modelNumber;
        this.robotHeight = robotHeight;
        if(driverName.length !=0){
            this.driverName = new ArrayList<>(Arrays.asList(driverName));
        }else{
            this.driverName = new ArrayList<>();
        }
        if(weaponName.length != 0){
            this.weaponName = new ArrayList<>(Arrays.asList(weaponName));
        }else{
            this.weaponName = new ArrayList<>();
        }
    }
    void PrintDetail(){
        System.out.println("Jaegers : "+robotName);
        System.out.println("< Country of Origin: "+countryName+" >");
        if(modelNumber == 0){
            System.out.println("< Mark: Unknown >");
        }else{
            System.out.println("< Mark: Mark-"+modelNumber+" >");
        }
        if(robotHeight == 0.0){
            System.out.println("Height: Unknown");
        }else{
            System.out.println("Height: "+robotHeight+" meters");
        }
        if(driverName.isEmpty() || driverName.isEmpty()){
            System.out.println("Pilots: Unknown");    
        }else{
            System.out.println("Pilots: ["+driverName.size()+"] :");
            for(String driver: driverName){
                System.out.println(driver);
            }
        }if(weaponName.isEmpty() || weaponName == null){
            System.out.println("Weapons: Unknown");
        }
        else{
            System.out.println("Weapons: ["+weaponName.size()+"] :");
            for(String weapon: weaponName){
                System.out.println(weapon);
            }
        }
        
    }
}