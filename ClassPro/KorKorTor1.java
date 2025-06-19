
import java.util.ArrayList;
import java.util.Scanner;

public class KorKorTor1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfParty = input.nextInt();
        input.nextLine();
        Party[] party = new Party[numOfParty];
        for(int i = 0; i < numOfParty; i++){
            String partyName = input.next();
            int partyMember  = input.nextInt();
            input.nextLine();
            party[i] = new Party(partyName, partyMember);
        }
        for(int i = 0; i<numOfParty; i++){
            party[i] = new Party(party[i].partyName, party[i].partyMember, input);
        }
        int K = input.nextInt();
        for(int i = 0; i <K; i++){
            int partyNumber = input.nextInt();
            int disNumber   = input.nextInt();
            if(0 < partyNumber && partyNumber <= numOfParty){
                party[partyNumber-1].printInfo(disNumber);
            }
        }

        input.close();
    }
}
class Party{
    ArrayList<String> candidateFirstname;
    ArrayList<String> candidateSurname;
    ArrayList<Integer> districNumber;
    String partyName;
    int partyMember;
    Party(String partyName, int partyMember){
        this.partyName   = partyName;
        this.partyMember = partyMember;
    }
    Party(String partyName, int partyMember, Scanner input){
        this.partyName  = partyName;
        this.partyMember = partyMember;
        this.candidateFirstname = new ArrayList<>(partyMember);
        this.candidateSurname   = new ArrayList<>(partyMember);
        this.districNumber      = new ArrayList<>(partyMember);
        for(int i = 0; i < partyMember; i++){
            String firstname = input.next();
            String surname   = input.next();
            int disNumber    = input.nextInt();
            input.nextLine();
            candidateFirstname.add(firstname);
            candidateSurname.add(surname);
            districNumber.add(disNumber);
            
        }
    }
    void printInfo(int disNumber){
        if(disNumber < 0){
            System.out.println("invalid region number");
        }else if(disNumber == 0){
            for(int i = 0; i<this.partyMember; i++){
                System.out.println(candidateFirstname.get(i)+" "+candidateSurname.get(i)+" "+districNumber.get(i));
            }
        }else {
            boolean found = false;
            for(int i = 0; i<this.partyMember; i++){
                    if(districNumber.get(i) == disNumber){
                        System.out.println(candidateFirstname.get(i)+" "+candidateSurname.get(i));
                        found = true;
                    }
            }
            if(!found){
                System.out.println("none");
            }
        }
    }

}