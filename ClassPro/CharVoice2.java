import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CharVoice2 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Character[] characters = new Character[n];
        for(int i = 0; i<n; i++){
            int numCharacter = input.nextInt();
            input.nextLine();
            String sentences[] = new String[numCharacter];
                for(int k = 0; k<numCharacter; k++){
                    sentences[k] = input.nextLine();
                }
            characters[i] = new Character(sentences);
        }
        int numSpeak = input.nextInt();
        for(int k = 0; k<numSpeak; k++){
            int objNum = input.nextInt();
            characters[objNum-1].speak();
        }

        input.close();
    }
}
class Character{
    int temp = 0;
    private ArrayList<String> characterVoice;
    Character(String[] characterVoice){
        this.characterVoice = new ArrayList<>(Arrays.asList(characterVoice));
    }
    void speak(){
            if(temp < this.characterVoice.size()){
                System.out.println(characterVoice.get(temp));
                temp++;
            }else{
                temp = 0;
                System.out.println(characterVoice.get(temp));
                temp++;
            }
    }
}
