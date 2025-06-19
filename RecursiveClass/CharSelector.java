
import java.util.Scanner;

public class CharSelector {
    String selectChar(String word, int[] move, int index){
        // System.out.println(word);
        if(index == 0)  return String.format("%c", word.charAt(0));
        int newIndex = index - move[index];
        // System.out.println(index+" "+newIndex);
        if(newIndex < 0){
            if(Math.abs(newIndex)>= word.length()){
                newIndex = index;
            }else{
                newIndex = word.length()+newIndex;
            }
    
        }
        // System.out.println(word.charAt(newIndex));
        String newWord = "";
        for(int i = 0; i<word.length(); i++){
            if(i == index){
                newWord += word.charAt(newIndex);
                continue;
            }
            newWord += word.charAt(i);
        }
        return String.format("%c", word.charAt(newIndex))+selectChar(newWord, move, index-1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word   = input.nextLine();
        int[] move    = new int[word.length()];
        for(int i = 0; i<word.length(); i++){
            move[i] = input.nextInt();
        }
        CharSelector selector = new CharSelector();
        StringBuffer newWord = new StringBuffer(selector.selectChar(word, move, word.length()-1));
        System.out.println(newWord.reverse());
        input.close();
    }
}
