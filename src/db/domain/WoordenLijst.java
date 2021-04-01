package db.domain;

import domain.DomainException;

import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {

    private ArrayList<String> woorden;

    public WoordenLijst() {
        woorden = new ArrayList<>();
    }

    public void voegToe(String woord) {
        if (woord == null || woord.trim().isEmpty())
            throw new DomainException("Woord mag niet leeg zijn.");

        if (woorden.contains(woord))
            throw new DomainException("Woord staat al in lijst.");

        woorden.add(woord);
    }

    public int getAantalWoorden() {
        return woorden.size();
    }

    public String getRandomWoord() {
        if (woorden.isEmpty())
            throw new DomainException("Deze lijst bevat nog geen woorden.");

        return woorden.get(new Random().nextInt(woorden.size()-1));
    }
}
