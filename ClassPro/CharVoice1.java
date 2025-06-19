
import java.util.Scanner;

public class CharVoice1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int numCharacter = input.nextInt();
        input.nextLine();
        Character1[] characters = new Character1[numCharacter];
        // using array of objects
        for(int i = 0; i<numCharacter; i++){
            String sentences = input.nextLine();
            characters[i] = new Character1(sentences);
        }
        int numSpeak = input.nextInt();
        int checkIndex = 0;
        for(int i = 0; i<numSpeak; i++){
            if(checkIndex < numCharacter){
                System.out.println(characters[checkIndex].speak());
                checkIndex++;
            }else{
                checkIndex = 0;
                System.out.println(characters[checkIndex].speak());
                checkIndex ++;
            }
        }

        input.close();
    }
}
class Character1{
    private String characterVoice;
    Character1(String characterVoice){
        this.characterVoice = characterVoice;
    }
    String speak(){
        return characterVoice;
    }
    // private ArrayList<String> characterVoice;
    // int tmep = 0;
    // Character(String[] characterVoice){
    //     this.characterVoice = new ArrayList<>(Arrays.asList(characterVoice));
    // }
    // void speak(){
    //         if(temp < this.characterVoice.size()){
    //             System.out.println(characterVoice.get(temp));
    //             temp++;
    //         }else{
    //             temp = 0;
    //             System.out.println(characterVoice.get(temp));
    //             temp++;
    //         }
    // }
}