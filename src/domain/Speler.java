package domain;

import java.util.Objects;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam){
        if(naam == null || naam.trim().isEmpty()){
            throw new DomainException("Naam mag niet null of leeg zijn");
        }
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int getal){
        if(score + getal < 0){
            throw new DomainException("score mag niet negatief zijn");
        }
        score += getal;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speler speler = (Speler) o;
        return score == speler.score &&
                Objects.equals(naam, speler.naam);
    }

    @Override
    public String toString() {
        return this.naam + " heeft als score: " + this.score;
    }
}
