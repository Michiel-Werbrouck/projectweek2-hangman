package domain;

import static java.lang.Character.toLowerCase;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter){
        this.letter = toLowerCase(letter);
        isGeraden= false;
    }

    public char getLetter() {
        return letter;
    }

    public boolean raad(char letter){
        if (isGeraden){
            return false;
        }
        if(toLowerCase(letter)==this.letter){
            isGeraden=true;
        }
        return isGeraden;
    }

    public char toChar(){
        if(isGeraden){
            return letter;
        }
        else{
            return '_';
        }
    }

    public boolean isGeraden() {
        return isGeraden;
    }
}
