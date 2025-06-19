
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KorKorTor2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int numOfPartyName = input.nextInt();
        input.nextLine();
        String[] partyName = new String[numOfPartyName];
        for(int i = 0; i<numOfPartyName; i++){
            partyName[i] = input.nextLine();
        }
        Precinct precinct = new Precinct(name, partyName);
        int numPeopleToVote = input.nextInt();
        for(int i = 0; i<numPeopleToVote; i++){
            int command = input.nextInt(); // 1= vote, 2= printInfo, 3= printMax
            switch (command) {
                case 1:
                    int numberOfParty = input.nextInt();
                    precinct.count(numberOfParty);
                    break;
                case 2:
                    precinct.printInfo();
                    break;
                case 3:
                    precinct.printMax();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        input.close();
    }
}
class Precinct{
    String name;
    ArrayList<String> partyName;
    int[] cntVotes;

    Precinct(String name, String[] partyName){
        this.name = name;
        this.partyName = new ArrayList<>(Arrays.asList(partyName));
        this.cntVotes  = new int[this.partyName.size()];
        for(int i = 0; i<cntVotes.length; i++){
            cntVotes[i] = 0;
        }
    }
    void count(int partyNumber){
        if(partyNumber > 0 && partyNumber <= partyName.size()){
            cntVotes[partyNumber-1] += 1;
            System.out.println(partyName.get(partyNumber-1)+" "+cntVotes[partyNumber-1] );
        }else{
            System.out.println("invalid number");
        }
    }
    void printInfo(){
        for(int i = 0; i<partyName.size(); i++){
            System.out.println((i+1) + " "+partyName.get(i)+" "+cntVotes[i] );
        }
    }
    void printMax(){
        int maxVote = Integer.MIN_VALUE;
        for(int vote : cntVotes){
            if(vote > maxVote){
                maxVote = vote;
            }
        }
        for(int i = 0; i<partyName.size(); i++){
            if(cntVotes[i]  == maxVote){
                System.out.println((i+1) + " "+ partyName.get(i)+" "+cntVotes[i] );
            }
        }
    }
}