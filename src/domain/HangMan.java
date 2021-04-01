package domain;

import db.domain.WoordenLijst;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan = new TekeningHangMan();
    private WoordenLijst woordenLijst;
    private HintWoord hintWoord;
    private boolean gewonnen;
    private boolean gameOver;

    public HangMan(Speler speler, WoordenLijst woordenLijst){
        if(speler == null){
            throw new DomainException("Speler mag niet leeg zijn");
        }
        this.speler = speler;
        if(woordenLijst == null){
            throw new DomainException("Woordenlijst mag niet leeg zijn");
        }
        this.woordenLijst = woordenLijst;

        setWoord(woordenLijst.getRandomWoord());
    }


    public void setWoord(String woord) {
        this.hintWoord = new HintWoord(woord);
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }

    public String getHint() {
        return hintWoord.toString();
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public boolean raad(char letter){
        return hintWoord.raad(letter);
    }
}
