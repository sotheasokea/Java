
import java.util.Scanner;

public class ConsecDupRemoval {
    String dupRamove(String word){
        if(word.length() == 1){
            return word;
        }
        if(word.charAt(0) != word.charAt(1)){
            // if(word.length() == 2){
            //     return word;
            // }
            return String.format("%c", word.charAt(0))+dupRamove(word.substring(1));
        }
        return dupRamove(word.substring(1));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word   = input.nextLine();
        ConsecDupRemoval remove = new ConsecDupRemoval();
        String newWord= remove.dupRamove(word);
        System.out.println(newWord);
        input.close();
    }
}
