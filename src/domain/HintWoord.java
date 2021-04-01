package domain;

import java.util.ArrayList;

public class HintWoord {
    private ArrayList<HintLetter> hintwoord = new ArrayList<>(0);

    public HintWoord(String woord){
        if(woord==null || woord.trim().isEmpty()){
            throw new DomainException("Gegeven woord is niet geldig.");
        }
        for (int i=0; i<woord.length(); i++){
            hintwoord.add(new HintLetter(woord.charAt(i)));
        }
    }

    public boolean raad(char geradenLetter){
        boolean bool = false;
        for (HintLetter letter : hintwoord){
            if(letter.raad(geradenLetter)){
                letter.raad(geradenLetter);
                bool = true;
            }
        }
        return bool;
    }

    public boolean isGeraden(){
        boolean bool = true;
        for (HintLetter letter : hintwoord){
            if (!letter.isGeraden()) {
                bool = false;
                break;
            }
        }
        return bool;
    }

    public String getWoord() {
        StringBuilder sb = new StringBuilder();
        for (HintLetter s : hintwoord) {
            sb.append(s.getLetter());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<hintwoord.size(); i++){
            if(hintwoord.get(i).isGeraden()){
                result.append(hintwoord.get(i).getLetter());
            }
            else{
                result.append("_");
            }
            if(i!=hintwoord.size()-1){
                result.append(" ");
            }
        }
        return String.valueOf(result);
    }
}
