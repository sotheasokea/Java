
import java.util.ArrayList;
import java.util.Scanner;

public class RecordofRagnarok {
    private static void battleROR(HumanCharacters humans,GodCharacters gods, int round) {
        System.out.println("<>---------- Record of Ragnarok ----------<>");
        System.out.println("<< { --------- ROUND ( " + round + " ) --------- } >>");
        System.out.println("<<==== GOD ====>>");
        System.out.println("Name : " + gods.godName );
        System.out.println("Legend : [ " + gods.godLegend + " ]");
        System.out.println("- Abilities: " + gods.godAbility );
        System.out.println("- Personality: " + gods.godPersonality );
        System.out.println("- Background: " + gods.godBackground );
        System.out.println("VS");
        System.out.println("<<==== HUMAN ====>>");
        System.out.println("Name : " + humans.humanName );
        System.out.print("Age : " + humans.humanAge);
        if (humans.isAlive) {
        System.out.println(" at death");
        } else {
        System.out.println("");
        }
        System.out.println("- Abilities: " + humans.humanAbility);
        System.out.println("- Personality: " + humans.humanPersonality);
        System.out.println("- Background: " + humans.humanBackground);
        System.out.println("<< { --------- ROUND ( " + round + " ) --------- } >>");
        System.out.println("<>---------- Record of Ragnarok ----------<>");
 }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        String t = sc.nextLine();
        ArrayList<HumanCharacters> human = new ArrayList<>();
        ArrayList<GodCharacters>   god   = new ArrayList<>();
        
        for (int i = 0; i < round; i++) {
        String Age = null;
        boolean Death = false;
        String tmp1[] = sc.nextLine().split("Age: ");
        String Name = tmp1[0].substring(0, tmp1[0].length() - 2);
        if (tmp1[1].indexOf(" at death") > 0) {
        Death = true;
        Age = tmp1[1].substring(0, 2);
        } else if (tmp1[1].indexOf("Unknown") >= 0) {
        Age = "Unknown";
        } else {
        Age = tmp1[1].substring(0, 2);
        }
        String Abilities = sc.nextLine();
        String Personality = sc.nextLine();
        String Background = sc.nextLine();
        human.add(new HumanCharacters(Name, Age, Death, Abilities, Personality, Background));
        }
        for(int i = 0; i<round; i++){
            god.add(new GodCharacters(sc));
        }
            int count = 1;
            for (;;) {
            int h = sc.nextInt();
            int g = sc.nextInt();
            boolean booH = true;
            boolean booG = true;
            if (h<0 || h>=round) {
            booH = false;
            }
            if (g<0 || g>=round) {
            booG = false;
            }
            if (booH == true && booG == true) {
            RecordofRagnarok.battleROR(human.get(h), god.get(g), count);
            count++;
            } else {
            break;
            }
            }
        sc.close();
    }
}
class HumanCharacters{
    String humanName;
    String humanAge;
    boolean isAlive;
    String humanAbility;
    String humanPersonality;
    String humanBackground;
    
    HumanCharacters(String humanName,String humanAge,boolean isAlive,String humanAbility,String humanPersonality,String humanBackground){
        this.humanName = humanName;
        this.humanAge  = humanAge;
        this.isAlive   = isAlive;
        this.humanAbility = humanAbility;
        this.humanPersonality = humanPersonality;
        this.humanBackground = humanBackground;
    }
}
class GodCharacters{
    String godName;
    String godLegend;
    String godAbility;
    String godPersonality;
    String godBackground;

    GodCharacters(Scanner input) {
        String Legend = input.nextLine();
        int a = Legend.indexOf("(");
        int b = Legend.indexOf(")");
        this.godName = Legend.substring(0, a-1);
        this.godLegend = Legend.substring(a+1,b);
        this.godAbility = input.nextLine();
        this.godPersonality = input.nextLine();
        this.godBackground = input.nextLine();
    }

}