package domain;

import domain.*;
import java.util.Objects;

public class LijnStuk extends Vorm {
    private Punt startPunt;
    private Punt eindPunt;
    private Omhullende omhullende;

    public LijnStuk(Punt startPunt, Punt eindPunt){
        setStartPuntEnEindPunt(startPunt, eindPunt);
        this.omhullende = new Omhullende(startPunt,eindPunt.getX() - startPunt.getX(),startPunt.getX());
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public void setStartPuntEnEindPunt(Punt startPunt, Punt eindPunt) {
        if (startPunt==null || eindPunt==null){
            throw new DomainException("Start en eindpunt mag niet null zijn.");
        }
        if (startPunt==eindPunt){
            throw new DomainException("Start en eindpunt mag niet gelijk zijn.");
        }
        this.startPunt = startPunt;
        this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LijnStuk lijnStuk = (LijnStuk) o;
        return Objects.equals(startPunt, lijnStuk.startPunt) &&
                Objects.equals(eindPunt, lijnStuk.eindPunt);

    }

    @Override
    public int hashCode() {
        return Objects.hash(startPunt, eindPunt);
    }

    @Override
    public String toString() {
        return "Lijn: startpunt: " + startPunt + " - eindPunt: " + eindPunt + "\n" + omhullende.toString();
    }


    @Override
    public Omhullende getOmhullende() {
        return omhullende;
    }
}
